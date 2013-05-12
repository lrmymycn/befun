
using BeFun.Model.Domain;
using System.Data.OleDb;
using System.Data;
using System;
using BeFun.Model.Query;
using BeFun.Common;
using System.Collections.Generic;
using System.IO;
namespace BeFun.Model.Dao
{
    public class MediaDao : AccessDao<Media>
    {
        private static string SQL_QUERY = "SELECT m.*,p.name1 AS project_name FROM media m LEFT JOIN project p ON m.project_id = p.id ";
        private static string SQL_QUERY_ALL = SQL_QUERY;
        private static string SQL_QUERY_BYID = SQL_QUERY + " WHERE m.id = @id;";
        private static string SQL_DELETE = "DELETE FROM media WHERE id IN (";
        private static string SQL_INSERT = "INSERT INTO media (project_id,name1,small_url,medium_url,large_url,alt,media_type,content_type,removed,id)"
            + " VALUES (@project_id,@name,@small_url,@medium_url,@large_url,@alt,@media_type,@content_type,@removed,@id);";
        private static string SQL_UPDATE = "UPDATE media SET project_id = @project_id,name1 = @name,small_url = @small_url,medium_url = @medium_url,large_url = @large_url,alt = @alt,media_type = @media_type,content_type = @content_type,removed = @removed WHERE id = @id;";

        public MediaDao()
            : base()
        {
        }

        #region override operation
        public override void remove(IList<string> ids)
        {
            if (ids == null || ids.Count <= 0)
            {
                return;
            }
            Media m;
            foreach (string id in ids)
            {
                m = this.queryById(id);
                if (m != null)
                {
                    Utils.removeOldImg(PathUtils.getAbstractPath(m.small_url));
                    Utils.removeOldImg(PathUtils.getAbstractPath(m.medium_url));
                    Utils.removeOldImg(PathUtils.getAbstractPath(m.large_url));
                }
            }
            base.remove(ids);
        }
        #endregion

        #region parameters
        protected override void setParameters(OleDbParameterCollection parameters, Media entity)
        {
            parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = entity.project_id;
            parameters.Add("@name", OleDbType.VarWChar, 255).Value = entity.name;
            parameters.Add("@small_url", OleDbType.VarWChar, 255).Value = entity.small_url;
            parameters.Add("@medium_url", OleDbType.VarWChar, 255).Value = entity.medium_url;
            parameters.Add("@large_url", OleDbType.VarWChar, 255).Value = entity.large_url;
            parameters.Add("@alt", OleDbType.VarWChar, 255).Value = entity.alt;
            parameters.Add("@media_type", OleDbType.UnsignedTinyInt).Value = entity.media_type;
            parameters.Add("@content_type", OleDbType.UnsignedTinyInt).Value = entity.content_type;
            parameters.Add("@removed", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.removed);
            if (!string.IsNullOrWhiteSpace(entity.id))
            {
                parameters.Add("@id", OleDbType.VarWChar, 255).Value = entity.id;
            }
        }

        protected override void setQueryParameters(OleDbParameterCollection parameters, QueryCondition queryCondition)
        {
            MediaQueryCondition qc = (MediaQueryCondition)queryCondition;
                
            if (!string.IsNullOrWhiteSpace(qc.url))
            {
                parameters.Add("@url", OleDbType.VarWChar, 255).Value = "%" + qc.url + "%";
                parameters.Add("@url", OleDbType.VarWChar, 255).Value = "%" + qc.url + "%";
                parameters.Add("@url", OleDbType.VarWChar, 255).Value = "%" + qc.url + "%";
                parameters.Add("@url", OleDbType.VarWChar, 255).Value = "%" + qc.url + "%";
            }
            if (!string.IsNullOrWhiteSpace(qc.floorplan_id))
            {
                parameters.Add("@floorplan_id", OleDbType.VarWChar, 255).Value = qc.floorplan_id;
            }
            else if (!string.IsNullOrWhiteSpace(qc.project_id))
            {
                if (!qc.project_id.Equals("-1"))
                {
                    parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = qc.project_id;
                }
            }
            if (!string.IsNullOrWhiteSpace(qc.overview_project_id))
            {
                parameters.Add("@overview_project_id", OleDbType.VarWChar, 255).Value = qc.overview_project_id;
            }
            if (qc.media_type != 222)
            {
                parameters.Add("@media_type", OleDbType.UnsignedTinyInt).Value = qc.media_type;
            }
            if (qc.content_type != 222)
            {
                parameters.Add("@content_type", OleDbType.UnsignedTinyInt).Value = qc.content_type;
            }
        }

        protected override Media parseEntity(DataRow row, bool display)
        {
            Media entity = new Media();
            entity.id = (string)row["id"];
            entity.project_id = (string)row["project_id"];
            entity.name = (string)row["name1"];
            entity.small_url = (string)row["small_url"];
            entity.medium_url = (string)row["medium_url"];
            entity.large_url = (string)row["large_url"];
            entity.alt = (string)row["alt"];
            entity.media_type = (Byte)row["media_type"];
            entity.content_type = (Byte)row["content_type"];
            entity.removed = Utils.byteToBool((Byte)row["removed"]);

            // display properties
            if (display)
            {
                if (!(row["project_name"] is System.DBNull))
                {
                    entity.project_name = (string)row["project_name"];
                }
            }
            return entity;
        }
        #endregion

        #region SQL
        protected override string getQueryAllSQL()
        {
            return SQL_QUERY_ALL;
        }

        protected override string getQueryByIdSQL()
        {
            return SQL_QUERY_BYID;
        }

        protected override string getQuerySQL(QueryCondition queryCondition)
        {
            string rs = SQL_QUERY;
            string conditions = null;
            MediaQueryCondition qc = (MediaQueryCondition)queryCondition;
            if (!string.IsNullOrWhiteSpace(qc.url))
            {
                conditions += this.getConditionsPre(conditions, "AND", "(m.small_url LIKE @url OR medium_url LIKE @url OR large_url LIKE @url OR m.name1 LIKE @url)");
            }
            if (!string.IsNullOrWhiteSpace(qc.floorplan_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "m.id IN (SELECT fm.media_id FROM floorplan_media fm WHERE fm.floorplan_id = @floorplan_id)");
            }
            else if (!string.IsNullOrWhiteSpace(qc.project_id))
            {
                if (qc.project_id.Equals("-1"))
                {
                    conditions += this.getConditionsPre(conditions, "AND", "(m.project_id = '' OR m.project_id IS NULL )");
                }
                else
                {
                    conditions += this.getConditionsPre(conditions, "AND", "m.project_id = @project_id");
                }
            } 
            if (!string.IsNullOrWhiteSpace(qc.overview_project_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "m.id IN (SELECT pm.media_id FROM project_media pm WHERE pm.project_id = @overview_project_id)");
            }
            if (qc.media_type != 222)
            {
                conditions += this.getConditionsPre(conditions, "AND", "m.media_type = @media_type");
            }
            if (qc.content_type != 222)
            {
                conditions += this.getConditionsPre(conditions, "AND", "m.content_type = @content_type");
            }
            rs += conditions;
            return rs;
        }

        protected override string getDeleteSQL()
        {
            return SQL_DELETE;
        }

        protected override string getUpdateSQL()
        {
            return SQL_UPDATE;
        }

        protected override string getInsertSQL()
        {
            return SQL_INSERT;
        }

        protected override string getId(Media entity)
        {
            return entity.id;
        }

        protected override string generateId()
        {
            return DBUtils.GenerateMediaId();
        }
        #endregion
    }
}
