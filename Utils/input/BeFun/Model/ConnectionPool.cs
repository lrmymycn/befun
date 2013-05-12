using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.OleDb;

namespace BeFun.Model
{
    public class ConnectionPool
    {

        //private static string CONN_STRING_EXCEL = "Provider=Microsoft.ACE.OLEDB.12.0;Extended Properties=\"Excel 8.0;IMEX=1\";data source=";

        private static string CONN_STRING_ACCESS = "Provider=Microsoft.ACE.OLEDB.12.0;jet OleDB:Database Password=ywll_677)(*!@#;Data Source=";

        private static object lockThis = new object();

        private string filePath = null;

        private static ConnectionPool instance;

        public static ConnectionPool getInstance()
        {
            lock (lockThis)
            {
                if (instance == null)
                {
                    instance = new ConnectionPool();
                }
                return instance;
            }
        }

        public void init(String filePath)
        {
            if (filePath == null || filePath.Length == 0)
            {
                throw new ArgumentNullException("File path should be not null!");
            }
            if (this.filePath != null && this.filePath.Equals(filePath))
            {
                return;
            }
            this.filePath = filePath;
        }

        public bool isInited()
        {
            return this.filePath != null && this.filePath.Length > 0;
        }

        public OleDbConnection getConnection()
        {
            if (this.filePath == null || this.filePath.Length == 0)
            {
                throw new ArgumentNullException("File path should be not null!");
            }
            string connStr = CONN_STRING_ACCESS + this.filePath;
            OleDbConnection conn = new OleDbConnection(connStr);
            return conn;
        }
    }
}
