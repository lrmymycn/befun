using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.App;
using BeFun.Model;
using System.Data.OleDb;
using BeFun.Model.Service;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Model.Query;

namespace BeFun.Controller.Patch._1_0_0
{
    public class PatchTask0 : BasePatchTask
    {
        private AppVersion version = AppVersion.parseVersionString("1.0.0");

        private ProjectDao projectDao = new ProjectDao();

        private MediaDao mediaDao = new MediaDao();

        public override Model.App.AppVersion getVersion()
        {
            return this.version;
        }

        public override string doPatch(AppVersion dbVersion)
        {
            if (dbVersion != null && !dbVersion.before(this.getVersion()))
            {
                return "Don't patch " + this.version;
            }
            OleDbConnection conn = this.connPool.getConnection();
            StringBuilder sb = new StringBuilder();
            IList<string> sqls = new List<string>();
            sqls.Add("ALTER TABLE project_media ADD COLUMN seq_num Integer;");
            sqls.Add("CREATE TABLE app_version (version text(255));");
            sqls.Add("INSERT INTO app_version (version) values ('1.0.0');");
            SQLExecutor sqlExecutor = new SQLExecutor(ConnectionPool.getInstance().getConnection(), sqls);
            string rs = sqlExecutor.execute();
            IList<Project> projects = projectDao.queryAll();
            foreach (Project project in projects)
            {
                MediaQueryCondition mediaQC = new MediaQueryCondition();
                mediaQC.overview_project_id = project.id;
                mediaQC.media_type = Media.MEDIA_TYPE_PIC;
                IList<Media> medias = this.mediaDao.query(mediaQC);
                IList<string> mediaIds = new List<string>();
                foreach (Media m in medias)
                {
                    mediaIds.Add(m.id);
                }
                projectDao.removeAllOverviewMedias(project.id);
                projectDao.addMedias(project.id, mediaIds);
            }
            return rs;
        }
    }
}
