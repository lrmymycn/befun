using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Threading;
using BeFun.View.Component.Common;
using BeFun.Common;
using BeFun.Model;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Model.Resize;

namespace BeFun.View.Resize
{
    public partial class ResizeForm : Form
    {
        private ResizeConfig config { get; set; }

        private MediaDao mediaDao { get; set; }

        public ResizeForm()
            : base()
        {
            InitializeComponent();
            InitComponent();
        }

        private void InitComponent()
        {
            this.config = ResizeConfig.getInstance();
            this.mediaDao = new MediaDao();
            this.textBox_SmallLogo.Text = this.config.smallLogo;
            this.textBox_MediumLogo.Text = this.config.mediumLogo;
            this.textBox_LargeLogo.Text = this.config.largeLogo;
        }
        
        private void textBox_Floorplan_SmallLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = PathUtils.GetDirectoryPath(this.textBox_SmallLogo.Text);
            fileDialog.FileName = PathUtils.GetFileName(this.textBox_SmallLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_SmallLogo.Text = fileDialog.FileName;
            }
        }

        private void textBox_Floorplan_MediumLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = PathUtils.GetDirectoryPath(this.textBox_MediumLogo.Text);
            fileDialog.FileName = PathUtils.GetFileName(this.textBox_MediumLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_MediumLogo.Text = fileDialog.FileName;
            }
        }
        private void textBox_Floorplan_LargeLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = PathUtils.GetDirectoryPath(this.textBox_LargeLogo.Text);
            fileDialog.FileName = PathUtils.GetFileName(this.textBox_LargeLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_LargeLogo.Text = fileDialog.FileName;
            }
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Dispose();
            this.Close();
        }

        private void button_Resize_Click(object sender, EventArgs e)
        {
            IList<Media> medias = mediaDao.queryAll();
            DirectoryInfo imgRootDir = new DirectoryInfo(PathUtils.GetImgRootPath());
            string title = "all";
            ResizeTask task = new ResizeTask(imgRootDir, title, medias, this, ResizeConfig.getInstance());
            task.t.Start();
            if (task.pb.ShowDialog(this) == DialogResult.Cancel)
            {
                task.stopflag = true;
            }
        }

        private void button_Reset_Click(object sender, EventArgs e)
        {
            this.numericUpDown_Floorplan_MediumHeight.Value = 510;
            this.numericUpDown_Floorplan_MediumWidth.Value = 680;
            this.numericUpDown_Floorplan_SmallHeight.Value = 90;
            this.numericUpDown_Floorplan_SmallWidth.Value = 120;
            this.numericUpDown_Overview_MediumHeight.Value = 343;
            this.numericUpDown_Overview_MediumWidth.Value = 510;
            this.numericUpDown_Overview_SmallHeight.Value = 56;
            this.numericUpDown_Overview_SmallWidth.Value = 84;
        }

        private void button_Logo_Click(object sender, EventArgs e)
        {
            this.saveConfig();
        }

        private void saveConfig()
        {
            ResizeConfig cfg = ResizeConfig.getInstance();

            Boolean enableLogo = this.checkBox_EnableLogo.Checked;
            Int32 floorplan_smallWidth = (Int32)this.numericUpDown_Floorplan_SmallWidth.Value;
            Int32 floorplan_smallHeight = (Int32)this.numericUpDown_Floorplan_SmallHeight.Value;
            Int32 floorplan_mediumWidth = (Int32)this.numericUpDown_Floorplan_MediumWidth.Value;
            Int32 floorplan_mediumHeight = (Int32)this.numericUpDown_Floorplan_MediumHeight.Value;
            string smallLogo = this.textBox_SmallLogo.Text;
            string mediumLogo = this.textBox_MediumLogo.Text;
            string largeLogo = this.textBox_LargeLogo.Text;
            Int32 overview_smallWidth = (Int32)this.numericUpDown_Overview_SmallWidth.Value;
            Int32 overview_smallHeight = (Int32)this.numericUpDown_Overview_SmallHeight.Value;
            Int32 overview_mediumWidth = (Int32)this.numericUpDown_Overview_MediumWidth.Value;
            Int32 overview_mediumHeight = (Int32)this.numericUpDown_Overview_MediumHeight.Value;

            cfg.enableLogo = enableLogo;
            cfg.floorplan_smallWidth = floorplan_smallWidth;
            cfg.floorplan_smallHeight = floorplan_smallHeight;
            cfg.floorplan_mediumWidth = floorplan_mediumWidth;
            cfg.floorplan_mediumHeight = floorplan_mediumHeight;
            cfg.smallLogo = smallLogo;
            cfg.mediumLogo = mediumLogo;
            cfg.largeLogo = largeLogo;
            cfg.overview_smallWidth = overview_smallWidth;
            cfg.overview_smallHeight = overview_smallHeight;
            cfg.overview_mediumWidth = overview_mediumWidth;
            cfg.overview_mediumHeight = overview_mediumHeight;
        }
    }
}
