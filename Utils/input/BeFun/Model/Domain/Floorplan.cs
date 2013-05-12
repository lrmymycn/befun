using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Domain
{
    public class Floorplan : BaseModel
    {
        public Floorplan()
            : base()
        {
            this.id = null;
            this.project_id = null;
            this.stage_id = null;
            this.building_id = null;
            this.picture_id = "";
            this.sale_picture_id = "";
            this.description = "";
            this.type = 1;
            this.is_split = false;
            this.is_studio = false;
            this.bedroom_count = 0;
            this.bathroom_count = 0;
            this.studyroom_count = 0;
            this.open_baclony_count = 0;
            this.enclosed_baclony_count = 0;
            this.courtyard_count = 0;
            this.orientation = -1;
            this.internal_size = 0;
            this.external_size = 0;
            this.total_size = 0;
            this.land_size = 0;
        }

        public override string getId()
        {
            return this.id;
        }

        public override void setId(string id)
        {
            this.id = id;
        }

        public string id { get; set; }
        public string project_id { get; set; }
        public string building_id { get; set; }
        public string picture_id { get; set; }
        public string sale_picture_id { get; set; }
        public string description { get; set; }
        public Byte type { get; set; }
        public bool is_split { get; set; }
        public bool is_studio { get; set; }
        public Int16 bedroom_count { get; set; }
        public Int16 bathroom_count { get; set; }
        public Int16 studyroom_count { get; set; }
        public Int16 open_baclony_count { get; set; }
        public Int16 enclosed_baclony_count { get; set; }
        public Int16 courtyard_count { get; set; }
        public Int16 orientation { get; set; }
        public Double internal_size { get; set; }
        public Double external_size { get; set; }
        public Double total_size { get; set; }
        public Double land_size { get; set; }
        public string abs_name
        {
            get
            {
                if (this.id == null)
                {
                    return "All Floorplan";
                }
                return "bed-" + this.bedroom_count + " bath-" + this.bathroom_count + " s-" + this.studyroom_count;
            }
        }
        #region display properties
        public string building_num { get; set; }
        public string type_name
        {
            get
            {
                string rs = "undefined";
                switch (this.type)
                {
                    case 1:
                        rs = "Apartment";
                        break;
                    case 2:
                        rs = "Town House";
                        break;
                    case 3:
                        rs = "House";
                        break;
                    default:
                        break;
                }
                return rs;
            }
        }
        public string stage_id { get; set; }
        public string stage_name { get; set; }
        public string project_name { get; set; }
        #endregion
    }
}
