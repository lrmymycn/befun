using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Domain
{
    public class Stage : BaseModel
    {
        public Stage()
            : base()
        {
            this.id = null;
            this.project_id = null;
            this.finish_date = DateTime.Now;
            this.name = "";
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
        public string project_id { get; set; }
        public string name { get; set; }
        public string description { get; set; }
        public DateTime finish_date { get; set; }

        #region display properties
        public string project_name { get; set; }
        #endregion
    }
}
