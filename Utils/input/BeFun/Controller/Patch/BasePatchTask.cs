using System.Data;
using System.Data.OleDb;
using BeFun.Model;
using BeFun.Model.App;

namespace BeFun.Controller.Patch
{
    public abstract class BasePatchTask : IPatchTask
    {
        protected ConnectionPool connPool = ConnectionPool.getInstance();

        protected void closeConn(OleDbConnection conn)
        {
            if (conn != null && !conn.State.Equals(ConnectionState.Closed))
            {
                conn.Close();
            }
        }

        public abstract AppVersion getVersion();
        public abstract string doPatch(AppVersion dbVersion);
    }
}
