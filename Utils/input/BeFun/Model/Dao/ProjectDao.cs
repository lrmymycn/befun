using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using BeFun.Common;
using BeFun.Model.Domain;
using BeFun.Model.Query;

namespace BeFun.Model.Dao
{
    public class ProjectDao : AccessDao<Project>
    {
        private static string SQL_QUERY_ALL = "SELECT * FROM project;";
        private static string SQL_QUERY = "SELECT * FROM project WHERE block LIKE @block OR name1 LIKE @name;";
        private static string SQL_QUERY_BYID = "SELECT * FROM project WHERE id = @id;";
        private static string SQL_DELETE = "DELETE FROM project WHERE id IN (";
        private static string SQL_INSERT = "INSERT INTO project (block,name1,picture_id,logo_id,site_url,description,features,finish_schema,developer,address,postcode,swimming_pool,gym,sauna,tennis_court,play_room,func_room,theatre_cinema,music_room,library,bbq,receiption,visitor_parking,kids_play_ground,sky_garden,land_scaping,recreation_place,car_wash_bay,others,finish_date,distancetocity,longitude,latitude,removed,id) "
            + " VALUES (@block,@name,@picture_id,@logo_id,@site_url,@description,@features,@finish_schema,@developer,@address,@postcode,@swimming_pool,@gym,sauna,@tennis_court,@play_room,@func_room,@theatre_cinema,@music_room,@library,@bbq,@receiption,@visitor_parking,@kids_play_ground,@sky_garden,@land_scaping,@recreation_place,@car_wash_bay,@others,@finish_date,@distancetocity,@longitude,@latitude,@removed,@id);";
        private static string SQL_UPDATE = "UPDATE project SET block=@block, name1 = @name,picture_id = @picture_id,logo_id = @logo_id,site_url = @site_url,description = @description,features = @features,finish_schema = @finish_schema,developer = @developer,address = @address,postcode = @postcode,swimming_pool = @swimming_pool,gym = @gym,sauna = @sauna,tennis_court = @tennis_court,play_room = @play_room,func_room = @func_room, "
            + "theatre_cinema = @theatre_cinema,music_room = @music_room,library = @library,bbq = @bbq,receiption = @receiption,visitor_parking = @visitor_parking,kids_play_ground = @kids_play_ground,sky_garden = @sky_garden,land_scaping = @land_scaping,recreation_place = @recreation_place,car_wash_bay = @car_wash_bay,others = @others,finish_date = @finish_date,distancetocity = @distancetocity,longitude = @longitude,latitude = @latitude,removed = @removed WHERE id = @id;";
        private static string SQL_INSERT_MEDIA = "INSERT INTO project_media (project_id, media_id) VALUES (@project_id, @media_id);";
        private static string SQL_DELETE_MEDIA = "DELETE FROM project_media WHERE project_id = @project_id AND media_id = @media_id;";
        private static string SQL_DELETE_ALL_MEDIA = "DELETE FROM project_media WHERE project_id = @project_id;";

        private StageDao stageDao = new StageDao();
        private BuildingDao buildingDao = new BuildingDao();
        private MediaDao mediaDao = new MediaDao();

        public ProjectDao()
            : base()
        {
        }
        
        public override void remove(IList<string> ids)
        {
            if (ids == null || ids.Count <= 0)
            {
                return;
            }
            foreach (string id in ids)
            {
                StageQueryCondition qc = new StageQueryCondition();
                qc.project_id = id;
                IList<Stage> stages = this.stageDao.query(qc);
                IList<string> stageIds = new List<string>();
                foreach (Stage s in stages)
                {
                    stageIds.Add(s.id);
                }
                this.stageDao.remove(stageIds);
                this.removeAllOverviewMedias(id);

                MediaQueryCondition mqc = new MediaQueryCondition();
                mqc.project_id = id;
                IList<Media> medias = this.mediaDao.query(mqc);
                IList<string> mediaIds = new List<string>();
                foreach (Media m in medias)
                {
                    mediaIds.Add(m.id);
                }
                this.mediaDao.remove(mediaIds);
            }
            base.remove(ids);
        }

