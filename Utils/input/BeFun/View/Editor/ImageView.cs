using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Common;

namespace BeFun.View.Editor
{
    public partial class ImageView : Form
    {
        private string image;

        public ImageView(string image)
        {
            this.image = image;
            InitializeComponent();
            InitData();
        }

        private void InitData()
        {
            this.Closing += new CancelEventHandler(this.Form_Closing);

            Image image = PictureUtils.GenerateImage(this.image);
            int height = image.Height;
            int width = image.Width;
            this.Width = width + 10;
            this.Height = height + 20;
            this.pictureBox.Width = width;
            this.pictureBox.Height = height;
            PictureUtils.RenderPicture(this.pictureBox, this.image);
        }

        private void DisposePictures()
        {
            PictureUtils.DisposePicture(this.pictureBox);
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            this.Close();
        }

        private void Form_Closing(object sender, CancelEventArgs e)
        {
            this.Close_Extend(sender, e);
        }

        protected virtual void Close_Extend(object sender, CancelEventArgs e)
        {
            this.DisposePictures();
        }
    }
}
