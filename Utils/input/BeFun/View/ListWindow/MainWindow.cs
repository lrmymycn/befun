using System;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model;
using BeFun.Model.Query;
using BeFun.View.Component.Common;
using System.Collections.Generic;
using BeFun.Model.Dao;
using BeFun.View.Resize;
using BeFun.Model.Domain;
using System.IO;
using BeFun.Model.Resize;
using BeFun.View.SQL;
using BeFun.Controller.OldVersionTrans;

namespace BeFun.View.ListWindow
{
    public partial class MainWindow : Form
    {
        private string filePath = null;

        public ProjectQueryCondition queryCondition { get; set; }

        private StageDao stageDao = new StageDao();
        private BuildingDao buildingDao = new BuildingDao();
        private FloorplanDao floorplanDao = new FloorplanDao();
        private MediaDao mediaDao = new MediaDao();

        public MainWindow()
        {
            this.queryCondition = null;
            InitializeComponent();
            //this.filePath = "F:\\Personal\\lhl\\input\\project.accdb";
            try
            {
                //this.filePath = PathUtils.getAbstractPath("project.dat");
                //this.initConnection();
                this.ConfigDataGridView();
                //this.dataGridView.RefreshGrid();
            }
            catch (Exception ex)
            {
                MyMessageBox msgBox = new MyMessageBox("Open windows error!", ex, MyConstants.BOX_TYPE_ERROR);
                msgBox.ShowDialog(this);
            }
        }

        private void initConnection()
        {
            if (this.filePath != null)
            {
                ConnectionPool.getInstance().init(this.filePath);
                this.toolStripMenuItem_Query.Enabled = true;
                this.toolStripMenuItem_Watermark.Enabled = true;
                this.sQLToolToolStripMenuItem.Enabled = true;
                this.oldVersionTransToolStripMenuItem.Enabled = true;
            }
        }

