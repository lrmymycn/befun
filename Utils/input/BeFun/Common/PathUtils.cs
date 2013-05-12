using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.Domain;
using System.IO;

namespace BeFun.Common
{
    public class PathUtils
    {
        public static string GetCurrentPath()
        {
            return System.Environment.CurrentDirectory;
        }

        public static string getAbstractPath(string file)
        {
            if (string.IsNullOrWhiteSpace(file))
            {
                return GetCurrentPath();
            }
            if (file.StartsWith("/") || file.StartsWith("\\"))
            {
                return GetCurrentPath() + file;
            }
            return GetCurrentPath() + "/" + file;
        }

        public static string GenerateImgPath(string safeFileName, Byte contentType)
        {
            string rs = GetCurrentPath() + "/img/";
            switch (contentType)
            {
                case Media.CONTENT_TYPE_FLOORPLAN:
                    rs += "fp/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_FLOORPLATE:
                    rs += "floorplate/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_OTHERS:
                    rs += "others/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_PHOTOGRAPH:
                    rs += "photograph/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_RENDER_INTERNAL:
                    rs += "render/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_RENDER_EXTERNAL:
                    rs += "render/" + safeFileName;
                    break;
                default:
                    rs += "default/" + safeFileName;
                    break;
            }
            return rs;
        }

        public static void CreateDirectory(string path)
        {
            FileInfo file = new FileInfo(path);
            Directory.CreateDirectory(file.DirectoryName);
        }

        public static string GetSiteImgUrl(string path)
        {
            int i = path.IndexOf("/img/");
            string url = path.Substring(i);
            return url;
        }

        public static bool IsSameFile(string sourcePath, string destPath)
        {
            if (string.IsNullOrWhiteSpace(sourcePath) || string.IsNullOrWhiteSpace(destPath))
            {
                return false;
            }
            FileInfo sourceFile = new FileInfo(sourcePath);
            FileInfo destFile = new FileInfo(destPath);
            return sourceFile.FullName.Equals(destFile.FullName);
        }

        public static bool IsSameDirectory(string sourcePath, string destPath)
        {
            if (string.IsNullOrWhiteSpace(sourcePath) || string.IsNullOrWhiteSpace(destPath))
            {
                return false;
            }
            FileInfo sourceFile = new FileInfo(sourcePath);
            FileInfo destFile = new FileInfo(destPath);
            return sourceFile.DirectoryName.Equals(destFile.DirectoryName);
        }
    }
}
