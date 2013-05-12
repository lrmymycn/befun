using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Query
{
    public class ProjectQueryCondition : QueryCondition
    {
        public ProjectQueryCondition()
        {
            this.blockOrName = "";
        }

        public string blockOrName { get; set; }
    }
}
