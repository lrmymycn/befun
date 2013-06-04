using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing;
using System.IO;

namespace BeFun.Common
{
    public class PictureUtils
    {
        public static void DisposePicture(PictureBox pictureBox)
        {
            if (pictureBox != null && pictureBox.Image != null)
            {
                pictureBox.Image.Dispose();
            }
        }

        public static void DisposeImage(Image image)
        {
            if (image != null)
            {
                image.Dispose();
            }
        }

        public static void RenderPicture(PictureBox pictureBox, string fileName)
        {
            Image image = GenerateImage(fileName);
            Image oldImage = pictureBox.Image;
            pictureBox.Image = image;
            DisposeImage(oldImage);
        }

        public static void RenderPictureFromUrl(PictureBox pictureBox, string url)
        {
            string fileName = PathUtils.GenerateAbsoluteMediaPath(url);
            RenderPicture(pictureBox, fileName);
        }

        public static Image GenerateImage(string fileName)
        {
            if (string.IsNullOrWhiteSpace(fileName))
            {
                return getEmptyPicture();
            }
            if (!File.Exists(fileName))
            {
                System.Console.WriteLine(fileName);
                return getNotFoundPicture();
            }
            Bitmap image = new Bitmap(fileName);
            return image;
        }

        public static Image GenerateImageFromUrl(string url)
        {
            string fileName = PathUtils.GenerateAbsoluteMediaPath(url);
            return GenerateImage(fileName);
        }

        public static Image getEmptyPicture()
        {
            return Bitmap.FromFile(PathUtils.GetCurrentAppPath() + "/img/null.png");
        }

        public static Image getNotFoundPicture()
        {
            return Bitmap.FromFile(PathUtils.GetCurrentAppPath() + "/img/notFound.png");
        }
    }
}
