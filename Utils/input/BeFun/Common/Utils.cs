using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using BeFun.Model.Domain;

namespace BeFun.Common
{
    public class Utils
    {
        public static Byte boolToByte(bool original)
        {
            if(original)
            {
                return 1;
            }
            return 0;
        }

        public static bool byteToBool(Byte original)
        {
            if (original == 0)
            {
                return false;
            }
            return true;
        }

        /// <summary>
        /// 用户添加media的时候，会将原media文件copy到我们输入工具的内容目录img下，
        /// 
        /// 此方法获取原media文件的目标路径（在img下），如果原media文件就在对应的img目录下，返回originalPath
        /// </summary>
        /// <param name="originalPath">原media文件完整路径</param>
        /// <param name="contentType">media的类型，floorplan,render......</param>
        /// <returns>目标文件路径</returns>
        public static string GetDestImagePath(string originalPath, Byte contentType)
        {
            FileInfo originalFile = new FileInfo(originalPath);
            if (!originalFile.Exists)
            {
                throw new Exception("File not exists!");
            }
            string directoryName = originalFile.DirectoryName;
            string filename = originalFile.Name;
            string noExtName = filename;
            string extName = originalFile.Extension;
            int i = filename.LastIndexOf(".");
            if (i > 0)
            {
                noExtName = filename.Substring(0, i);
            }
            string destPath = PathUtils.GenerateImgPath(filename, contentType);
            if (PathUtils.IsSameDirectory(destPath, originalPath))
            {
                return originalPath;
            }
            if (File.Exists(destPath))
            {
                for (int l = 0; l < 10000; l++)
                {
                    string destNoExtName = noExtName + "_" + l;
                    destPath = PathUtils.GenerateImgPath(destNoExtName + extName, contentType);
                    if (!File.Exists(destPath))
                    {
                        break;
                    }
                }
            }
            return destPath;
        }

        public static string GetSafeFileNameWithoutExt(string url)
        {
            string rs = GetSafeFileName(url);
            int l = rs.LastIndexOf(".");
            if (l > 0)
            {
                rs = rs.Substring(0, l);
            }
            return rs;
        }

        public static string GetSafeFileName(string url)
        {
            string rs = url;
            int l1 = url.LastIndexOf("/");
            int l2 = url.LastIndexOf("\\");
            int l = l1;
            if (l1 < l2)
            {
                l = l2;
            }
            if (l > 0)
            {
                rs = rs.Substring(l + 1);
            }
            return rs;
        }

        public static void SetWritable(string fileName)
        {
            if (string.IsNullOrWhiteSpace(fileName))
            {
                return;
            }
            FileInfo file = new FileInfo(fileName);
            if (file.Exists && !file.Attributes.Equals(FileAttributes.Directory))
            {
                file.IsReadOnly = false;
            }
        }

        public static void removeOldImg(string oldFilePath)
        {
            if (string.IsNullOrWhiteSpace(oldFilePath))
            {
                return;
            }
            FileInfo file = new FileInfo(oldFilePath);
            if (file.Exists && !file.Attributes.Equals(FileAttributes.Directory))
            {
                SetWritable(oldFilePath);
                file.Delete();
                //file.MoveTo(OldFilePath + "_rm");
            }
        }

        public static Project getHeadProject()
        {
            Project rs = new Project();
            rs.name = "All Project";
            return rs;
        }

        public static Project getNotLinkProject()
        {
            Project rs = new Project();
            rs.id = "-1";
            rs.name = "Not Link";
            return rs;
        }

        public static Floorplan getHeadFloorplan()
        {
            Floorplan rs = new Floorplan();
            rs.description = "All Floorplan";
            return rs;
        }

        public static Stage getHeadStage()
        {
            Stage rs = new Stage();
            rs.name = "All Stage";
            return rs;
        }

        public static Building getHeadBuilding()
        {
            Building rs = new Building();
            rs.building_num = "All Building";
            return rs;
        }

