using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using BeFun.Common;
using BeFun.Model.Domain;
using BeFun.Model.Query;

namespace BeFun.Model.Dao
{
    public class FloorplanDao : AccessDao<Floorplan>
    {
        private static string SQL_QUERY = "SELECT f.*,b.building_num,s.id AS stage_id,s.name1 AS stage_name,p.name1 AS project_name"
            + " FROM ((floorplan f LEFT JOIN building b ON f.building_id = b.id)"
            + " LEFT JOIN stage s ON b.stage_id = s.id)"
            + " LEFT JOIN project p ON s.project_id = p.id ";
        private static string SQL_QUERY_ALL = SQL_QUERY;
        private static string SQL_QUERY_BYID = SQL_QUERY + " WHERE f.id = @id;";
        private static string SQL_DELETE = "DELETE FROM floorplan WHERE id IN (";
        private static string SQL_INSERT = "INSERT INTO floorplan (project_id,building_id,picture_id,sale_picture_id,description,type,is_split,is_studio,bedroom_count,bathroom_count,studyroom_count,open_baclony_count,enclosed_baclony_count,courtyard_count,orientation,internal_size,external_size,total_size,land_size,removed,id)"
            + " VALUES (@project_id,@building_id,@picture_id,@sale_picture_id,@description,@type,@is_split,@is_studio,@bedroom_count,@bathroom_count,@studyroom_count,@open_baclony_count,@enclosed_baclony_count,@courtyard_count,@orientation,@internal_size,@external_size,@total_size,@land_size,@removed,@id);";
        private static string SQL_UPDATE = "UPDATE floorplan SET project_id = @project_id,building_id = @building_id,picture_id = @picture_id,sale_picture_id = @sale_picture_id,description = @description,type = @type,is_split = @is_split,is_studio = @is_studio,bedroom_count = @bedroom_count,bathroom_count = @bathroom_count,studyroom_count = @studyroom_count,"
            + " open_baclony_count = @open_baclony_count,enclosed_baclony_count = @enclosed_baclony_count,courtyard_count = @courtyard_count,orientation = @orientation,internal_size = @internal_size,external_size = @external_size,total_size = @total_size,land_size = @land_size,removed = @removed WHERE id = @id;";
        private static string SQL_INSERT_MEDIA = "INSERT INTO floorplan_media (floorplan_id, media_id) VALUES (@floorplan_id, @media_id);";
        private static string SQL_DELETE_MEDIA = "DELETE FROM floorplan_media WHERE floorplan_id = @floorplan_id AND media_id = @media_id;";
        private static string SQL_DELETE_ALL_MEDIA = "DELETE FROM floorplan_media WHERE floorplan_id = @floorplan_id;";

        private ApartmentDao apartmentDao = new ApartmentDao();

        public FloorplanDao()
            : base()
        {
        }

        public override void remove(IList<string> ids)
        {
            foreach (string id in ids)
            {
                ApartmentQueryCondition qc = new ApartmentQueryCondition();
                qc.floorplan_id = id;
                IList<Apartment> apartments = this.apartmentDao.query(qc);
                IList<string> apartmentIds = new List<string>();
                foreach (Apartment s in apartments)
                {
                    apartmentIds.Add(s.id);
                }
                this.apartmentDao.remove(apartmentIds);
            }
            base.remove(ids);
        }
        #region parameters
        protected override void setParameters(OleDbParameterCollection parameters, Floorplan entity)
        {
            parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = entity.project_id;
            parameters.Add("@building_id", OleDbType.VarWChar, 255).Value = entity.building_id;
            parameters.Add("@picture_id", OleDbType.VarWChar, 255).Value = entity.picture_id;
            parameters.Add("@sale_picture_id", OleDbType.VarWChar, 255).Value = entity.sale_picture_id;
            parameters.Add("@description", OleDbType.LongVarWChar).Value = entity.description;
            parameters.Add("@type", OleDbType.SmallInt).Value = entity.type;
            parameters.Add("@is_split", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.is_split);
            parameters.Add("@is_studio", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.is_studio);
            parameters.Add("@bedroom_count", OleDbType.SmallInt).Value = entity.bedroom_count;
            parameters.Add("@bathroom_count", OleDbType.SmallInt).Value = entity.bathroom_count;
            parameters.Add("@studyroom_count", OleDbType.SmallInt).Value = entity.studyroom_count;
            parameters.Add("@open_baclony_count", OleDbType.SmallInt).Value = entity.open_baclony_count;
            parameters.Add("@enclosed_baclony_count", OleDbType.SmallInt).Value = entity.enclosed_baclony_count;
            parameters.Add("@courtyard_count", OleDbType.SmallInt).Value = entity.courtyard_count;
            parameters.Add("@orientation", OleDbType.SmallInt).Value = entity.orientation;
            parameters.Add("@internal_size", OleDbType.Double).Value = entity.internal_size;
            parameters.Add("@external_size", OleDbType.Double).Value = entity.external_size;
            parameters.Add("@total_size", OleDbType.Double).Value = entity.total_size;
            parameters.Add("@land_size", OleDbType.Double).Value = entity.land_size;
            parameters.Add("@removed", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.removed);
            
            if (!string.IsNullOrWhiteSpace(entity.id))
            {
                parameters.Add("@id", OleDbType.VarWChar, 255).Value = entity.id;
            }
        }

