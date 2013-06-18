using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Model.App
{
    public class AppVersion
    {

        public int mainVersion = 0;
        public int smallVersion = 0;
        public int patchVersion = 0;

        public String toString()
        {
            return mainVersion + "." + smallVersion + "." + patchVersion;
        }

        public bool before(AppVersion destVersion)
        {
            if (this.mainVersion < destVersion.mainVersion)
            {
                return true;
            }
            else if (this.mainVersion > destVersion.mainVersion)
            {
                return false;
            }

            if (this.smallVersion < destVersion.smallVersion)
            {
                return true;
            }
            else if (this.smallVersion > destVersion.smallVersion)
            {
                return false;
            }

            if (this.patchVersion < destVersion.patchVersion)
            {
                return true;
            }
            else if (this.smallVersion > destVersion.smallVersion)
            {
                return false;
            }
            return false;
        }

        public static AppVersion parseVersionString(string str)
        {
            if (string.IsNullOrWhiteSpace(str))
            {
                throw new ArgumentException("Version string should be not-empty!");
            }
            AppVersion version = new AppVersion();
            string[] versionSegments = str.Split('.');
            version.mainVersion = int.Parse(versionSegments[0]);
            version.smallVersion = int.Parse(versionSegments[1]);
            version.patchVersion = int.Parse(versionSegments[2]);
            return version;
        }
    }
}
