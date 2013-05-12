using BeFun.Model.Domain;
using System;
using BeFun.Model.Query;
using BeFun.Common;
using System.Data.OleDb;
using System.Collections.Generic;
using System.Data;

namespace BeFun.Model.Dao
{
    public class ApartmentDao : AccessDao<Apartment>
    {
        private static string SQL_QUERY = "SELECT a.*,f.description AS floorplan_desc,b.building_num,s.id AS stage_id,s.name1 AS stage_name,p.id AS project_id,p.name1 AS project_name"
            + " FROM (((apartment a LEFT JOIN floorplan f ON a.floorplan_id = f.id)"
            + " LEFT JOIN building b ON f.building_id = b.id)"
            + " LEFT JOIN stage s ON b.stage_id = s.id) "
            + " LEFT JOIN project p ON s.project_id = p.id ";
        private static string SQL_QUERY_ALL = SQL_QUERY;
        private static string SQL_QUERY_BYID = SQL_QUERY+" WHERE a.id = @id;";
        private static string SQL_DELETE = "DELETE FROM apartment WHERE id IN (";
        private static string SQL_INSERT = "INSERT INTO apartment (floorplan_id,building_id,description,unit_number,lot_number,floor,penthouse,price,unit_entitle_ment,colorscheme,car_parking_count,storageroom_count,sold_out,removed,id)"
            + " VALUES (@floorplan_id,@building_id,@description,@unit_number,@lot_number,@floor,@penthouse,@price,@unit_entitle_ment,@colorscheme,@car_parking_count,@storageroom_count,@sold_out,@removed,@id);";
        private static string SQL_UPDATE = "UPDATE apartment SET floorplan_id = @floorplan_id,building_id = @building_id,description = @description,unit_number = @unit_number,lot_number = @lot_number,floor = @floor,"
            + "penthouse = @penthouse,price = @price,unit_entitle_ment = @unit_entitle_ment,colorscheme = @colorscheme,car_parking_count = @car_parking_count,storageroom_count = @storageroom_count,sold_out = @sold_out,removed = @removed WHERE id = @id;";
       
        public ApartmentDao()
            : base()
        {
        }

        #region parameters
        protected override void setParameters(OleDbParameterCollection parameters, Apartment entity)
        {
            parameters.Add("@floorplan_id", OleDbType.VarWChar, 255).Value = entity.floorplan_id;
            parameters.Add("@building_id", OleDbType.VarWChar, 255).Value = entity.building_id;
            parameters.Add("@description", OleDbType.LongVarWChar).Value = entity.description;
            parameters.Add("@unit_number", OleDbType.VarWChar, 255).Value = entity.unit_number;
            parameters.Add("@lot_number", OleDbType.VarWChar, 255).Value = entity.lot_number;
            parameters.Add("@floor", OleDbType.SmallInt).Value = entity.floor;
            parameters.Add("@penthouse", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.penthouse);
            parameters.Add("@price", OleDbType.Integer).Value = entity.price;
            parameters.Add("@unit_entitle_ment", OleDbType.SmallInt).Value = entity.unit_entitle_ment;
            parameters.Add("@colorscheme", OleDbType.VarWChar, 255).Value = entity.colorscheme;
            parameters.Add("@car_parking_count", OleDbType.SmallInt).Value = entity.car_parking_count;
            parameters.Add("@storageroom_count", OleDbType.SmallInt).Value = entity.storageroom_count;
            parameters.Add("@sold_out", OleDbType.UnsignedTinyInt).Value = entity.sold_out;
            parameters.Add("@removed", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.removed);
            if (!string.IsNullOrWhiteSpace(entity.id))
            {
                parameters.Add("@id", OleDbType.VarWChar, 255).Value = entity.id;
            }
        }

        protected override void setQueryParameters(OleDbParameterCollection parameters, QueryCondition queryCondition)
        {
            ApartmentQueryCondition qc = (ApartmentQueryCondition)queryCondition;
            if (!string.IsNullOrWhiteSpace(qc.unit_number))
            {
                parameters.Add("@unit_number", OleDbType.VarWChar, 255).Value = "%" + qc.unit_number + "%";
            }
            if (!string.IsNullOrWhiteSpace(qc.floorplan_id))
            {
                parameters.Add("@floorplan_id", OleDbType.VarWChar, 255).Value = qc.floorplan_id;
            }
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

        protected override Apartment parseEntity(DataRow row, bool display)
        {
            Apartment entity = new Apartment();
            entity.id = (string)row["id"];
            entity.floorplan_id = (string)row["floorplan_id"];
            entity.building_id = (string)row["building_id"];
            entity.description = (string)row["description"];
            entity.unit_number = (string)row["unit_number"];
            entity.lot_number = (string)row["lot_number"];
            entity.floor = (Int16)row["floor"];
            entity.penthouse = Utils.byteToBool((Byte)row["penthouse"]);
            entity.unit_entitle_ment = (Int16)row["unit_entitle_ment"];
            entity.colorscheme = (string)row["colorscheme"];
            entity.car_parking_count = (Int16)row["car_parking_count"];
            entity.storageroom_count = (Int16)row["storageroom_count"];
            entity.price = (Int32)row["price"];
            entity.sold_out = Utils.byteToBool((Byte)row["sold_out"]);
            entity.removed = Utils.byteToBool((Byte)row["removed"]);

            // display properties
            if (display)
            {
                if (!(row["project_id"] is System.DBNull))
                {
                    entity.project_id = (string)row["project_id"];
                }
                if (!(row["stage_id"] is System.DBNull))
                {
                    entity.stage_id = (string)row["stage_id"];
                }
                if (!(row["floorplan_desc"] is System.DBNull))
                {
                    entity.floorplan_desc = (string)row["floorplan_desc"];
                }
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
            ApartmentQueryCondition qc = (ApartmentQueryCondition)queryCondition;
            string rs = SQL_QUERY;
            string conditions = null;
            if (!string.IsNullOrWhiteSpace(qc.unit_number))
            {
                conditions += this.getConditionsPre(conditions, "AND", "a.unit_number LIKE @unit_number");
            }
            if (!string.IsNullOrWhiteSpace(qc.floorplan_id))
            {
                conditions += this.getConditionsPre(conditions, "AND", "a.floorplan_id = @floorplan_id");
            }
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

        protected override string getId(Apartment entity)
        {
            return entity.id;
        }

        protected override string generateId()
        {
            return DBUtils.GenerateApartmentId();
        }
        #endregion
    }
}