        #region parameters
        protected override void setParameters(OleDbParameterCollection parameters, Project entity)
        {
            parameters.Add("@block", OleDbType.VarWChar, 255).Value = entity.block;
            parameters.Add("@name", OleDbType.VarWChar, 255).Value = entity.name;
            parameters.Add("@picture_id", OleDbType.VarWChar, 255).Value = entity.picture_id;
            parameters.Add("@logo_id", OleDbType.VarWChar, 255).Value = entity.logo_id;
            parameters.Add("@site_url", OleDbType.LongVarWChar).Value = entity.site_url;
            parameters.Add("@description", OleDbType.LongVarWChar).Value = entity.description;
            parameters.Add("@features", OleDbType.LongVarWChar).Value = entity.features;
            parameters.Add("@finish_schema", OleDbType.LongVarWChar).Value = entity.finish_schema;
            parameters.Add("@developer", OleDbType.VarWChar, 255).Value = entity.developer;
            parameters.Add("@address", OleDbType.VarWChar, 255).Value = entity.address;
            parameters.Add("@postcode", OleDbType.VarWChar, 255).Value = entity.postcode;
            parameters.Add("@swimming_pool", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.swimming_pool);
            parameters.Add("@gym", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.gym);
            parameters.Add("@sauna", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.sauna);
            parameters.Add("@tennis_court", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.tennis_court);
            parameters.Add("@play_room", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.play_room);
            parameters.Add("@func_room", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.func_room);
            parameters.Add("@theatre_cinema", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.theatre_cinema);
            parameters.Add("@music_room", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.music_room);
            parameters.Add("@library", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.library);
            parameters.Add("@bbq", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.bbq);
            parameters.Add("@receiption", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.receiption);
            parameters.Add("@visitor_parking", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.visitor_parking);
            parameters.Add("@kids_play_ground", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.kids_play_ground);
            parameters.Add("@sky_garden", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.sky_garden);
            parameters.Add("@land_scaping", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.land_scaping);
            parameters.Add("@recreation_place", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.recreation_place);
            parameters.Add("@car_bay_wash", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.car_wash_bay);
            parameters.Add("@others", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.others);
            parameters.Add("@finish_date", OleDbType.Date).Value = entity.finish_date;
            parameters.Add("@distancetocity", OleDbType.Double).Value = entity.distancetocity;
            parameters.Add("@longitude", OleDbType.Double).Value = entity.longitude;
            parameters.Add("@latitude", OleDbType.Double).Value = entity.latitude;
            parameters.Add("@removed", OleDbType.UnsignedTinyInt).Value = Utils.boolToByte(entity.removed);
            if (!string.IsNullOrWhiteSpace(entity.id))
            {
                parameters.Add("@id", OleDbType.VarWChar, 255).Value = entity.id;
            }
        }

        protected override void setQueryParameters(OleDbParameterCollection parameters, Query.QueryCondition queryCondition)
        {
            Query.ProjectQueryCondition qc = (Query.ProjectQueryCondition)queryCondition;
            parameters.Add("@block", OleDbType.VarWChar, 255).Value = "%" + qc.blockOrName + "%";
            parameters.Add("@name", OleDbType.VarWChar, 255).Value = "%" + qc.blockOrName + "%";
        }

