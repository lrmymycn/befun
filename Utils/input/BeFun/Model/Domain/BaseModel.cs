using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.Domain
{
    public abstract class BaseModel
    {
        public BaseModel()
        {
            this.removed = false;
            this.creation_date = DateTime.Now;
            this.last_modified_date = DateTime.Now;
            this.enabled = true;
        }

        public bool removed { get; set; }
        public DateTime creation_date { get; set; }
        public DateTime last_modified_date { get; set; }
        public bool enabled { get; set; }

        public abstract string getId();

        public abstract void setId(string id);
    }
}
