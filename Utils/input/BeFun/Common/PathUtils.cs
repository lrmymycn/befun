using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.Domain;
using System.IO;
using BeFun.Model;

namespace BeFun.Common
{
    public class PathUtils
    {
        public static string GetCurrentPath()
        {
            FileInfo dsFileInfo = ConnectionPool.getInstance().getDataFileInfo();
            if (dsFileInfo != null)
            {
                return dsFileInfo.Directory.FullName;
            }
            return System.Environment.CurrentDirectory;
        }

        public static string GetCurrentAppPath()
        {
            return System.Environment.CurrentDirectory;
        }

        public static string GetImgRootPath()
        {
            return GetCurrentPath() + "/img";
        }

        public static string GenerateAbsoluteMediaPath(string mediaUrl)
        {
            if (string.IsNullOrWhiteSpace(mediaUrl))
            {
                return GetImgRootPath();
            }
            if (mediaUrl.StartsWith("/") || mediaUrl.StartsWith("\\"))
            {
                return GetImgRootPath() + mediaUrl;
            }
            return GetImgRootPath() + "/" + mediaUrl;
        }

        /// <summary>
        /// 根据本地相对url生成真实绝对路径
        /// </summary>
        /// <param name="projectId">所属项目id</param>
        /// <param name="mediaUrl">相对url</param>
        /// <returns>真实本地路径</returns>
        public static string GenerateAbsoluteMediaPath(string projectId, string mediaUrl)
        {
            string rs = GetImgRootPath();
            if (!string.IsNullOrWhiteSpace(projectId))
            {
                rs += "/" + projectId;
            }
            if (string.IsNullOrWhiteSpace(mediaUrl))
            {
                return rs;
            }
            if (mediaUrl.StartsWith("/") || mediaUrl.StartsWith("\\"))
            {
                return rs + mediaUrl;
            }
            return rs + "/" + mediaUrl;
        }

        /// <summary>
        /// 生成媒体相对Url，此url仅在录入客户端本地生效
        /// </summary>
        /// <param name="safeFileName">媒体文件名</param>
        /// <param name="contentType">媒体类型</param>
        /// <returns>本地相对url</returns>
        public static string GenerateMediaUrl(string safeFileName, Byte contentType)
        {
            string rs = null;
            switch (contentType)
            {
                case Media.CONTENT_TYPE_FLOORPLAN:
                    rs = "/fp/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_FLOORPLATE:
                    rs = "/floorplate/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_OTHERS:
                    rs = "/others/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_PHOTOGRAPH:
                    rs = "/photograph/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_RENDER_INTERNAL:
                    rs = "/render/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_RENDER_EXTERNAL:
                    rs = "/render/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_PROJECT_DESCRIPTION:
                    rs = "/project/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_PROJECT_FEATURE:
                    rs = "/project/" + safeFileName;
                    break;
                case Media.CONTENT_TYPE_PROJECT_SCHEME:
                    rs = "/project/" + safeFileName;
                    break;
                default:
                    rs = "/default/" + safeFileName;
                    break;
            }
            return rs;
        }

        /// <summary>
        /// 生成媒体真实路径
        /// </summary>
        /// <param name="projectId">所属项目id</param>
        /// <param name="safeFileName">媒体名字</param>
        /// <param name="contentType">媒体类型</param>
        /// <returns>真实路径</returns>
        public static string GenerateMediaPath(string projectId, string safeFileName, Byte contentType)
        {
            string url = GenerateMediaUrl(safeFileName, contentType);
            return GenerateAbsoluteMediaPath(projectId, url);
        }

        public static void CreateDirectory(string filePath)
        {
            FileInfo file = new FileInfo(filePath);
            Directory.CreateDirectory(file.DirectoryName);
        }

        /// <summary>
        /// 根据本地真实路径生成相对url
        /// </summary>
        /// <param name="absoluteFilePath"></param>
        /// <returns></returns>
        public static string GetSiteImgUrl(string absoluteFilePath)
        {
            int i = absoluteFilePath.IndexOf("/img/");
            i += 4;
            string url = absoluteFilePath.Substring(i);
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
