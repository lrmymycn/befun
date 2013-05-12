using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.Domain;
using BeFun.Model.Dao;
using System.IO;
using BeFun.Model.Query;

namespace BeFun.Common
{
    public class OutputUtils
    {
        public const string SQ = "'";
        public const string COMMA = ",";
        public const string AREA_ID = "test_area";
        public const string SUBURB_ID = "test_suburb";
        public const string MEDIA_ID = "test_media";
        public const string DB_NULL = "NULL";
        private ProjectDao projectDao;
        private StageDao stageDao;
        private BuildingDao buildingDao;
        private FloorplanDao floorplanDao;
        private ApartmentDao apartmentDao;
        private MediaDao mediaDao;

        public OutputUtils()
        {
            this.projectDao = new ProjectDao();
            this.stageDao = new StageDao();
            this.buildingDao = new BuildingDao();
            this.floorplanDao = new FloorplanDao();
            this.apartmentDao = new ApartmentDao();
            this.mediaDao = new MediaDao();
        }

        public void Output(string directoryPath)
        {
            DateTime now = DateTime.Now;
            string timestamp = string.Format("{0:yyyyMMddHHmmss}", now);
            string filePath = directoryPath + "\\" + timestamp;
            DirectoryInfo di = new DirectoryInfo(filePath);
            if (!di.Exists)
            {
                di.Create();
            }
            this.OutputMedia(filePath + "\\" + "media.sql");
            this.OutputProject(filePath + "\\" + "project.sql");
            this.OutputStage(filePath + "\\" + "stage.sql");
            this.OutputBuilding(filePath + "\\" + "building.sql");
            this.OutputFloorplan(filePath + "\\" + "floorplan.sql");
            this.OutputApartment(filePath + "\\" + "apartment.sql");
        }

        public void OutputProject(string filePath)
        {

            StreamWriter sw = new StreamWriter(filePath);
            IList<Project> entities = this.projectDao.queryAll();
            foreach (Project e in entities)
            {
                sw.WriteLine(InsertSql(e));
            }
            sw.Close();
        }

        public void OutputStage(string filePath)
        {

            StreamWriter sw = new StreamWriter(filePath);
            IList<Stage> entities = this.stageDao.queryAll();
            foreach (Stage e in entities)
            {
                sw.WriteLine(InsertSql(e));
            }
            sw.Close();
        }

        public void OutputBuilding(string filePath)
        {

            StreamWriter sw = new StreamWriter(filePath);
            IList<Building> entities = this.buildingDao.queryAll();
            foreach (Building e in entities)
            {
                sw.WriteLine(InsertSql(e));
            }
            sw.Close();
        }

        public void OutputFloorplan(string filePath)
        {

            StreamWriter sw = new StreamWriter(filePath);
            IList<Floorplan> entities = this.floorplanDao.queryAll();
            foreach (Floorplan e in entities)
            {
                sw.WriteLine(InsertSql(e));
            }
            sw.Close();
        }

        public void OutputApartment(string filePath)
        {

            StreamWriter sw = new StreamWriter(filePath);
            IList<Apartment> entities = this.apartmentDao.queryAll();
            foreach (Apartment e in entities)
            {
                sw.WriteLine(InsertSql(e));
            }
            sw.Close();
        }

        public void OutputMedia(string filePath)
        {
            
            StreamWriter sw = new StreamWriter(filePath);
            IList<Media> entities = this.mediaDao.queryAll();
            foreach (Media e in entities)
            {
                sw.WriteLine(InsertSql(e));
            }
            sw.Close();
        }

        public static string getString(string originalStr)
        {
            if (originalStr == null)
            {
                return DB_NULL;
            }
            return SQ + originalStr + SQ;
        }

        public static string getStringNull(string originalStr)
        {
            if (string.IsNullOrWhiteSpace(originalStr))
            {
                return DB_NULL;
            }
            return SQ + originalStr + SQ;
        }

        public static string getDate(DateTime dateTime)
        {
            if (dateTime == null)
            {
                return DB_NULL;
            }
            return SQ + string.Format("{0:yyyy-MM-dd HH:mm:ss}", dateTime) + SQ;
        }

        public static string getInt32(Int32 i)
        {
            if (i == null)
            {
                return DB_NULL;
            }
            return i+"";
        }

        public static string getInt16(Int16 i)
        {
            if (i == null)
            {
                return DB_NULL;
            }
            return i + "";
        }

        public static string getByte(Byte i)
        {
            if (i == null)
            {
                return DB_NULL;
            }
            return i + "";
        }

        public static string getDouble(Double i)
        {
            if (i == null)
            {
                return DB_NULL;
            }
            return i + "";
        }

