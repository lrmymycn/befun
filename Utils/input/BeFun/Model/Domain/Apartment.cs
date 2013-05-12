using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Domain
{
    public class Apartment : BaseModel
    {

        public Apartment()
            : base()
        {
            this.id = null;
            this.floorplan_id = null;
            this.building_id = null;
            this.description = "";
            this.unit_number = "";
            this.lot_number = "";
            this.floor = 0;
            this.penthouse = false;
            this.price = 0;
            this.unit_entitle_ment = 0;
            this.colorscheme = "";
            this.car_parking_count = 0;
            this.storageroom_count = 0;
            this.sold_out = false;
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
        public string floorplan_id { get; set; }
        public string building_id { get; set; }
        public string description { get; set; }
        public string unit_number { get; set; }
        public string lot_number { get; set; }
        public Int16 floor { get; set; }
        public bool penthouse { get; set; }
        public Int32 price { get; set; }
        public Int16 unit_entitle_ment { get; set; }
        public string colorscheme { get; set; }
        public Int16 car_parking_count { get; set; }
        public Int16 storageroom_count { get; set; }
        public bool sold_out { get; set; }


        #region display properties
        public string project_id { get; set; }
        public string stage_id { get; set; }
        public string floorplan_desc { get; set; }
        public string building_num { get; set; }
        public string stage_name { get; set; }
        public string project_name { get; set; }
        #endregion
    }
}
