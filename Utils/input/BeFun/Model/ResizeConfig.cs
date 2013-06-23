using System;
using BeFun.Common;
using System.Collections.Generic;

namespace BeFun.Model
{
    class ResizeConfig
    {
        const String LOGO_SMALL = "logo-small.png";
        const String LOGO_MEDIUM = "logo-medium.png";
        const String LOGO_LARGE = "logo-large.png";
        public Boolean enableLogo { get; set; }
        public IList<Byte> enableLogoTypes { get; set; }
        public Int32 floorplan_smallWidth { get; set; }
        public Int32 floorplan_smallHeight { get; set; }
        public Int32 floorplan_mediumWidth { get; set; }
        public Int32 floorplan_mediumHeight { get; set; }
        public Int32 overview_smallWidth { get; set; }
        public Int32 overview_smallHeight { get; set; }
        public Int32 overview_mediumWidth { get; set; }
        public Int32 overview_mediumHeight { get; set; }
        public string smallLogo { get; set; }
        public string mediumLogo { get; set; }
        public string largeLogo { get; set; }

        private static object lockThis = new object();
        private static ResizeConfig instance;

        private ResizeConfig()
        {
            enableLogo = true;
            enableLogoTypes = new List<Byte>(1);
            enableLogoTypes.Add(0);
            floorplan_smallWidth = 160;
            floorplan_smallHeight = 120;
            floorplan_mediumWidth = 760;
            floorplan_mediumHeight = 570;
            overview_smallWidth = 160;
            overview_smallHeight = 120;
            overview_mediumWidth = 760;
            overview_mediumHeight = 570;
            smallLogo = PathUtils.GetCurrentAppPath() + "/" + LOGO_SMALL;
            mediumLogo = PathUtils.GetCurrentAppPath() + "/" + LOGO_MEDIUM;
            largeLogo = PathUtils.GetCurrentAppPath() + "/" + LOGO_LARGE;
        }

        public static ResizeConfig getInstance()
        {
            lock (lockThis)
            {
                if (instance == null)
                {
                    instance = new ResizeConfig();
                }
                return instance;
            }
        }
    }
}
