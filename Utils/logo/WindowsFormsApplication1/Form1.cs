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
        public Form1()
        {
            InitializeComponent();
            InitData();
        }

        private void InitData()
        {
            IList<Project> datas = new List<Project>();
            for (int i = 0; i < 10; i++)
            {
                Project project = new Project();
                project.id =  "id_" + i;
                project.name =  "name_" + i;
                project.description =  "description_" + i;
                datas.Add(project);
            }
            this.bindingSource_DataGridView.DataSource = datas;
        }
        
        private void textBox_MediaDirectory_Double_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog folder = new FolderBrowserDialog();
            folder.ShowNewFolderButton = false;
            folder.SelectedPath = "E:\\Personal\\lhl\\input\\img";
            if (folder.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_MediaDirectory.Text = folder.SelectedPath;
            }
        }
        
        private void textBox_Floorplan_SmallLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            file.CheckFileExists = true;
            file.CheckPathExists = true;
            file.Multiselect = false;
            if (file.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Floorplan_SmallLogo.Text = file.FileName;
            }
        }
        private void textBox_Floorplan_MediumLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            file.CheckFileExists = true;
            file.CheckPathExists = true;
            file.Multiselect = false;
            if (file.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Floorplan_MediumLogo.Text = file.FileName;
            }
        }
        private void textBox_Floorplan_LargeLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            file.CheckFileExists = true;
            file.CheckPathExists = true;
            file.Multiselect = false;
            if (file.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Floorplan_LargeLogo.Text = file.FileName;
            }
        }

        private void textBox_Overview_SmallLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            file.CheckFileExists = true;
            file.CheckPathExists = true;
            file.Multiselect = false;
            if (file.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Overview_SmallLogo.Text = file.FileName;
            }
        }
        private void textBox_Overview_MediumLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            file.CheckFileExists = true;
            file.CheckPathExists = true;
            file.Multiselect = false;
            if (file.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Overview_MediumLogo.Text = file.FileName;
            }
        }
        private void textBox_Overview_LargeLogo_Double_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            file.CheckFileExists = true;
            file.CheckPathExists = true;
            file.Multiselect = false;
            if (file.ShowDialog(this) == DialogResult.OK)
            {
                this.textBox_Overview_LargeLogo.Text = file.FileName;
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
            this.ResizeFloorplan(mediaDirectory, smallWidth, smallHeight, mediumWidth, mediumHeight, floorplanSmallLogo, floorplanMediumLogo, floorplanLargeLogo);
            this.ResizeProject(mediaDirectory, overview_smallWidth, overview_smallHeight, overview_mediumWidth, overview_mediumHeight, overviewSmallLogo, overviewMediumLogo, overviewLargeLogo);
        }

        private void ResizeFloorplan(string mediaDirectory, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo)
        {
            DirectoryInfo dir = new DirectoryInfo(mediaDirectory);
            this.ResizeProjectSub(dir, "fp", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo);
        }

        private void ResizeProject(string mediaDirectory, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo)
        {
            DirectoryInfo dir = new DirectoryInfo(mediaDirectory);
            this.ResizeProjectSub(dir, "default", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo);
            this.ResizeProjectSub(dir, "floorplate", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo);
            this.ResizeProjectSub(dir, "others", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo);
            this.ResizeProjectSub(dir, "photograph", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo);
            this.ResizeProjectSub(dir, "render", smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo);
        }

        private void ResizeProjectSub(DirectoryInfo dir,string subName, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo)
        {
            DirectoryInfo[] floorplans = dir.GetDirectories(subName);
            if (floorplans.Length > 0)
            {
                DirectoryInfo floorplan = floorplans[0];
                FileInfo[] files = floorplan.GetFiles();
                Image smallLogoImg = Bitmap.FromFile(smallLogo);
                Image mediumLogoImg = Bitmap.FromFile(mediumLogo);
                Image largeLogoImg = Bitmap.FromFile(largeLogo);
                ResizeTask s = new ResizeTask(subName, files, this, smallWidth, smallHeight, mediumWidth, mediumHeight, smallLogo, mediumLogo, largeLogo);
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
            Int32 smallWidth ,smallHeight,mediumWidth,mediumHeight;
            string smallLogo, mediumLogo, largeLogo;
            IWin32Window owner;

            public ResizeTask(String title, FileInfo[] files, IWin32Window owner, Int32 smallWidth, Int32 smallHeight, Int32 mediumWidth, Int32 mediumHeight, string smallLogo, string mediumLogo, string largeLogo)
            {
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

                    resizePicture(files[i], Bitmap.FromFile(smallLogo), "small", smallWidth, smallHeight);
                    resizePicture(files[i], Bitmap.FromFile(mediumLogo), "medium", mediumWidth, mediumHeight);
                    resizePicture(files[i], Bitmap.FromFile(largeLogo), "large", originalWidth, originalHeight);
                    pb.PerformStep();
                }
                pb.Close();
            }

            private void resizePicture(FileInfo file, Image logo, string type, Int32 width, Int32 height)
            {
                Image image = Bitmap.FromFile(file.FullName);
                ResizeModel model = new ResizeModel();
                model.Source = image;
                model.Position = WatermarkPositions.Center;
                model.IsWartermarked = true;
                model.ImageWartermark = logo;
                model.ResizeType = ResizeTypes.Absolute;
                model.Width = width;
                model.Height = height;
                DirectoryInfo destDir = file.Directory.CreateSubdirectory(type);
                string destPath = destDir.FullName + "\\" + file.Name;
                if (!File.Exists(destPath))
                {
                    Image destImage = PictureOperation.Resize(model);
                    PictureOperation.Save(destImage, destPath);
                }
            }
        }

        void resizePicture()
        {
            Int32 smallWidth = (Int32)this.numericUpDown_Floorplan_SmallWidth.Value;
            Int32 smallHeight = (Int32)this.numericUpDown_Floorplan_SmallHeight.Value;
            Int32 mediumWidth = (Int32)this.numericUpDown_Floorplan_MediumWidth.Value;
            Int32 mediumHeight = (Int32)this.numericUpDown_Floorplan_MediumHeight.Value;

            Image image = Bitmap.FromFile("E:\\Personal\\lhl\\temp\\Koala.jpg");
            ResizeModel model = new ResizeModel();
            model.Source = image;
            model.Position = WatermarkPositions.BottomRight;
            model.IsWartermarked = true;
            model.ImageWartermark = Bitmap.FromFile("E:\\Personal\\lhl\\temp\\logo_small.png");
            model.ResizeType = ResizeTypes.Absolute;
            model.Width = smallWidth;
            model.Height = smallHeight;
            Image smallImage = PictureOperation.Resize(model);
            PictureOperation.Save(smallImage, "E:\\Personal\\lhl\\temp\\small\\Koala.jpg");

            //medium
            image = Bitmap.FromFile("E:\\Personal\\lhl\\temp\\Koala.jpg");
            model.Source = image;
            model.Width = mediumWidth;
            model.Height = mediumHeight;
            model.ImageWartermark = Bitmap.FromFile("E:\\Personal\\lhl\\temp\\logo_medium.png");
            Image mediumImage = PictureOperation.Resize(model);
            PictureOperation.Save(mediumImage, "E:\\Personal\\lhl\\temp\\medium\\Koala.jpg");
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
            Image image = Bitmap.FromFile("E:\\Personal\\lhl\\temp\\logo.png");
            ResizeModel model = new ResizeModel();
            model.Source = image;
            model.IsWartermarked = false;
            model.ResizeType = ResizeTypes.Auto;
            model.Width = 10;
            model.Height = 12;
            Image smallImage = PictureOperation.Resize(model);
            Bitmap pbitmap = new Bitmap(smallImage);
            pbitmap.MakeTransparent(Color.White);
            PictureOperation.Save(pbitmap, "E:\\Personal\\lhl\\temp\\logo_small.png", ImgCodes.PNG, 100);

            image = Bitmap.FromFile("E:\\Personal\\lhl\\temp\\logo.png");
            model.Source = image;
            model.Width = 40;
            model.Height = 49;
            Image mediumImage = PictureOperation.Resize(model);
            pbitmap = new Bitmap(mediumImage);
            pbitmap.MakeTransparent(Color.White);
            PictureOperation.Save(pbitmap, "E:\\Personal\\lhl\\temp\\logo_medium.png", ImgCodes.PNG, 100);

            image = Bitmap.FromFile("E:\\Personal\\lhl\\temp\\logo.png");
            model.Source = image;
            model.Width = 80;
            model.Height = 99;
            Image largeImage = PictureOperation.Resize(model);
            pbitmap = new Bitmap(mediumImage);
            pbitmap.MakeTransparent(Color.White);
            PictureOperation.Save(pbitmap, "E:\\Personal\\lhl\\temp\\logo_large.png", ImgCodes.PNG, 100);
        }
    }
}
