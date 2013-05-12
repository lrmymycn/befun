using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.Domain;
using System.Data.OleDb;
using BeFun.Common;
using BeFun.Model.Query;
using System.Data;

namespace BeFun.Model.Dao
{
    public class BuildingDao : AccessDao<Building>
    {
        private static string SQL_QUERY = "SELECT b.*,s.name1 AS stage_name,p.id AS project_id, p.name1 AS project_name"
            + " FROM (building b "
            + " LEFT JOIN stage s ON b.stage_id = s.id)"
            + " LEFT JOIN project p ON s.project_id = p.id ";
        private static string SQL_QUERY_ALL = SQL_QUERY;
        private static string SQL_QUERY_BYID = SQL_QUERY + " WHERE b.id = @id;";
        private static string SQL_DELETE = "DELETE FROM building WHERE id IN (";
        private static string SQL_INSERT = "INSERT INTO building (stage_id,building_num,description,finish_date,floor_count,orientation,ready_house,removed,id)"
            + " VALUES (@stage_id,@building_num,@description,@finish_date,@floor_count,@orientation,@ready_house,@removed,@id);";
        private static string SQL_UPDATE = "UPDATE building SET stage_id = @stage_id,building_num = @building_num,description = @description,finish_date = @finish_date,"
            +" floor_count = @floor_count,orientation = @orientation,ready_house = @ready_house,removed = @removed WHERE id = @id;";

        private FloorplanDao floorplanDao = new FloorplanDao();

        public BuildingDao()
            : base()
        {
        }

        public override void remove(IList<string> ids)
        {
            foreach (string id in ids)
            {
                FloorplanQueryCondition qc = new FloorplanQueryCondition();
                qc.building_id = id;
                IList<Floorplan> floorplans = this.floorplanDao.query(qc);
                IList<string> floorplanIds = new List<string>();
                foreach (Floorplan s in floorplans)
                {
                    floorplanIds.Add(s.id);
                }
                this.floorplanDao.remove(floorplanIds);
            }
            base.remove(ids);
        }
        #region parameters
        protected override void setParameters(OleDbParameterCollection parameters, Building entity)
        {
            parameters.Add("@stage_id", OleDbType.VarWChar, 255).Value = entity.stage_id;
            parameters.Add("@building_num", OleDbType.VarWChar, 255).Value = entity.building_num;
            parameters.Add("@description", OleDbType.LongVarWChar).Value = entity.description;
            parameters.Add("@finish_date", OleDbType.Date).Value = entity.finish_date;
            parameters.Add("@floor_count", OleDbType.SmallInt).Value = entity.floor_count;
            parameters.Add("@orientation", OleDbType.SmallInt).Value = entity.orientation;
            parameters.Add("@ready_house", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.ready_house);
            parameters.Add("@removed", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.removed);
            if (!string.IsNullOrWhiteSpace(entity.id))
            {
                parameters.Add("@id", OleDbType.VarWChar, 255).Value = entity.id;
            }
        }

        protected override void setQueryParameters(OleDbParameterCollection parameters, QueryCondition queryCondition)
        {
            BuildingQueryCondition qc = (BuildingQueryCondition)queryCondition;
            if (!string.IsNullOrWhiteSpace(qc.stage_id))
            {
                parameters.Add("@stage_id", OleDbType.VarWChar, 255).Value = qc.stage_id;
            }
            else if (!string.IsNullOrWhiteSpace(qc.project_id))
            {
                parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = qc.project_id;
            }
        }

        protected override Building parseEntity(DataRow row, bool display)
        {
            Building entity = new Building();
            entity.id = (string)row["id"];
            entity.stage_id = (string)row["stage_id"];
            entity.building_num = (string)row["building_num"];
            entity.description = (string)row["description"];
            entity.finish_date = (DateTime)row["finish_date"];
            entity.floor_count = (Int16)row["floor_count"];
            entity.orientation = (Int16)row["orientation"];
            entity.ready_house = Utils.byteToBool((Byte)row["ready_house"]);
            entity.removed = Utils.byteToBool((Byte)row["removed"]);

            if (!(row["project_id"] is System.DBNull))
            {
                entity.project_id = (string)row["project_id"];
            }
            // display properties
            if (display)
            {
                if (!(row["stage_name"] is System.DBNull))
                {
                    entity.stage_name = (string)row["stage_name"];
                }
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
            BuildingQueryCondition qc = (BuildingQueryCondition)queryCondition;
            string rs = SQL_QUERY_ALL;
            string conditions = null;
            if (!string.IsNullOrWhiteSpace(qc.stage_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "b.stage_id = @stage_id");
            }
            else if (!string.IsNullOrWhiteSpace(qc.project_id))
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

        protected override string getId(Building entity)
        {
            return entity.id;
        }

        protected override string generateId()
        {
            return DBUtils.GenerateBuildingId();
        }
        #endregion
    }
}