        protected override void setQueryParameters(OleDbParameterCollection parameters, QueryCondition queryCondition)
        {
            FloorplanQueryCondition qc = (FloorplanQueryCondition)queryCondition;
            if (!string.IsNullOrWhiteSpace(qc.building_id))
            {
                parameters.Add("@building_id", OleDbType.VarWChar, 255).Value = qc.building_id;
            }
            else if (!string.IsNullOrWhiteSpace(qc.stage_id))
            {
                parameters.Add("@stage_id", OleDbType.VarWChar, 255).Value = qc.stage_id;
            }
            else if (!string.IsNullOrWhiteSpace(qc.project_id))
            {
                parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = qc.project_id;
            }
        }

        protected override Floorplan parseEntity(DataRow row, bool display)
        {
            Floorplan entity = new Floorplan();
            entity.id = (string)row["id"];
            entity.project_id = (string)row["project_id"];
            entity.building_id = (string)row["building_id"];
            entity.picture_id = (string)row["picture_id"];
            entity.sale_picture_id = (string)row["sale_picture_id"];
            entity.description = (string)row["description"];
            entity.type = (Byte)row["type"];
            entity.is_split = Utils.byteToBool((Byte)row["is_split"]);
            entity.is_studio = Utils.byteToBool((Byte)row["is_studio"]);
            entity.bedroom_count = (Int16)row["bedroom_count"];
            entity.bathroom_count = (Int16)row["bathroom_count"];
            entity.studyroom_count = (Int16)row["studyroom_count"];
            entity.open_baclony_count = (Int16)row["open_baclony_count"];
            entity.enclosed_baclony_count = (Int16)row["enclosed_baclony_count"];
            entity.courtyard_count = (Int16)row["courtyard_count"];
            entity.orientation = (Int16)row["orientation"];
            entity.internal_size = (Double)row["internal_size"];
            entity.external_size = (Double)row["external_size"];
            entity.total_size = (Double)row["total_size"];
            entity.land_size = (Double)row["land_size"];
            entity.removed = Utils.byteToBool((Byte)row["removed"]);

            if (!(row["stage_id"] is System.DBNull))
            {
                entity.stage_id = (string)row["stage_id"];
            }
            // display properties
            if (display)
            {
                if (!(row["building_num"] is System.DBNull))
                {
                    entity.building_num = (string)row["building_num"];
                }
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

        public void addMedias(string floorplanId, IList<string> medias)
        {
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(SQL_INSERT_MEDIA, conn);
            cmd.Parameters.Add("@floorplan_id", OleDbType.VarWChar, 255).Value = floorplanId;
            cmd.Parameters.Add("@media_id", OleDbType.VarWChar, 255);

            OleDbTransaction tx = conn.BeginTransaction();
            cmd.Transaction = tx;
            bool success = false;
            try
            {
                conn.Open();
                foreach (string mediaId in medias)
                {
                    cmd.Parameters["@media_id"].Value = mediaId;
                    cmd.ExecuteNonQuery();
                    success = true;
                }
            }
            finally
            {
                //this.closeConn(conn);
                this.closeConn(conn, tx, success);
            }
        }

        public void addMedia(string floorplanId, string mediaId)
        {
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(SQL_INSERT_MEDIA, conn);
            cmd.Parameters.Add("@floorplan_id", OleDbType.VarWChar, 255).Value = floorplanId;
            cmd.Parameters.Add("@media_id", OleDbType.VarWChar, 255).Value = mediaId;
            OleDbTransaction tx = conn.BeginTransaction();
            cmd.Transaction = tx;
            bool success = false;
            try
            {
                conn.Open();
                cmd.ExecuteNonQuery();
                success = true;
            }
            finally
            {
                //this.closeConn(conn);
                this.closeConn(conn, tx, success);
            }
        }

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
            FloorplanQueryCondition qc = (FloorplanQueryCondition)queryCondition;
            string rs = SQL_QUERY;
            string conditions = null;
            if (!string.IsNullOrWhiteSpace(qc.building_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "f.building_id = @building_id");
            }
            else if (!string.IsNullOrWhiteSpace(qc.stage_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "s.id = @stage_id");
            }
            else if (!string.IsNullOrWhiteSpace(qc.project_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "f.project_id = @project_id");
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

        protected override string getId(Floorplan entity)
        {
            return entity.id;
        }

        protected override string generateId()
        {
            return DBUtils.GenerateFloorplanId();
        }
        #endregion
    }
}
