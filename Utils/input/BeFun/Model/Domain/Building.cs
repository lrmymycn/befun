using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Domain
{
    public class Building : BaseModel
    {
        public Building()
            : base()
        {
            this.id = null;
            this.project_id = null;
            this.stage_id = null;
            this.finish_date = DateTime.Now;
            this.floor_count = 1;
            this.orientation = 0;
            this.ready_house = false;
            this.building_num = "";
            this.description = "";
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
        public string stage_id { get; set; }
        public string building_num { get; set; }
        public string description { get; set; }
        public DateTime finish_date { get; set; }
        public Int16 floor_count { get; set; }
        public Int16 orientation { get; set; }
        public bool ready_house { get; set; }

        #region display properties
        public string stage_name { get; set; }
        public string project_id { get; set; }
        public string project_name { get; set; }
        #endregion
    }
}
