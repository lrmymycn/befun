using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using BeFun.View.Component.Common;
using System.Threading;
using System.Windows.Forms;
using System.Drawing;
using BeFun.Common;
using BeFun.Model.Domain;

namespace BeFun.Model.Resize
{
    class ResizeTask
    {
        IList<Media> medias;
        public bool stopflag = false;
        public ProgressBarBox pb;
        public Thread t;
        DirectoryInfo rootDir;
        ResizeConfig resizeConfig;
        IWin32Window owner;
        private DirectoryInfo imgRootDir;
        private string title;
        private FileInfo[] infoArray;
        private View.ListWindow.MediaWindow mediaWindow;

        public ResizeTask(DirectoryInfo imgRootDir, string title, IList<Media> medias, IWin32Window owner, ResizeConfig resizeConfig)
        {
            this.rootDir = imgRootDir;
            this.title = title;
            this.medias = medias;
            this.t = new Thread(new ThreadStart(Worker));
            this.t.IsBackground = true;
            this.owner = owner;
            this.resizeConfig = resizeConfig;
            this.pb = new ProgressBarBox("Resizing " + title + " Media", 1, medias.Count, 1);
        }
        
        public void Worker()
        {
            for (int i = 0; i < medias.Count && !stopflag; i++)
            {
                byte contentType = medias[i].content_type;
                System.Threading.Thread.Sleep(50 * 1);
                string fullName = PathUtils.GenerateAbsoluteMediaPath(medias[i].large_url);
                FileInfo fileInfo = new FileInfo(fullName);
                Image image = Bitmap.FromFile(fullName);
                int originalWidth = image.Width;
                int originalHeight = image.Height;
                image.Dispose();
                Image smallLogoImg = null;
                Image mediumLogoImg = null;
                Image largeLogoImg = null;
                if (resizeConfig.smallLogo != null && File.Exists(resizeConfig.smallLogo))
                {
                    smallLogoImg = Bitmap.FromFile(resizeConfig.smallLogo);
                }
                if (resizeConfig.mediumLogo != null && File.Exists(resizeConfig.mediumLogo))
                {
                    mediumLogoImg = Bitmap.FromFile(resizeConfig.mediumLogo);
                }
                if (resizeConfig.largeLogo != null && File.Exists(resizeConfig.largeLogo))
                {
                    largeLogoImg = Bitmap.FromFile(resizeConfig.largeLogo);
                }

                int smallWidth = this.resizeConfig.floorplan_smallWidth;
                int smallHeight = this.resizeConfig.floorplan_smallHeight;
                int mediumWidth = this.resizeConfig.floorplan_mediumWidth;
                int mediumHeight = this.resizeConfig.floorplan_mediumHeight;
                switch(contentType)
                {
                    case Media.CONTENT_TYPE_FLOORPLAN:
                        smallWidth = this.resizeConfig.floorplan_smallWidth;
                        smallHeight = this.resizeConfig.floorplan_smallHeight;
                        mediumWidth = this.resizeConfig.floorplan_mediumWidth;
                        mediumHeight = this.resizeConfig.floorplan_mediumHeight;
                        break;
                    case Media.CONTENT_TYPE_FLOORPLATE:
                    case Media.CONTENT_TYPE_OTHERS:
                    case Media.CONTENT_TYPE_PHOTOGRAPH:
                    case Media.CONTENT_TYPE_RENDER_INTERNAL:
                    case Media.CONTENT_TYPE_RENDER_EXTERNAL:
                    case Media.CONTENT_TYPE_PROJECT_OVERVIEW:
                    case Media.CONTENT_TYPE_PROJECT_DESCRIPTION:
                    case Media.CONTENT_TYPE_PROJECT_FEATURE:
                    case Media.CONTENT_TYPE_PROJECT_SCHEME:
                    default:
                        smallWidth = this.resizeConfig.overview_smallWidth;
                        smallHeight = this.resizeConfig.overview_smallHeight;
                        mediumWidth = this.resizeConfig.overview_mediumWidth;
                        mediumHeight = this.resizeConfig.overview_mediumHeight;
                        break;
                }
                resizePicture(fileInfo, this.resizeConfig.enableLogo, smallLogoImg, "small", smallWidth, smallHeight);
                resizePicture(fileInfo, this.resizeConfig.enableLogo, mediumLogoImg, "medium", mediumWidth, mediumHeight);
                resizePicture(fileInfo, this.resizeConfig.enableLogo, largeLogoImg, "large", originalWidth, originalHeight);
                pb.ThreadSafePerformStep();
            }
            pb.ThreadSafeClose();
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
            string destPath = GetResizedFilePath(file, type);
            PathUtils.CreateDirectory(destPath);
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

    }
}
