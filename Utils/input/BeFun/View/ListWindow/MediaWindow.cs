using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Model.Domain;
using BeFun.Common;
using BeFun.Model.Query;
using BeFun.Model.Dao;
using BeFun.View.Editor;
using System.IO;
using BeFun.Model.Resize;
using BeFun.Model;

namespace BeFun.View.ListWindow
{
    public partial class MediaWindow : Form
    {
        private ProjectDao projectDao = new ProjectDao();

        private FloorplanDao floorplanDao = new FloorplanDao();

        public ListWindowType windowType { get; set; }

        public Media currentEntity { get; set; }

        public IList<Media> currentEntities { get; set; }

        private IList<Project> projectList;
        private IList<Floorplan> floorplanList;
        private IList<ComboBoxItem> mediaTypeList;
        private IList<ComboBoxItem> contentTypeList;

        public MediaQueryCondition queryCondition { get; set; }

        public MediaWindow()
            : base()
        {
            this.queryCondition = null;
            currentEntity = null;
            this.windowType = ListWindowType.View;
            this.Init();
        }

        public MediaWindow(ListWindowType windowType)
        {
            this.queryCondition = null;
            currentEntity = null;
            this.windowType = windowType;
            this.Init();
        }

        public MediaWindow(MediaQueryCondition qc)
        {
            this.queryCondition = qc;
            currentEntity = null;
            this.windowType = ListWindowType.View;
            this.Init();
        }

        public MediaWindow(ListWindowType windowType, MediaQueryCondition qc)
        {
            this.queryCondition = qc;
            currentEntity = null;
            this.windowType = windowType;
            this.Init();
        }

        private void Init()
        {
            InitializeComponent();
            InitData();
            RefreshData();
            configComponent();
        }

        private void InitData()
        {
            projectList = this.projectDao.queryAll();
            projectList.Insert(0, Utils.getHeadProject());
            projectList.Insert(1, Utils.getNotLinkProject());
            this.bindingSource_Project.DataSource = projectList;
            if (this.queryCondition != null && !string.IsNullOrWhiteSpace(this.queryCondition.project_id))
            {
                this.comboBox_Query_Project.SelectedValue = this.queryCondition.project_id;
            }
            this.comboBox_Query_Project_SelectedIndexChanged(null, null);

            mediaTypeList = Utils.getMediaTypeList(true);
            this.bindingSource_MediaType.DataSource = mediaTypeList;
            if (this.queryCondition != null)
            {
                this.comboBox_Query_MediaType.SelectedValue = this.queryCondition.media_type;
            }

            contentTypeList = Utils.getContentTypeList(true);
            this.bindingSource_ContentType.DataSource = contentTypeList;
            if (this.queryCondition != null)
            {
                this.comboBox_Query_ContentType.SelectedValue = this.queryCondition.content_type;
            }
        }


        public void RefreshData()
        {
            this.dataGridView.queryCondition = this.queryCondition;
            this.dataGridView.RefreshGrid();
        }

        private void configComponent()
        {
            this.dataGridView.parentWindow = this;
            this.dataGridView.type = this.windowType;
            this.ConfigDataGridView();
        }

        private void ConfigDataGridView()
        {
            IList<System.Windows.Forms.ToolStripMenuItem> extendedItems = new List<System.Windows.Forms.ToolStripMenuItem>();
            //add multi medias
            System.Windows.Forms.ToolStripMenuItem addMultiMediasItem = new System.Windows.Forms.ToolStripMenuItem();
            addMultiMediasItem.Name = "toolStripMenuItem_AddMultiMedias";
            addMultiMediasItem.Size = new System.Drawing.Size(152, 22);
            addMultiMediasItem.Text = "Add Multi Medias";
            addMultiMediasItem.Click += new System.EventHandler(this.toolStripMenuItem_AddMultiMedias_Click);
            extendedItems.Add(addMultiMediasItem);

            //resize
            System.Windows.Forms.ToolStripMenuItem resizeItem = new System.Windows.Forms.ToolStripMenuItem();
            resizeItem.Name = "toolStripMenuItem_ResizeMedias";
            resizeItem.Size = new System.Drawing.Size(152, 22);
            resizeItem.Text = "Resize";
            resizeItem.Click += new System.EventHandler(this.toolStripMenuItem_Resize_Click);
            extendedItems.Add(resizeItem);

            this.dataGridView.alwaysExtendedToolStripMenuItems = extendedItems;
            this.dataGridView.ConfigContextMenu();
            this.dataGridView.RefreshGrid();
        }

        private void toolStripMenuItem_Resize_Click(object sender, EventArgs e)
        {
            IList<Media> selectedMedias = this.dataGridView.SelectedObjects();
            if (selectedMedias.Count > 0)
            {
                DirectoryInfo imgRootDir = new DirectoryInfo(PathUtils.GetImgRootPath());
                string title = "selected";
                ResizeTask task = new ResizeTask(imgRootDir, title, selectedMedias, this, ResizeConfig.getInstance());
                task.t.Start();
                if (task.pb.ShowDialog(this) == DialogResult.Cancel)
                {
                    task.stopflag = true;
                }
            }
            else
            {
                return;
            }
        }

        private void toolStripMenuItem_AddMultiMedias_Click(object sender, EventArgs e)
        {
            MultiMediaEditor editor = new MultiMediaEditor();
            editor.queryCondition = this.queryCondition;
            editor.renderWindow();
            editor.ShowDialog(this);
            this.RefreshData();
        }

        private void refreshToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.RefreshData();
        }

        private void button_Search_Click(object sender, EventArgs e)
        {
            this.queryCondition = new MediaQueryCondition();
            this.queryCondition.url = this.textBox_Query_Url.Text;
            this.queryCondition.project_id = (string)this.comboBox_Query_Project.SelectedValue;
            this.queryCondition.content_type = (Byte)this.comboBox_Query_ContentType.SelectedValue;
            this.queryCondition.media_type = (Byte)this.comboBox_Query_MediaType.SelectedValue;
            this.RefreshData();
        }

        private void comboBox_Query_Project_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Query_Project.SelectedValue != null)
            {
                FloorplanQueryCondition qc = new FloorplanQueryCondition();
                qc.project_id = (string)this.comboBox_Query_Project.SelectedValue;
                this.floorplanList = this.floorplanDao.query(qc);
                floorplanList.Insert(0, Utils.getHeadFloorplan());
            }
            else
            {
                this.floorplanList = new List<Floorplan>();
                floorplanList.Add(Utils.getHeadFloorplan());
            }
            this.bindingSource_Floorplan.DataSource = this.floorplanList;
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Close();
        }


    }
}
