using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Common;
using System.IO;

namespace BeFun.Controller.OldVersionTrans
{
    class MediaTrans
    {
        MediaDao mediaDao = new MediaDao();

        public void translate(Media m)
        {
            string largeUrl = m.large_url;
            if (string.IsNullOrWhiteSpace(largeUrl) || !largeUrl.StartsWith("/img/"))
            {
                return;
            }
            string originalFilePath = this.GenerateAbsoluteMediaPath(largeUrl);
            string destFilePath = Utils.GetDestImagePath(m.project_id, originalFilePath, m.content_type);
            this.SaveMediaFile(originalFilePath, destFilePath);
            string url = PathUtils.GetSiteImgUrl(destFilePath);
            m.large_url = url;
            this.mediaDao.save(m);
        }

        private string GenerateAbsoluteMediaPath(string mediaUrl)
        {
            if (string.IsNullOrWhiteSpace(mediaUrl))
            {
                return PathUtils.GetCurrentPath();
            }
            if (mediaUrl.StartsWith("/") || mediaUrl.StartsWith("\\"))
            {
                return PathUtils.GetCurrentPath() + mediaUrl;
            }
            return PathUtils.GetCurrentPath() + "/" + mediaUrl;
        }

        private void SaveMediaFile(string originalFilePath, string destFileName)
        {
            if (string.IsNullOrWhiteSpace(originalFilePath) || !File.Exists(originalFilePath))
            {
                throw new ArgumentException("源文件不存在!");
            }
            if (string.IsNullOrWhiteSpace(destFileName))
            {
                throw new ArgumentException("目标路径不能为空!");
            }
            PathUtils.CreateDirectory(destFileName);
            File.Copy(originalFilePath, destFileName);
            Utils.SetWritable(destFileName);
        }

    }
}
