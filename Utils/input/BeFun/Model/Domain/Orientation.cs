using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Common;

namespace BeFun.Model.Domain
{
    public class Orientation
    {
        public Orientation()
        {
            this.east = false;
            this.south = false;
            this.west = false;
            this.north = false;
        }

        public bool east{get;set;}
        public bool south{get;set;}
        public bool west { get; set; }
        public bool north { get; set; }
    }
}
