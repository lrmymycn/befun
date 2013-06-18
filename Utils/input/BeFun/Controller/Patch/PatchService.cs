using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.Dao;
using BeFun.Model.App;

namespace BeFun.Controller.Patch
{
    class PatchService
    {
        private static IList<IPatchTask>  tasks = new List<IPatchTask>();

        private VersionDao dao = new VersionDao();

        public static void init()
        {
            if (tasks.Count <= 0)
            {
                tasks.Add(new BeFun.Controller.Patch._1_0_0.PatchTask0());
            }
        }

        public string doPatch()
        {
            init();
            AppVersion version = this.dao.getDbVersion();
            StringBuilder sb = new StringBuilder();
            foreach (IPatchTask task in tasks)
            {
                sb.Append(task.doPatch(version)).Append("\n");
            }
            return sb.ToString();
        }
    }
}