        public static IList<ComboBoxItem> getMediaTypeList(bool head)
        {
            IList<ComboBoxItem> mediaTypeList = new List<ComboBoxItem>();
            if (head)
            {
                mediaTypeList.Add(new ComboBoxItem((Byte)222, "All"));
            }
            mediaTypeList.Add(new ComboBoxItem(Media.MEDIA_TYPE_PIC, "Picture"));
            mediaTypeList.Add(new ComboBoxItem(Media.MEDIA_TYPE_VIDEO, "Video"));
            mediaTypeList.Add(new ComboBoxItem(Media.MEDIA_TYPE_PDF, "PDF"));
            return mediaTypeList;
        }

        public static IList<ComboBoxItem> getContentTypeList(bool head)
        {
            IList<ComboBoxItem> contentTypeList = new List<ComboBoxItem>();
            if (head)
            {
                contentTypeList.Add(new ComboBoxItem((Byte)222, "All"));
            }
            contentTypeList.Add(new ComboBoxItem(Media.CONTENT_TYPE_FLOORPLAN, "Floorplan"));
            contentTypeList.Add(new ComboBoxItem(Media.CONTENT_TYPE_RENDER_INTERNAL, "Render(Internal)"));
            contentTypeList.Add(new ComboBoxItem(Media.CONTENT_TYPE_RENDER_EXTERNAL, "Render(External)"));
            contentTypeList.Add(new ComboBoxItem(Media.CONTENT_TYPE_PHOTOGRAPH, "Photograph"));
            contentTypeList.Add(new ComboBoxItem(Media.CONTENT_TYPE_ENV, "Environment"));
            contentTypeList.Add(new ComboBoxItem(Media.CONTENT_TYPE_FLOORPLATE, "Floorplate"));
            contentTypeList.Add(new ComboBoxItem(Media.CONTENT_TYPE_OTHERS, "Other"));
            return contentTypeList;
        }

        public static Int16 getOrientationValue(bool east, bool south, bool west, bool north)
        {
            Int16 i = 0;
            if (east)
            {
                i += 1;
            }
            if (south)
            {
                i += 2;
            }
            if (west)
            {
                i += 4;
            }
            if (north)
            {
                i += 8;
            }
            return i;
        }

        public static Orientation getOrientation(Int16 value)
        {
            Orientation ori = new Orientation();
            int i = value;
            if (i % 2 == 1)
            {
                ori.east = true;
            }
            i = i >> 1;
            if (i % 2 == 1)
            {
                ori.south = true;
            }
            i = i >> 1;
            if (i % 2 == 1)
            {
                ori.west = true;
            }
            i = i >> 1;
            if (i % 2 == 1)
            {
                ori.north = true;
            }
            return ori;
        }


        public static Project getSelectedProject(IList<Project> source, string id)
        {
            foreach (Project c in source)
            {
                if (Utils.Equals(c.id, id))
                {
                    return c;
                }
            }
            return null;
        }

        public static Stage getSelectedStage(IList<Stage> source, string id)
        {
            foreach (Stage c in source)
            {
                if (Utils.Equals(c.id, id))
                {
                    return c;
                }
            }
            return null;
        }

        public static Building getSelectedBuilding(IList<Building> source, string id)
        {
            foreach (Building c in source)
            {
                if (Utils.Equals(c.id, id))
                {
                    return c;
                }
            }
            return null;
        }

        public static Floorplan getSelectedFloorplan(IList<Floorplan> source, string id)
        {
            foreach (Floorplan c in source)
            {
                if (Utils.Equals(c.id, id))
                {
                    return c;
                }
            }
            return null;
        }

        public static ComboBoxItem getSelected(IList<ComboBoxItem> source, object value)
        {
            foreach (ComboBoxItem c in source)
            {
                if (c.value.Equals(value))
                {
                    return c;
                }
            }
            return null;
        }

        public new static bool Equals(object source, object other)
        {
            if (source == null)
            {
                if (other != null)
                {
                    return false;
                }
                return true;
            }
            return source.Equals(other);
        }
    }
}