        public string InsertSql(Project entity)
        {
            string rs = "INSERT INTO project (id,suburb_id,block,name,picture_id,logo_id,site_url,description,features,finish_schema,developer,address,postcode,swimming_pool,gym,sauna,tennis_court,play_room,"
                + "func_room,theatre_cinema,music_room,library,bbq,receiption,visitor_parking,kids_play_ground,sky_garden,land_scaping,recreation_place,car_wash_bay,"
                + "others,finish_date,distancetocity,longitude,latitude,removed,creation_date,last_modified_date,enabled) VALUES (";
            rs += getString(entity.id);
            rs += COMMA + getString(SUBURB_ID);
            rs += COMMA + getString(entity.block);
            rs += COMMA + getString(entity.name);
            rs += COMMA + getStringNull(entity.picture_id);
            rs += COMMA + getStringNull(entity.logo_id);
            rs += COMMA + getString(entity.site_url);
            rs += COMMA + getString(entity.description);
            rs += COMMA + getString(entity.features);
            rs += COMMA + getString(entity.finish_schema);
            rs += COMMA + getString(entity.developer);
            rs += COMMA + getString(entity.address);
            rs += COMMA + getString(entity.postcode);
            rs += COMMA + getByte(Utils.boolToByte(entity.swimming_pool));
            rs += COMMA + getByte(Utils.boolToByte(entity.gym));
            rs += COMMA + getByte(Utils.boolToByte(entity.sauna));
            rs += COMMA + getByte(Utils.boolToByte(entity.tennis_court));
            rs += COMMA + getByte(Utils.boolToByte(entity.play_room));
            rs += COMMA + getByte(Utils.boolToByte(entity.func_room));
            rs += COMMA + getByte(Utils.boolToByte(entity.theatre_cinema));
            rs += COMMA + getByte(Utils.boolToByte(entity.music_room));
            rs += COMMA + getByte(Utils.boolToByte(entity.library));
            rs += COMMA + getByte(Utils.boolToByte(entity.bbq));
            rs += COMMA + getByte(Utils.boolToByte(entity.receiption));
            rs += COMMA + getByte(Utils.boolToByte(entity.visitor_parking));
            rs += COMMA + getByte(Utils.boolToByte(entity.kids_play_ground));
            rs += COMMA + getByte(Utils.boolToByte(entity.sky_garden));
            rs += COMMA + getByte(Utils.boolToByte(entity.land_scaping));
            rs += COMMA + getByte(Utils.boolToByte(entity.recreation_place));
            rs += COMMA + getByte(Utils.boolToByte(entity.car_wash_bay));
            rs += COMMA + getByte(Utils.boolToByte(entity.others));
            rs += COMMA + getDate(entity.finish_date);
            rs += COMMA + getDouble(entity.distancetocity);
            rs += COMMA + getDouble(entity.longitude);
            rs += COMMA + getDouble(entity.latitude);
            rs += COMMA + getByte(Utils.boolToByte(entity.removed));
            rs += COMMA + getDate(entity.creation_date);
            rs += COMMA + getDate(entity.last_modified_date);
            rs += COMMA + getByte(Utils.boolToByte(entity.enabled));
            rs += ");";
            MediaQueryCondition queryCondition = new MediaQueryCondition();
            queryCondition.overview_project_id = entity.id;
            IList<Media> medias = this.mediaDao.query(queryCondition);
            foreach (Media m in medias)
            {
                rs += "\n";
                rs += "INSERT INTO project_media (project_id,media_id,removed,creation_date,last_modified_date,enabled) ";
                rs += "VALUES (";
                rs += getString(entity.id);
                rs += COMMA + getString(m.id);
                rs += COMMA + getByte(Utils.boolToByte(false));
                rs += COMMA + getDate(DateTime.Now);
                rs += COMMA + getDate(DateTime.Now);
                rs += COMMA + getByte(Utils.boolToByte(true));
                rs += ");";
            }

            return rs;
        }

        public string InsertSql(Stage entity)
        {
            string rs = "INSERT INTO stage (id,project_id,name,description,finish_date,removed,creation_date,last_modified_date,enabled) VALUES (";
            rs += getString(entity.id);
            rs += COMMA + getString(entity.project_id);
            rs += COMMA + getString(entity.name);
            rs += COMMA + getString(entity.description);
            rs += COMMA + getDate(entity.finish_date);
            rs += COMMA + getByte(Utils.boolToByte(entity.removed));
            rs += COMMA + getDate(entity.creation_date);
            rs += COMMA + getDate(entity.last_modified_date);
            rs += COMMA + getByte(Utils.boolToByte(entity.enabled));
            rs += ");";
            return rs;
        }

        public string InsertSql(Building entity)
        {
            string rs = "INSERT INTO building (id,stage_id,building_num,description,finish_date,floor_count,orientation,ready_house,removed,creation_date,last_modified_date,enabled) VALUES (";
            rs += getString(entity.id);
            rs += COMMA + getString(entity.stage_id);
            rs += COMMA + getString(entity.building_num);
            rs += COMMA + getString(entity.description);
            rs += COMMA + getDate(entity.finish_date);
            rs += COMMA + getInt16(entity.floor_count);
            rs += COMMA + getInt16(entity.orientation);
            rs += COMMA + getByte(Utils.boolToByte(entity.ready_house));
            rs += COMMA + getByte(Utils.boolToByte(entity.removed));
            rs += COMMA + getDate(entity.creation_date);
            rs += COMMA + getDate(entity.last_modified_date);
            rs += COMMA + getByte(Utils.boolToByte(entity.enabled));
            rs += ");";
            return rs;
        }

