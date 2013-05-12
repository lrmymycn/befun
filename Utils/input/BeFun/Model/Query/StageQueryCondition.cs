using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Query
{
    public class StageQueryCondition : QueryCondition
    {
        public StageQueryCondition()
        {
            this.project_id = null;
        }

        public string project_id { get; set; }
    }
}
