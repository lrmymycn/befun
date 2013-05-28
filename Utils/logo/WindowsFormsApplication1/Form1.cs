using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using WindowsFormsApplication1.Domain;
using System.IO;
using System.Threading;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        const String LOGO_SMALL = "logo-small.png";
        const String LOGO_MEDIUM = "logo-medium.png";
        const String LOGO_LARGE = "logo-large.png";
        
        public Form1()
        {
            InitializeComponent();
            InitComponent();
        }

        private void InitComponent()
        {
            this.textBox_MediaDirectory.Text = this.GetCurrentPath();
            this.textBox_Floorplan_SmallLogo.Text = this.GetDefaultLogoPath(LOGO_SMALL);
            this.textBox_Floorplan_MediumLogo.Text = this.GetDefaultLogoPath(LOGO_MEDIUM);
            this.textBox_Floorplan_LargeLogo.Text = this.GetDefaultLogoPath(LOGO_LARGE);
            this.textBox_Overview_SmallLogo.Text = this.GetDefaultLogoPath(LOGO_SMALL);
            this.textBox_Overview_MediumLogo.Text = this.GetDefaultLogoPath(LOGO_MEDIUM);
            this.textBox_Overview_LargeLogo.Text = this.GetDefaultLogoPath(LOGO_LARGE);
        }
                
        private void textBox_MediaDirectory_Double_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog folder = new FolderBrowserDialog();
            folder.ShowNewFolderButton = false;
            folder.SelectedPath = this.textBox_MediaDirectory.Text;
            if (folder.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_MediaDirectory.Text = folder.SelectedPath;
            }
        }
        
        private void textBox_Floorplan_SmallLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = this.GetDirectoryPath(this.textBox_Floorplan_SmallLogo.Text);
            fileDialog.FileName = this.GetFileName(this.textBox_Floorplan_SmallLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Floorplan_SmallLogo.Text = fileDialog.FileName;
            }
        }

        private void textBox_Floorplan_MediumLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = this.GetDirectoryPath(this.textBox_Floorplan_MediumLogo.Text);
            fileDialog.FileName = this.GetFileName(this.textBox_Floorplan_MediumLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Floorplan_MediumLogo.Text = fileDialog.FileName;
            }
        }
        private void textBox_Floorplan_LargeLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = this.GetDirectoryPath(this.textBox_Floorplan_LargeLogo.Text);
            fileDialog.FileName = this.GetFileName(this.textBox_Floorplan_LargeLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Floorplan_LargeLogo.Text = fileDialog.FileName;
            }
        }

        private void textBox_Overview_SmallLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = this.GetDirectoryPath(this.textBox_Overview_SmallLogo.Text);
            fileDialog.FileName = this.GetFileName(this.textBox_Overview_SmallLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Overview_SmallLogo.Text = fileDialog.FileName;
            }
        }
        private void textBox_Overview_MediumLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = this.GetDirectoryPath(this.textBox_Overview_MediumLogo.Text);
            fileDialog.FileName = this.GetFileName(this.textBox_Overview_MediumLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Overview_MediumLogo.Text = fileDialog.FileName;
            }
        }
        private void textBox_Overview_LargeLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.CheckFileExists = true;
            fileDialog.CheckPathExists = true;
            fileDialog.Multiselect = false;
            fileDialog.InitialDirectory = this.GetDirectoryPath(this.textBox_Overview_LargeLogo.Text);
            fileDialog.FileName = this.GetFileName(this.textBox_Overview_LargeLogo.Text);
            if (fileDialog.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Overview_LargeLogo.Text = fileDialog.FileName;
            }
        }
        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Dispose();
            this.Close();
        }

        private void button_Resize_Click(object sender, EventArgs e)
        {
            Int32 smallWidth = (Int32)this.numericUpDown_Floorplan_SmallWidth.Value;
            Int32 smallHeight = (Int32)this.numericUpDown_Floorplan_SmallHeight.Value;
            Int32 mediumWidth = (Int32)this.numericUpDown_Floorplan_MediumWidth.Value;
            Int32 mediumHeight = (Int32)this.numericUpDown_Floorplan_MediumHeight.Value;
            string mediaDirectory = this.textBox_MediaDirectory.Text;
            string floorplanSmallLogo = this.textBox_Floorplan_SmallLogo.Text;
            string floorplanMediumLogo = this.textBox_Floorplan_MediumLogo.Text;
            string floorplanLargeLogo = this.textBox_Floorplan_LargeLogo.Text;
            Int32 overview_smallWidth = (Int32)this.numericUpDown_Overview_SmallWidth.Value;
            Int32 overview_smallHeight = (Int32)this.numericUpDown_Overview_SmallHeight.Value;
            Int32 overview_mediumWidth = (Int32)this.numericUpDown_Overview_MediumWidth.Value;
            Int32 overview_mediumHeight = (Int32)this.numericUpDown_Overview_MediumHeight.Value;
            string overviewSmallLogo = this.textBox_Overview_SmallLogo.Text;
            string overviewMediumLogo = this.textBox_Overview_MediumLogo.Text;
            string overviewLargeLogo = this.textBox_Overview_LargeLogo.Text;
            bool waterMark = this.checkBox_EnableLogo.Checked;
            this.ResizeFloorplan(mediaDirectory, smallWidth, smallHeight, mediumWidth, mediumHeight, floorplanSmallLogo, floorplanMediumLogo, floorplanLargeLogo, waterMark);
            this.ResizeProject(mediaDirectory, overview_smallWidth, overview_smallHeight, overview_mediumWidth, overview_mediumHeight, overviewSmallLogo, overviewMediumLogo, overviewLargeLogo, waterMark);
        }

        private void ResizeFloorplan(string mediaDirectory, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo, bool waterMark)
        {
            DirectoryInfo dir = new DirectoryInfo(mediaDirectory);
            this.ResizeProjectSub(dir, "fp", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo, waterMark);
        }

        private void ResizeProject(string mediaDirectory, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo, bool waterMark)
        {
            DirectoryInfo dir = new DirectoryInfo(mediaDirectory);
            this.ResizeProjectSub(dir, "default", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo, waterMark);
            this.ResizeProjectSub(dir, "floorplate", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo, waterMark);
            this.ResizeProjectSub(dir, "others", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo, waterMark);
            this.ResizeProjectSub(dir, "photograph", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo, waterMark);
            this.ResizeProjectSub(dir, "render", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo, waterMark);
        }

        private void ResizeProjectSub(DirectoryInfo dir,string subName, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo, bool waterMark)
        {
            DirectoryInfo[] floorplans = dir.GetDirectories(subName);
            if (floorplans.Length > 0)
            {
                DirectoryInfo floorplan = floorplans[0];
                FileInfo[] files = floorplan.GetFiles();
                //Image smallLogoImg = Bitmap.FromFile(smallLogo);
                //Image mediumLogoImg = Bitmap.FromFile(mediumLogo);
                //Image largeLogoImg = Bitmap.FromFile(largeLogo);
                ResizeTask s = new ResizeTask(dir, subName, files, this, smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo, waterMark);
                s.t.Start();
                if (s.pb.ShowDialog(this) == DialogResult.Cancel)
                {
                    s.stopflag = true;
                }
            }
        }

        private class ResizeTask
        {
            FileInfo[] files;
            public bool stopflag = false;
            public ProgressBarBox pb;
            public Thread t;
            DirectoryInfo rootDir;
            Int32 smallWidth ,smallHeight,mediumWidth,mediumHeight;
            string smallLogo, mediumLogo, largeLogo;
            bool waterMark = false;
            IWin32Window owner;

            public ResizeTask(DirectoryInfo rootDir, String title, FileInfo[] files, IWin32Window owner, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo, bool waterMark)
            {
                this.rootDir = rootDir;
                this.files = files;
                this.t = new Thread(new ThreadStart(Worker));
                this.t.IsBackground = true;
                this.owner = owner;
                this.smallWidth = smallWidth;
                this.smallHeight = smallHeight;
                this.mediumWidth = mediumWidth;
                this.mediumHeight = mediumHeight;
                this.smallLogo = smallLogo;
                this.mediumLogo = mediumLogo;
                this.largeLogo = largeLogo;
                this.waterMark = waterMark;
                this.pb = new ProgressBarBox("Resizing " + title + " Media", 1, files.Length, 1);
            }

            public void Worker()
            {
                for (int i = 0; i < files.Length && !stopflag; i++)
                {
                    System.Threading.Thread.Sleep(50 * 1);
                    Image image = Bitmap.FromFile(files[i].FullName);
                    int originalWidth = image.Width;
                    int originalHeight = image.Height;
                    image.Dispose();
                    Image smallLogoImg = null;
                    Image mediumLogoImg = null;
                    Image largeLogoImg = null;
                    if (smallLogo != null && File.Exists(smallLogo))
                    {
                        smallLogoImg = Bitmap.FromFile(smallLogo);
                    }
                    if (mediumLogo != null && File.Exists(mediumLogo))
                    {
                        mediumLogoImg = Bitmap.FromFile(mediumLogo);
                    }
                    if (largeLogo != null && File.Exists(largeLogo))
                    {
                        largeLogoImg = Bitmap.FromFile(largeLogo);
                    }

                    resizePicture(files[i], waterMark, smallLogoImg, "small", smallWidth, smallHeight);
                    resizePicture(files[i], waterMark, mediumLogoImg, "medium", mediumWidth, mediumHeight);
                    resizePicture(files[i], waterMark, largeLogoImg, "large", originalWidth, originalHeight);
                    pb.PerformStep();
                }
                pb.Close();
            }

            private void resizePicture(FileInfo file, bool waterMark, Image logo, string type, Int32 width, Int32 height)
            {
                Image image = Bitmap.FromFile(file.FullName);
                ResizeModel model = new ResizeModel();
                model.Source = image;
                model.Position = WatermarkPositions.Center;
                model.IsWartermarked = waterMark;
                if (waterMark && logo != null)
                {
                    model.IsWartermarked = true;
                    model.ImageWartermark = logo;
                }
                model.ResizeType = ResizeTypes.Absolute;
                model.Width = width;
                model.Height = height;
                //DirectoryInfo destDir = file.Directory.CreateSubdirectory(type);
                //string destPath = destDir.FullName + "\\" + file.Name;
                string destPath = GetResizedFilePath(file, type);
                createParentDir(destPath);
                if (!File.Exists(destPath))
                {
                    Image destImage = PictureOperation.Resize(model);
                    PictureOperation.Save(destImage, destPath);
                }
            }

            private string GetResizedFilePath(FileInfo originalFileInfo, String type)
            {
                string imgRootPath = this.rootDir.FullName;
                int i = originalFileInfo.FullName.IndexOf(imgRootPath);
                string extFilePath = originalFileInfo.FullName.Substring(i + imgRootPath.Length);
                i = extFilePath.LastIndexOf("\\");

                string rs = imgRootPath + "\\resized" + extFilePath.Substring(0, i) + "\\" + type + "\\" + originalFileInfo.Name;
                return rs;
            }

            private void createParentDir(String filePath)
            {
                FileInfo fileInfo = new FileInfo(filePath);
                if (!fileInfo.Directory.Exists)
                {
                    fileInfo.Directory.Create();
                }
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

        private string GetResizedFilePath(FileInfo originalFileInfo, String type)
        {
            string imgRootPath = "E:\\Personal\\lhl\\input\\img";
            string filePath = originalFileInfo.FullName;
            int i = filePath.IndexOf(imgRootPath);

            string extFilePath = filePath.Substring(i+imgRootPath.Length);
            i = extFilePath.LastIndexOf("\\");

            string rs = imgRootPath + "\\resized" + extFilePath.Substring(0, i) + "\\" + type + "\\" + originalFileInfo.Name;
            return rs;
        }

        private void button_Logo_Click(object sender, EventArgs e)
        {
            /*
            FileInfo f = new FileInfo("E:\\Personal\\lhl\\input\\img\\default\\Chrysanthemum.jpg");
            this.label17.Text = this.GetResizedFilePath(f,"large");
            return;*/
            string sourceLogo = this.GetDefaultLogoPath("logo.png");
            Image image = Bitmap.FromFile(sourceLogo);
            ResizeModel model = new ResizeModel();
            model.Source = image;
            model.IsWartermarked = false;
            model.ResizeType = ResizeTypes.Auto;
            model.Width = 23;
            model.Height = 6;
            Image smallImage = PictureOperation.Resize(model);
            Bitmap pbitmap = new Bitmap(smallImage);
            pbitmap.MakeTransparent(Color.White);
            string destLogo = this.GetDefaultLogoPath("logo-small.png");
            PictureOperation.Save(pbitmap, destLogo, ImgCodes.PNG, 100);

            image = Bitmap.FromFile(sourceLogo);
            model.Source = image;
            model.Width = 138;
            model.Height = 38;
            Image mediumImage = PictureOperation.Resize(model);
            pbitmap = new Bitmap(mediumImage);
            pbitmap.MakeTransparent(Color.White);
            destLogo = this.GetDefaultLogoPath("logo-medium.png");
            PictureOperation.Save(pbitmap, destLogo, ImgCodes.PNG, 100);

            image = Bitmap.FromFile(sourceLogo);
            model.Source = image;
            model.Width = 414;
            model.Height = 114;
            Image largeImage = PictureOperation.Resize(model);
            pbitmap = new Bitmap(largeImage);
            pbitmap.MakeTransparent(Color.White);
            destLogo = this.GetDefaultLogoPath("logo-large.png");
            PictureOperation.Save(pbitmap, destLogo, ImgCodes.PNG, 100);
        }
        
        private string GetCurrentPath()
        {
            return System.Environment.CurrentDirectory;
        }

        private string GetDefaultLogoPath(String logoName)
        {
            if (string.IsNullOrWhiteSpace(logoName))
            {
                return GetCurrentPath();
            }
            if (logoName.StartsWith("/") || logoName.StartsWith("\\"))
            {
                return GetCurrentPath() + logoName;
            }
            return GetCurrentPath() + "\\" + logoName;
        }

        private string GetDirectoryPath(String filePath)
        {
            FileInfo sourceFile = new FileInfo(filePath);
            return sourceFile.DirectoryName;
        }

        private string GetFileName(String filePath)
        {
            FileInfo sourceFile = new FileInfo(filePath);
            return sourceFile.Name;
        }

        private void createParentDir(String filePath)
        {
            FileInfo fileInfo = new FileInfo(filePath);
            if (!fileInfo.Directory.Exists)
            {
                fileInfo.Directory.Create();
            }
        }


    }
}
