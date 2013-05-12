using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Query
{
    public class MediaQueryCondition : QueryCondition
    {
        public MediaQueryCondition()
        {
            this.project_id = null;
            this.overview_project_id = null;
            this.floorplan_id = null;
            this.media_type = 222;
            this.content_type = 222;
            this.url = "";
        }

        public string project_id { get; set; }
        public string overview_project_id { get; set; }
        public string floorplan_id { get; set; }
        public Byte media_type { get; set; }
        public Byte content_type { get; set; }
        public string url { get; set; }
    }
}
