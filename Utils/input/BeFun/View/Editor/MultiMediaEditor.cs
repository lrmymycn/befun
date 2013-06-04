using BeFun.Model.Dao;
using BeFun.Model.Domain;
using System.Data;
using System.Collections.Generic;
using BeFun.Common;
using System.Windows.Forms;
using System;
using System.IO;
using BeFun.View.Component.Common;
using System.Drawing;
using System.ComponentModel;
using BeFun.Model.Query;

namespace BeFun.View.Editor
{
    public partial class MultiMediaEditor : MyEditor
    {
        private ProjectDao projectDao = new ProjectDao();
        private MediaDao dao;

        private IList<string> mediaList = new List<string>();

        private IList<Project> projectList = new List<Project>();
        private IList<ComboBoxItem> mediaTypeList = new List<ComboBoxItem>();
        private IList<ComboBoxItem> contentTypeList = new List<ComboBoxItem>();
        public MediaQueryCondition queryCondition { get; set; }

        public MultiMediaEditor()
            : base()
        {
            this.dao = new MediaDao();
            InitializeComponent();
            InitData();
        }


        public MultiMediaEditor(MediaDao dao)
            : base()
        {
            this.dao = dao;
            InitializeComponent();
            InitData();
        }

        public override void saveEntity()
        {
            Byte contentType = (Byte)this.comboBox_ContentType.SelectedValue;
            foreach (string media in mediaList)
            {
                Media entity = new Media();
                entity.project_id = GetProjectId();
                string destFileName = Utils.GetDestImagePath(GetProjectId(), media, contentType);
                entity.name = Utils.GetSafeFileNameWithoutExt(media);
                entity.large_url = PathUtils.GetSiteImgUrl(destFileName);
                entity.alt = Utils.GetSafeFileNameWithoutExt(media);
                entity.media_type = (byte)((ComboBoxItem)this.comboBox_MediaType.SelectedItem).value;
                entity.content_type = contentType;

                this.SaveMediaFile(media, destFileName);
                this.dao.save(entity);
            }
        }

        public void renderWindow()
        {
            if (this.queryCondition != null)
            {
                if (this.queryCondition.media_type != 222)
                {
                    this.comboBox_MediaType.SelectedItem = Utils.getSelected(this.mediaTypeList, this.queryCondition.media_type);
                }
                if (this.queryCondition.content_type != 222)
                {
                    this.comboBox_ContentType.SelectedItem = Utils.getSelected(this.contentTypeList, this.queryCondition.content_type);
                }
                if (!string.IsNullOrWhiteSpace(this.queryCondition.project_id))
                {
                    this.comboBox_Project.SelectedItem = Utils.getSelectedProject(this.projectList, this.queryCondition.project_id);
                }
            }
        }

        private void refreshMediaListView()
        {
            //Add the items to the ListView.
            this.listView_Medias.Items.Clear();
            this.imageList_Medias.Images.Clear();
            string media = null;
            for (int i = 0; i < mediaList.Count; i++)
            {
                media = this.mediaList[i];
                this.listView_Medias.Items.Add(this.parseListViewItem(media, i));
                this.imageList_Medias.Images.Add(this.parseImage(media));
            }
        }

        private ListViewItem parseListViewItem(string media, int imageIndex)
        {
            ListViewItem item = new ListViewItem(media, imageIndex);
            return item;
        }

        private Image parseImage(string media)
        {
            return PictureUtils.GenerateImage(media);
        }

        #region user defined init

        private void InitData()
        {
            this.projectList = this.projectDao.queryAll();
            this.projectList.Insert(0, Utils.getHeadProject());
            this.bindingSource_Project.DataSource = this.projectList;

            mediaTypeList = Utils.getMediaTypeList(false);
            this.bindingSource_MediaType.DataSource = this.mediaTypeList;

            contentTypeList = Utils.getContentTypeList(false);
            this.bindingSource_ContentType.DataSource = this.contentTypeList;
        }

        #endregion

        protected override void Close_Extend(object sender, CancelEventArgs e)
        {
            this.DisposePictures();
        }

        #region event
        public void button_Save_Click(object sender, EventArgs e)
        {
            try
            {
                this.saveEntity();
                //this.SaveMedias();
                this.DialogResult = DialogResult.OK;
                this.Close();
            }
            catch (Exception ex)
            {
                MyMessageBox msgBox = new MyMessageBox("Save error!", ex, MyConstants.BOX_TYPE_ERROR);
                msgBox.ShowDialog(this);
            }
        }

        public void button_Reset_Click(object sender, EventArgs e)
        {
            this.resetButton_click(sender, e);
        }

        public void button_Cancel_Click(object sender, EventArgs e)
        {
            this.cancelButton_click(sender, e);
        }

        private void toolStripMenuItem_Add_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.CheckFileExists = true;
            ofd.CheckPathExists = true;
            ofd.ReadOnlyChecked = true;
            ofd.Multiselect = true;
            if (ofd.ShowDialog(this) == DialogResult.OK)
            {
                string[] files = ofd.FileNames;
                foreach (string file in files)
                {
                    if (!this.mediaList.Contains(file))
                    {
                        this.mediaList.Add(file);
                    }
                }
                this.refreshMediaListView();
            }
        }

        private void toolStripMenuItem_Remove_Click(object sender, EventArgs e)
        {
            if (this.listView_Medias.SelectedItems.Count > 0)
            {
                int i = this.listView_Medias.SelectedItems[0].Index;
                this.mediaList.RemoveAt(i);
                this.refreshMediaListView();
            }
        }

        #endregion

        #region private methods

        private void SaveMedias()
        {
            Byte contentType = (Byte)this.comboBox_ContentType.SelectedValue;
            string destFileName = null;
            foreach (string media in mediaList)
            {
                destFileName = Utils.GetDestImagePath(GetProjectId(), media, contentType);
            }
        }

        private void SaveMediaFile(string currentFileName, string destFileName)
        {
            if (string.IsNullOrWhiteSpace(currentFileName) || !File.Exists(currentFileName))
            {
                throw new ArgumentException("源文件不存在!");
            }
            if (string.IsNullOrWhiteSpace(destFileName))
            {
                throw new ArgumentException("目标路径不能为空!");
            }
            PathUtils.CreateDirectory(destFileName);
            File.Copy(currentFileName, destFileName);
            Utils.SetWritable(destFileName);
        }

        private string GetProjectId()
        {
            if (this.comboBox_Project.SelectedValue != null)
            {
                return (string)this.comboBox_Project.SelectedValue;
            }
            return null;
        }

        private void DisposePictures()
        {
            if (this.imageList_Medias.Images != null && this.imageList_Medias.Images.Count > 0)
            {
                foreach (Image i in this.imageList_Medias.Images)
                {
                    PictureUtils.DisposeImage(i);
                }
            }
        }
        #endregion
    }
}
