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

namespace BeFun.View.Editor
{
    public partial class MediaEditor : MyEditor
    {
        private ProjectDao projectDao = new ProjectDao();
        private MediaDao dao;

        public Media entity { get; set; }
        //small image
        private string savedFileName_small { get; set; }
        private string currentFileName_small { get; set; }
        private string destFileName_small { get; set; }
        //medium image
        private string savedFileName_medium { get; set; }
        private string currentFileName_medium { get; set; }
        private string destFileName_medium { get; set; }
        //large image
        private string savedFileName_large { get; set; }
        private string currentFileName_large { get; set; }
        private string destFileName_large { get; set; }

        private IList<Project> projectList = new List<Project>();
        private IList<ComboBoxItem> mediaTypeList = new List<ComboBoxItem>();
        private IList<ComboBoxItem> contentTypeList = new List<ComboBoxItem>();

        public MediaEditor(): base()
        {
            this.dao = new MediaDao();
            InitializeComponent();
            InitData();
        }


        public MediaEditor(MediaDao dao):base()
        {
            this.dao = dao;
            InitializeComponent();
            InitData();
        }

        public override void renderEntity()
        {
            if (this.entity == null)
            {
                return;
            }
            if (!string.IsNullOrWhiteSpace(this.entity.project_id))
            {
                this.comboBox_Project.SelectedItem = Utils.getSelectedProject(this.projectList, this.entity.project_id);
            }
            this.textBox_Name.Text = this.entity.name;
            this.textBox_LargeURL.Text = this.entity.large_url;
            if (!string.IsNullOrWhiteSpace(this.entity.large_url))
            {
                this.savedFileName_large = PathUtils.getAbstractPath(this.entity.large_url);
                this.currentFileName_large = this.savedFileName_large;
                this.destFileName_large = this.savedFileName_large;
                PictureUtils.RenderPicture(this.pictureBox_Large, this.currentFileName_large);
            }
            this.textBox_Alt.Text = this.entity.alt;
            this.comboBox_MediaType.SelectedItem = Utils.getSelected(this.mediaTypeList, this.entity.media_type);
            this.comboBox_ContentType.SelectedItem = Utils.getSelected(this.contentTypeList, this.entity.content_type);
        }

        public override void saveEntity()
        {
            if (this.entity == null)
            {
                this.entity = new Media();
            }
            if (this.comboBox_Project.SelectedValue != null)
            {
                this.entity.project_id = (string)this.comboBox_Project.SelectedValue;
            }
            this.entity.name = this.textBox_Name.Text;
            this.entity.large_url = this.textBox_LargeURL.Text;
            this.entity.alt = this.textBox_Alt.Text;
            this.entity.media_type = (byte)((ComboBoxItem)this.comboBox_MediaType.SelectedItem).value;
            this.entity.content_type = (byte)((ComboBoxItem)this.comboBox_ContentType.SelectedItem).value;

            this.dao.save(this.entity);
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
                this.SaveMedias();
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

        public void textBox_LargeURL_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.Filter = "Picture(*.jpg;*.jpeg;*.bmp;*.gif;*.png)|*.jpg;*.jpeg;*.bmp;*.gif;*.png|所有文件(*.*)|*.*";
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.currentFileName_large = fileDialog.FileName;
                this.destFileName_large = this.RefreshUrl(this.currentFileName_large, this.textBox_LargeURL);
                PictureUtils.RenderPicture(this.pictureBox_Large, this.currentFileName_large);
                this.textBox_Name.Text = Utils.GetSafeFileNameWithoutExt(this.destFileName_large);
                this.textBox_Alt.Text = this.textBox_Name.Text;
            }
        }

        private void comboBox_ContentType_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.destFileName_large = this.RefreshUrl(this.currentFileName_large, this.textBox_LargeURL);
        }

        #endregion

        #region private methods
        private string RefreshUrl(string currentFileName, TextBox textBox_URL)
        {
            if (string.IsNullOrWhiteSpace(currentFileName) || !File.Exists(currentFileName))
            {
                return "";
            }
            Byte contentType = (Byte)this.comboBox_ContentType.SelectedValue;
            string destFileName = Utils.GetDestImagePath(currentFileName, contentType);
            textBox_URL.Text = PathUtils.GetSiteImgUrl(destFileName);
            return destFileName;
        }

        private void SaveMedias()
        {
            this.DisposePictures();
            if (!string.IsNullOrWhiteSpace(this.currentFileName_small) && !string.IsNullOrWhiteSpace(this.destFileName_small))
            {
                this.SaveMediaFile(this.savedFileName_small, this.currentFileName_small, this.destFileName_small);
            }
            if (!string.IsNullOrWhiteSpace(this.currentFileName_medium) && !string.IsNullOrWhiteSpace(this.destFileName_medium) && !this.destFileName_medium.Equals(this.destFileName_small))
            {
                this.SaveMediaFile(this.savedFileName_medium, this.currentFileName_medium, this.destFileName_medium);
            }
            if (!string.IsNullOrWhiteSpace(this.currentFileName_large) && !string.IsNullOrWhiteSpace(this.destFileName_large) && !this.destFileName_large.Equals(this.destFileName_medium) && !this.destFileName_large.Equals(this.destFileName_small))
            {
                this.SaveMediaFile(this.savedFileName_large, this.currentFileName_large, this.destFileName_large);
            }
        }

        private void SaveMediaFile(string savedFileName, string currentFileName, string destFileName)
        {
            if (string.IsNullOrWhiteSpace(currentFileName) || !File.Exists(currentFileName))
            {
                throw new ArgumentException("源文件不存在!");
            }
            if (string.IsNullOrWhiteSpace(destFileName))
            {
                throw new ArgumentException("目标路径不能为空!");
            }
            if (!PathUtils.IsSameFile(savedFileName, destFileName))
            {
                PathUtils.CreateDirectory(destFileName);
                File.Copy(currentFileName, destFileName);
                Utils.SetWritable(destFileName);
                if (File.Exists(savedFileName))
                {
                    Utils.removeOldImg(savedFileName);
                }
            }
        }

        private void DisposePictures()
        {
            PictureUtils.DisposePicture(this.pictureBox_Large);
        }
        #endregion
    }
}