        protected override Project parseEntity(DataRow row, bool display)
        {
            Project entity = new Project();
            //Console.WriteLine("gym  " + row["gym"].GetType());
            entity.id = (string)row["id"];
            entity.picture_id = (string)row["picture_id"];
            entity.logo_id = (string)row["logo_id"];
            entity.block = (string)row["block"];
            entity.name = (string)row["name1"];
            entity.site_url = (string)row["site_url"];
            entity.developer = (string)row["developer"];
            entity.finish_date = (DateTime)row["finish_date"];
            entity.distancetocity = (Double)row["distancetocity"];
            entity.address = (string)row["address"];
            entity.postcode = (string)row["postcode"];
            entity.swimming_pool = Utils.byteToBool((Byte)row["swimming_pool"]);
            entity.gym = Utils.byteToBool((Byte)row["gym"]);
            entity.sauna = Utils.byteToBool((Byte)row["sauna"]);
            entity.tennis_court = Utils.byteToBool((Byte)row["tennis_court"]);
            entity.play_room = Utils.byteToBool((Byte)row["play_room"]);
            entity.func_room = Utils.byteToBool((Byte)row["func_room"]);
            entity.theatre_cinema = Utils.byteToBool((Byte)row["theatre_cinema"]);
            entity.music_room = Utils.byteToBool((Byte)row["music_room"]);
            entity.library = Utils.byteToBool((Byte)row["library"]);
            entity.bbq = Utils.byteToBool((Byte)row["bbq"]);
            entity.receiption = Utils.byteToBool((Byte)row["receiption"]);
            entity.visitor_parking = Utils.byteToBool((Byte)row["visitor_parking"]);
            entity.kids_play_ground = Utils.byteToBool((Byte)row["kids_play_ground"]);
            entity.sky_garden = Utils.byteToBool((Byte)row["sky_garden"]);
            entity.land_scaping = Utils.byteToBool((Byte)row["land_scaping"]);
            entity.recreation_place = Utils.byteToBool((Byte)row["recreation_place"]);
            entity.car_wash_bay = Utils.byteToBool((Byte)row["car_wash_bay"]);
            entity.others = Utils.byteToBool((Byte)row["others"]);
            entity.description = (string)row["description"];
            entity.features = (string)row["features"];
            entity.finish_schema = (string)row["finish_schema"];
            if (row["longitude"] is System.DBNull)
            {
                entity.longitude = 180;
            }
            else
            {
                entity.longitude = (Double)row["longitude"];
            }
            if (row["latitude"] is System.DBNull)
            {
                entity.latitude = 0;
            }
            else
            {
                entity.latitude = (Double)row["latitude"];
            }
            entity.removed = Utils.byteToBool((Byte)row["removed"]);
            return entity;
        }
        #endregion

        #region media
        public void addMedias(string projectId, IList<string> medias)
        {
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(SQL_INSERT_MEDIA, conn);
            cmd.Parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = projectId;
            cmd.Parameters.Add("@media_id", OleDbType.VarWChar, 255);

            OleDbTransaction tx = null;
            bool success = false;
            try
            {
                conn.Open();
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                foreach (string mediaId in medias)
                {
                    cmd.Parameters["@media_id"].Value = mediaId;
                    cmd.ExecuteNonQuery();
                }
                success = true;
            }
            finally
            {
                this.closeConn(conn, tx, success);
            }
        }

        public void addMedia(string projectId, string mediaId)
        {
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(SQL_INSERT_MEDIA, conn);
            cmd.Parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = projectId;
            cmd.Parameters.Add("@media_id", OleDbType.VarWChar, 255).Value = mediaId;

            OleDbTransaction tx = null;
            bool success = false;
            try
            {
                conn.Open();
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                cmd.ExecuteNonQuery();
                success = true;
            }
            finally
            {
                this.closeConn(conn, tx, success);
            }
        }

        public void removeAllOverviewMedias(string projectId)
        {
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(SQL_DELETE_ALL_MEDIA, conn);
            cmd.Parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = projectId;

            OleDbTransaction tx = null;
            bool success = false;
            try
            {
                conn.Open();
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                cmd.ExecuteNonQuery();
                success = true;
            }
            finally
            {
                //this.closeConn(conn);
                this.closeConn(conn, tx, success);
            }
        }

        public void removeMedias(string projectId, IList<string> medias)
        {
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(SQL_DELETE_ALL_MEDIA, conn);
            cmd.Parameters.Add("@project_id", OleDbType.VarWChar, 255).Value = projectId;
            cmd.Parameters.Add("@media_id", OleDbType.VarWChar, 255);
            OleDbTransaction tx = null;
            bool success = false;
            try
            {
                conn.Open();
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                foreach (string mediaId in medias)
                {
                    cmd.Parameters["@media_id"].Value = mediaId;
                    cmd.ExecuteNonQuery();
                }
                success = true;
            }
            finally
            {
                //this.closeConn(conn);
                this.closeConn(conn, tx, success);
            }
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
            return SQL_QUERY;
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

        protected override string getId(Project entity)
        {
            return entity.id;
        }

        protected override string generateId()
        {
            return DBUtils.GenerateProjectId();
        }
        #endregion
    }
}
