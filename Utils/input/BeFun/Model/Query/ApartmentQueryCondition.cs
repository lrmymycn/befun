using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Query
{
    public class ApartmentQueryCondition : QueryCondition
    {
        public ApartmentQueryCondition()
        {
            this.project_id = null;
            this.stage_id = null;
            this.building_id = null;
            this.floorplan_id = null;
            this.unit_number = null;
            this.id = null;
        }

        public string project_id { get; set; }
        public string stage_id { get; set; }
        public string building_id { get; set; }
        public string floorplan_id { get; set; }
        public string unit_number { get; set; }
        public string id { get; set; }
    }
}
