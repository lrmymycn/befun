using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using BeFun.Model.App;
using System.Data.OleDb;
using System.Data;

namespace BeFun.Model.Dao
{
    class VersionDao
    {
        private static string SQL_QUERY = "SELECT * FROM app_version";
        private static string SQL_UPDATE = "UPDATE app_version SET version = @version;";

        protected ConnectionPool connPool = ConnectionPool.getInstance();

        public AppVersion getDbVersion()
        {
            OleDbConnection conn = this.connPool.getConnection();
            try
            {
                conn.Open();
                DataSet ds = new DataSet();
                OleDbDataAdapter da = new OleDbDataAdapter(SQL_QUERY, conn);
                da.Fill(ds);
                AppVersion rs = this.parseEntity(ds.Tables[0].Rows[0]);
                return rs;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return null;
            }
            finally
            {
                this.closeConn(conn);
            }
        }

        public void update(AppVersion version)
        {
            OleDbConnection conn = this.connPool.getConnection();
            bool success = false;
            OleDbTransaction tx = null;
            try
            {
                conn.Open();
                OleDbCommand cmd = new OleDbCommand(SQL_UPDATE, conn);
                cmd.Parameters.Add("@version", OleDbType.VarWChar, 255).Value = version.toString();
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                int i = cmd.ExecuteNonQuery();
                success = true;
            }
            finally
            {
                this.closeConn(conn, tx, success);
            }
        }

        protected AppVersion parseEntity(DataRow row)
        {
            string versionStr = (string)row["version"];
            AppVersion entity = AppVersion.parseVersionString(versionStr);
            return entity;
        }

        #region close connection
        protected void closeConn(OleDbConnection conn)
        {
            if (conn != null && !conn.State.Equals(ConnectionState.Closed))
            {
                conn.Close();
            }
        }

        protected void closeConn(OleDbConnection conn, OleDbTransaction tx, bool success)
        {
            try
            {
                if (tx != null)
                {
                    if (success)
                    {
                        tx.Commit();
                    }
                    else
                    {
                        tx.Rollback();
                    }
                }
            }
            finally
            {
                if (conn != null && !conn.State.Equals(ConnectionState.Closed))
                {
                    conn.Close();
                }
            }
        }
        #endregion
    }
}