        public string InsertSql(Floorplan entity)
        {
            string rs = "INSERT INTO floorplan (id,building_id,picture_id,sale_picture_id,description,type,is_split,is_studio,bedroom_count,"
                + "bathroom_count,studyroom_count,open_baclony_count,enclosed_baclony_count,courtyard_count,orientation,"
                + "internal_size,external_size,total_size,"
                +"removed,creation_date,last_modified_date,enabled) VALUES (";
            rs += getString(entity.id);
            rs += COMMA + getString(entity.building_id);
            rs += COMMA + getStringNull(entity.picture_id);
            rs += COMMA + getStringNull(entity.sale_picture_id);
            rs += COMMA + getString(entity.description);
            rs += COMMA + getByte(entity.type);
            rs += COMMA + getByte(Utils.boolToByte(entity.is_split));
            rs += COMMA + getByte(Utils.boolToByte(entity.is_studio));
            rs += COMMA + getInt16(entity.bedroom_count);
            rs += COMMA + getInt16(entity.bathroom_count);
            rs += COMMA + getInt16(entity.studyroom_count);
            rs += COMMA + getInt16(entity.open_baclony_count);
            rs += COMMA + getInt16(entity.enclosed_baclony_count);
            rs += COMMA + getInt16(entity.courtyard_count);
            rs += COMMA + getInt16(entity.orientation);
            rs += COMMA + getDouble(entity.internal_size);
            rs += COMMA + getDouble(entity.external_size);
            rs += COMMA + getDouble(entity.total_size);

            rs += COMMA + getByte(Utils.boolToByte(entity.removed));
            rs += COMMA + getDate(entity.creation_date);
            rs += COMMA + getDate(entity.last_modified_date);
            rs += COMMA + getByte(Utils.boolToByte(entity.enabled));
            rs += ");";
            return rs;
        }

        public string InsertSql(Apartment entity)
        {
            string rs = "INSERT INTO apartment (id,floorplan_id,description,unit_number,lot_number,floor,penthouse,"
                + "price,unit_entitle_ment,colorscheme,car_parking_count,storageroom_count,sold_out,"
                +"removed,creation_date,last_modified_date,enabled) VALUES (";
            rs += getString(entity.id);
            rs += COMMA + getString(entity.floorplan_id);
            rs += COMMA + getString(entity.description);
            rs += COMMA + getString(entity.unit_number);
            rs += COMMA + getString(entity.lot_number);
            rs += COMMA + getInt16(entity.floor);
            rs += COMMA + getByte(Utils.boolToByte(entity.penthouse));
            rs += COMMA + getInt32(entity.price);
            rs += COMMA + getInt16(entity.unit_entitle_ment);
            rs += COMMA + getString(entity.colorscheme);
            rs += COMMA + getInt16(entity.car_parking_count);
            rs += COMMA + getInt16(entity.storageroom_count);
            rs += COMMA + getByte(Utils.boolToByte(entity.sold_out));

            rs += COMMA + getByte(Utils.boolToByte(entity.removed));
            rs += COMMA + getDate(entity.creation_date);
            rs += COMMA + getDate(entity.last_modified_date);
            rs += COMMA + getByte(Utils.boolToByte(entity.enabled));
            rs += ");";
            return rs;
        }

        public string InsertSql(Media entity)
        {
            string rs = "INSERT INTO media (id,name,small_url,medium_url,large_url,alt,media_type,content_type,"
                + "removed,creation_date,last_modified_date,enabled) VALUES (";
            rs += getString(entity.id);
            rs += COMMA + getString(entity.name);
            rs += COMMA + getString(GenerateMediaUrl(entity.large_url, "small"));
            rs += COMMA + getString(GenerateMediaUrl(entity.large_url, "medium"));
            rs += COMMA + getString(GenerateMediaUrl(entity.large_url, "large"));
            rs += COMMA + getString(entity.alt);
            rs += COMMA + getByte(entity.media_type);
            rs += COMMA + getByte(entity.content_type);

            rs += COMMA + getByte(Utils.boolToByte(entity.removed));
            rs += COMMA + getDate(entity.creation_date);
            rs += COMMA + getDate(entity.last_modified_date);
            rs += COMMA + getByte(Utils.boolToByte(entity.enabled));
            rs += ");";
            return rs;
        }

        public static string GenerateMediaUrl(string originalUrl, string size)
        {
            int l1 = originalUrl.LastIndexOf("/");
            int l2 = originalUrl.LastIndexOf("\\");
            int l = l1;
            if (l1 < l2)
            {
                l = l2;
            }
            string safeFileName = originalUrl.Substring(l + 1);
            string prePath = originalUrl.Substring(0, l);
            return prePath + "/" + size + "/" + safeFileName;
        }
    }
}
