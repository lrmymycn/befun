using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Query
{
    public class BuildingQueryCondition : QueryCondition
    {
        public BuildingQueryCondition()
        {
            this.project_id = null;
            this.stage_id = null;
        }

        public string project_id { get; set; }
        public string stage_id { get; set; }
    }
}
