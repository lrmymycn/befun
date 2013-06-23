using System.Collections.Generic;
using System.Text;
using System.Data.OleDb;
using System.Data;

namespace BeFun.Model.Service
{
    class SQLExecutor
    {
        enum SQLType { SELECT, EXECUTE, DDL };
        private OleDbConnection conn = null;

        private IList<string> sql_statements = null;

        public SQLExecutor(OleDbConnection conn, IList<string> sql_statements)
        {
            this.conn = conn;
            this.sql_statements = sql_statements;
        }

        public string execute()
        {
            StringBuilder sb = new StringBuilder();
            try
            {
                conn.Open();
                int i = 1;
                foreach (string sql in this.sql_statements)
                {
                    SQLType type = GetType(sql);
                    OleDbCommand cmd = null;
                    int rs = 0;
                    switch (type)
                    {
                        case SQLType.SELECT:
                            DataSet ds = new DataSet();
                            OleDbDataAdapter da = new OleDbDataAdapter(sql, conn);
                            da.Fill(ds);
                            sb.AppendLine("statement " + i + " return records " + ds.Tables[0].Rows.Count);
                            break;
                        case SQLType.EXECUTE:
                            cmd = new OleDbCommand(sql, conn);
                            rs = cmd.ExecuteNonQuery();
                            sb.AppendLine("statement " + i + " effect records " + rs);
                            break;
                        case SQLType.DDL:
                            cmd = new OleDbCommand(sql, conn);
                            rs = cmd.ExecuteNonQuery();
                            sb.AppendLine("statement " + i + ": " + rs);
                            break;
                    }
                }
            }
            finally
            {
                this.closeConn(conn);
            }
            return sb.ToString();
        }

        private SQLType GetType(string sql)
        {
            string lowerSQL = sql.ToLower();
            if (lowerSQL.StartsWith("select "))
            {
                return SQLType.SELECT;
            }

            if (lowerSQL.StartsWith("delete ") || lowerSQL.StartsWith("update ") || lowerSQL.StartsWith("insert "))
            {
                return SQLType.EXECUTE;
            }

            if (lowerSQL.StartsWith("create ") || lowerSQL.StartsWith("drop ") || lowerSQL.StartsWith("alter "))
            {
                return SQLType.DDL;
            }
            return SQLType.EXECUTE;
        }

        #region close connection
        protected void closeConn(OleDbConnection conn)
        {
            if (conn != null && !conn.State.Equals(ConnectionState.Closed))
            {
                conn.Close();
            }
        }
        #endregion
    }
}
