using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.App;

namespace BeFun.Controller.Patch
{
    interface IPatchTask
    {
        AppVersion getVersion();
        string doPatch(AppVersion dbVersion);
    }
}
