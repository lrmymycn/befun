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
            this.mediaDao = new MediaDao();
            this.renderDefault();
        }

        private void renderDefault()
        {
            this.config = ResizeConfig.getInstance();
            this.checkBox_EnableLogo.Checked = this.config.enableLogo;
            foreach (Byte contentType in this.config.enableLogoTypes)
            {
                switch (contentType)
                {
                    case Media.CONTENT_TYPE_FLOORPLAN:
                        this.checkBox_Enable_Floorplan.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_RENDER_INTERNAL:
                        this.checkBox_Enable_RenderInternal.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_RENDER_EXTERNAL:
                        this.checkBox_Enable_RenderExternal.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_PHOTOGRAPH:
                        this.checkBox_Enable_Photo.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_ENV:
                        this.checkBox_Enable_Env.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_FLOORPLATE:
                        this.checkBox_Enable_Floorplate.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_OTHERS:
                        this.checkBox_Enable_Others.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_PROJECT_OVERVIEW:
                        this.checkBox_Enable_ProjectOveriew.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_PROJECT_DESCRIPTION:
                        this.checkBox_Enable_ProjectDesc.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_PROJECT_FEATURE:
                        this.checkBox_Enable_ProjectFeature.Checked = true;
                        break;
                    case Media.CONTENT_TYPE_PROJECT_SCHEME:
                        this.checkBox_Enable_ProjectScheme.Checked = true;
                        break;
                    default:
                        break;
                }
            }
            this.textBox_SmallLogo.Text = this.config.smallLogo;
            this.textBox_MediumLogo.Text = this.config.mediumLogo;
            this.textBox_LargeLogo.Text = this.config.largeLogo;
            this.numericUpDown_Floorplan_MediumHeight.Value = this.config.floorplan_mediumHeight;
            this.numericUpDown_Floorplan_MediumWidth.Value = this.config.floorplan_mediumWidth;
            this.numericUpDown_Floorplan_SmallHeight.Value = this.config.floorplan_smallHeight;
            this.numericUpDown_Floorplan_SmallWidth.Value = this.config.floorplan_smallWidth;
            this.numericUpDown_Overview_MediumHeight.Value = this.config.overview_mediumHeight;
            this.numericUpDown_Overview_MediumWidth.Value = this.config.overview_mediumWidth;
            this.numericUpDown_Overview_SmallHeight.Value = this.config.overview_smallHeight;
            this.numericUpDown_Overview_SmallWidth.Value = this.config.overview_smallWidth;
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
            this.saveConfig();
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
            this.renderDefault();
        }

        private void button_Save_Click(object sender, EventArgs e)
        {
            this.saveConfig();
            MyMessageBox.ShowBox(this, "Watermark config saved!");
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
            cfg.enableLogoTypes.Clear();
            if (this.checkBox_Enable_Floorplan.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_FLOORPLAN);
            }
            if (this.checkBox_Enable_RenderInternal.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_RENDER_INTERNAL);
            }
            if (this.checkBox_Enable_RenderExternal.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_RENDER_EXTERNAL);
            }
            if (this.checkBox_Enable_Photo.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_PHOTOGRAPH);
            }
            if (this.checkBox_Enable_Env.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_ENV);
            }
            if (this.checkBox_Enable_Floorplate.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_FLOORPLATE);
            }
            if (this.checkBox_Enable_Others.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_OTHERS);
            }
            if (this.checkBox_Enable_ProjectOveriew.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_PROJECT_OVERVIEW);
            }
            if (this.checkBox_Enable_ProjectDesc.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_PROJECT_DESCRIPTION);
            }
            if (this.checkBox_Enable_ProjectFeature.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_PROJECT_FEATURE);
            }
            if (this.checkBox_Enable_ProjectScheme.Checked)
            {
                cfg.enableLogoTypes.Add(Media.CONTENT_TYPE_PROJECT_SCHEME);
            }
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
