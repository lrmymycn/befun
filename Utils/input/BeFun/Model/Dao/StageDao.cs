using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.Domain;
using System.Data.OleDb;
using BeFun.Model.Query;
using System.Data;
using BeFun.Common;

namespace BeFun.Model.Dao
{
    public class StageDao : AccessDao<Stage>
    {
        private static string SQL_QUERY = "SELECT s.*,p.name1 AS project_name FROM stage s LEFT JOIN project p ON s.project_id = p.id ";
        private static string SQL_QUERY_ALL = SQL_QUERY;
        private static string SQL_QUERY_BYID = SQL_QUERY + " WHERE s.id = @id;";
        private static string SQL_DELETE = "DELETE FROM stage WHERE id IN (";
        private static string SQL_INSERT = "INSERT INTO stage (project_id,name1,description,finish_date,removed,id)"
            + " VALUES (@project_id,@name,@description,@finish_date,@removed,@id);";
        private static string SQL_UPDATE = "UPDATE stage SET project_id = @project_id,name1 = @name,description = @description,finish_date = @finish_date,removed = @removed WHERE id = @id;";

        private BuildingDao buildingDao = new BuildingDao();

        public StageDao()
            : base()
        {
        }

        public override void remove(IList<string> ids)
        {
            foreach (string id in ids)
            {
                BuildingQueryCondition qc = new BuildingQueryCondition();
                qc.stage_id = id;
                IList<Building> buildings = this.buildingDao.query(qc);
                IList<string> buildingIds = new List<string>();
                foreach (Building s in buildings)
                {
                    buildingIds.Add(s.id);
                }
                this.buildingDao.remove(buildingIds);
            }
            base.remove(ids);
        }
        #region parameters
        protected override void setParameters(OleDbParameterCollection parameters, Stage entity)
        {
            parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = entity.project_id;
            parameters.Add("@name", OleDbType.VarWChar, 255).Value = entity.name;
            parameters.Add("@description", OleDbType.LongVarWChar).Value = entity.description;
            parameters.Add("@finish_date", OleDbType.Date).Value = entity.finish_date;
            parameters.Add("@removed", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.removed);
            if (!string.IsNullOrWhiteSpace(entity.id))
            {
                parameters.Add("@id", OleDbType.VarWChar, 255).Value = entity.id;
            }
        }

        protected override void setQueryParameters(OleDbParameterCollection parameters, QueryCondition queryCondition)
        {
            StageQueryCondition qc = (StageQueryCondition)queryCondition;
            if (!string.IsNullOrWhiteSpace(qc.project_id))
            {
                parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = qc.project_id;
            }
        }

        protected override Stage parseEntity(DataRow row, bool display)
        {
            Stage entity = new Stage();
            entity.id = (string)row["id"];
            entity.project_id = (string)row["project_id"];
            entity.name = (string)row["name1"];
            entity.description = (string)row["description"];
            entity.finish_date = (DateTime)row["finish_date"];
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
        protected override String getQueryAllSQL()
        {
            return SQL_QUERY_ALL;
        }

        protected override String getQueryByIdSQL()
        {
            return SQL_QUERY_BYID;
        }

        protected override String getQuerySQL(QueryCondition queryCondition)
        {
            StageQueryCondition qc = (StageQueryCondition)queryCondition;
            string rs = SQL_QUERY;
            string conditions = null;
            if (!string.IsNullOrWhiteSpace(qc.project_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "s.project_id = @project_id");
            }
            rs += conditions;
            return rs;
        }

        protected override String getDeleteSQL()
        {
            return SQL_DELETE;
        }

        protected override String getUpdateSQL()
        {
            return SQL_UPDATE;
        }

        protected override String getInsertSQL()
        {
            return SQL_INSERT;
        }

        protected override string getId(Stage entity)
        {
            return entity.id;
        }

        protected override string generateId()
        {
            return DBUtils.GenerateStageId();
        }
        #endregion
    }
}