        private void ConfigDataGridView()
        {
            IList<System.Windows.Forms.ToolStripMenuItem> extendedItems = new List<System.Windows.Forms.ToolStripMenuItem>();
            //stage
            System.Windows.Forms.ToolStripMenuItem queryStageItem = new System.Windows.Forms.ToolStripMenuItem();
            queryStageItem.Name = "toolStripMenuItem_QueryStage";
            queryStageItem.Size = new System.Drawing.Size(152, 22);
            queryStageItem.Text = "Query S&tage";
            queryStageItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryStage_Click);
            extendedItems.Add(queryStageItem);
            //building
            System.Windows.Forms.ToolStripMenuItem queryBuildingItem = new System.Windows.Forms.ToolStripMenuItem();
            queryBuildingItem.Name = "toolStripMenuItem_QueryBuilding";
            queryBuildingItem.Size = new System.Drawing.Size(152, 22);
            queryBuildingItem.Text = "Query &Building";
            queryBuildingItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryBuilding_Click);
            extendedItems.Add(queryBuildingItem);
            //floorplan
            System.Windows.Forms.ToolStripMenuItem queryFloorplanItem = new System.Windows.Forms.ToolStripMenuItem();
            queryFloorplanItem.Name = "toolStripMenuItem_QueryFloorplan";
            queryFloorplanItem.Size = new System.Drawing.Size(152, 22);
            queryFloorplanItem.Text = "Query &Floorplan";
            queryFloorplanItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryFloorplan_Click);
            extendedItems.Add(queryFloorplanItem);
            //apartment
            System.Windows.Forms.ToolStripMenuItem queryApartmentItem = new System.Windows.Forms.ToolStripMenuItem();
            queryApartmentItem.Name = "toolStripMenuItem_QueryFloorplan";
            queryApartmentItem.Size = new System.Drawing.Size(152, 22);
            queryApartmentItem.Text = "Query A&partment";
            queryApartmentItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryApartment_Click);
            extendedItems.Add(queryApartmentItem);
            //media
            System.Windows.Forms.ToolStripMenuItem queryMediaItem = new System.Windows.Forms.ToolStripMenuItem();
            queryMediaItem.Name = "toolStripMenuItem_QueryMedia";
            queryMediaItem.Size = new System.Drawing.Size(152, 22);
            queryMediaItem.Text = "Query &Media";
            queryMediaItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryMedia_Click);
            extendedItems.Add(queryMediaItem);

            IList<System.Windows.Forms.ToolStripMenuItem> alwaysExtendedItems = new List<System.Windows.Forms.ToolStripMenuItem>();
            //resize
            System.Windows.Forms.ToolStripMenuItem resizeItem = new System.Windows.Forms.ToolStripMenuItem();
            resizeItem.Name = "toolStripMenuItem_ResizeMedias";
            resizeItem.Size = new System.Drawing.Size(152, 22);
            resizeItem.Text = "Resize";
            resizeItem.Click += new System.EventHandler(this.toolStripMenuItem_Resize_Click);
            alwaysExtendedItems.Add(resizeItem);

            this.dataGridView.extendedToolStripMenuItems = extendedItems;
            this.dataGridView.alwaysExtendedToolStripMenuItems = alwaysExtendedItems;
            this.dataGridView.ConfigContextMenu();
        }

        private void toolStripMenuItem_QueryStage_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<string> ids = this.dataGridView.SelectedIds();
                StageQueryCondition qc = new StageQueryCondition();
                qc.project_id = ids[0];
                StageWindow queryWindow = new StageWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void toolStripMenuItem_QueryBuilding_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<string> ids = this.dataGridView.SelectedIds();
                BuildingQueryCondition qc = new BuildingQueryCondition();
                qc.project_id = ids[0];
                BuildingWindow queryWindow = new BuildingWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void toolStripMenuItem_QueryFloorplan_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<string> ids = this.dataGridView.SelectedIds();
                FloorplanQueryCondition qc = new FloorplanQueryCondition();
                qc.project_id = ids[0];
                FloorplanWindow queryWindow = new FloorplanWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void toolStripMenuItem_QueryApartment_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<string> ids = this.dataGridView.SelectedIds();
                ApartmentQueryCondition qc = new ApartmentQueryCondition();
                qc.project_id = ids[0];
                ApartmentWindow queryWindow = new ApartmentWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void toolStripMenuItem_QueryMedia_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<string> ids = this.dataGridView.SelectedIds();
                MediaQueryCondition qc = new MediaQueryCondition();
                qc.project_id = ids[0];
                MediaWindow queryWindow = new MediaWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void toolStripMenuItem_Resize_Click(object sender, EventArgs e)
        {
            IList<Project> selectedProjects = this.dataGridView.SelectedObjects();
            if (selectedProjects.Count > 0)
            {
                DirectoryInfo imgRootDir = new DirectoryInfo(PathUtils.GetImgRootPath());
                foreach (Project pro in selectedProjects)
                {
                    if (pro == null || string.IsNullOrWhiteSpace(pro.id))
                    {
                        continue;
                    }
                    string title = pro.name;
                    MediaQueryCondition mediaQC = new MediaQueryCondition();
                    mediaQC.project_id = pro.id;
                    IList<Media> medias = this.mediaDao.query(mediaQC);
                    ResizeTask task = new ResizeTask(imgRootDir, title, medias, this, ResizeConfig.getInstance());
                    task.t.Start();
                    if (task.pb.ShowDialog(this) == DialogResult.Cancel)
                    {
                        task.stopflag = true;
                    }
                }
            }
            else
            {
                return;
            }
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.Filter = "Access 文件(*.accdb)|*.accdb|所有文件(*.*)|*.*";
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.filePath = fileDialog.FileName;
                this.initConnection();
                this.dataGridView.RefreshGrid();
            }
        }

        private void toolStripMenuItem_Query_Media_Click(object sender, EventArgs e)
        {
            MediaWindow mediaWindow = new MediaWindow();
            mediaWindow.ShowDialog(this);
        }

        private void toolStripMenuItem_Query_Floorplan_Click(object sender, EventArgs e)
        {
            FloorplanWindow floorplanWindow = new FloorplanWindow();
            floorplanWindow.ShowDialog(this);
        }

        private void toolStripMenuItem_Query_Apartment_Click(object sender, EventArgs e)
        {
            ApartmentWindow apartmentWindow = new ApartmentWindow();
            apartmentWindow.ShowDialog(this);
        }

        private void stageToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StageWindow stageWindow = new StageWindow();
            stageWindow.ShowDialog(this);
        }

        private void buildingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            BuildingWindow buildingWindow = new BuildingWindow();
            buildingWindow.ShowDialog(this);
        }

        private void button_Search_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(this.textBox_BlockOrName.Text))
            {
                this.queryCondition = null;
            }
            else
            {
                this.queryCondition = new ProjectQueryCondition();
                this.queryCondition.blockOrName = this.textBox_BlockOrName.Text;
            }
            this.dataGridView.queryCondition = this.queryCondition;
            this.dataGridView.RefreshGrid();
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void outputToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog fd = new FolderBrowserDialog();
            if (fd.ShowDialog(this) == DialogResult.OK)
            {
                OutputUtils ou = new OutputUtils();
                ou.Output(fd.SelectedPath);
            }
        }

        private void watermarkToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ResizeForm resizeForm = new ResizeForm();
            resizeForm.ShowDialog(this);
        }

        private void sQLToolToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SQLForm sqlForm = new SQLForm();
            sqlForm.ShowDialog(this);
        }

        private void mediaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            IList<Media> medias = this.mediaDao.queryAll();
            MediaTransTask task = new MediaTransTask(medias, this);
            task.t.Start();
            if (task.pb.ShowDialog(this) == DialogResult.Cancel)
            {
                task.stopflag = true;
            }
        }

    }
}
