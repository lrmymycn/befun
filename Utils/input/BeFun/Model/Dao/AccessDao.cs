using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using BeFun.Model.Domain;
using BeFun.Model.Query;
using BeFun.Common;

namespace BeFun.Model.Dao
{
    public abstract class AccessDao<T> where T : BaseModel
    {
        protected ConnectionPool connPool = ConnectionPool.getInstance();

        public AccessDao()
        {
        }

        public IList<T> query(QueryCondition queryCondition)
        {
            OleDbConnection conn = this.connPool.getConnection();
            try
            {
                conn.Open();
                DataSet ds = new DataSet();
                if (queryCondition == null)
                {
                    OleDbDataAdapter da = new OleDbDataAdapter(this.getQueryAllSQL(), conn);
                    da.Fill(ds);
                }
                else
                {
                    OleDbDataAdapter da = new OleDbDataAdapter(this.getQuerySQL(queryCondition), conn);
                    setQueryParameters(da.SelectCommand.Parameters, queryCondition);
                    foreach (OleDbParameter p in da.SelectCommand.Parameters)
                    {
                        Console.WriteLine(p.ParameterName + " : " + p.Value);
                    }
                    da.Fill(ds);
                }
                IList<T> rs = this.parseEntities(ds.Tables[0], true);
                return rs;
            }
            finally
            {
                this.closeConn(conn);
            }
        }

        public IList<T> queryAll()
        {
            OleDbConnection conn = this.connPool.getConnection();
            try
            {
                conn.Open();
                OleDbDataAdapter da = new OleDbDataAdapter(this.getQueryAllSQL(), conn);
                DataSet ds = new DataSet();
                da.Fill(ds);
                IList<T> rs = this.parseEntities(ds.Tables[0], true);
                return rs;
            }
            finally
            {
                this.closeConn(conn);
            }
        }

        public T queryById(string id)
        {
            OleDbConnection conn = this.connPool.getConnection();
            try
            {
                conn.Open();
                OleDbDataAdapter da = new OleDbDataAdapter(this.getQueryByIdSQL(), conn);
                da.SelectCommand.Parameters.Add("@id", OleDbType.VarWChar, 255).Value = id;
                DataSet dataSet = new DataSet();
                da.Fill(dataSet);
                IList<T> rs = parseEntities(dataSet.Tables[0], false);
                if (rs.Count > 0)
                {
                    return rs[0];
                }
            }
            finally
            {
                this.closeConn(conn);
            }
            return default(T);
        }

        private IList<T> parseEntities(DataTable table, bool display)
        {
            IList<T> rs = new List<T>();
            foreach (DataRow row in table.Rows)
            {
                rs.Add(parseEntity(row, display));
            }
            return rs;
        }

        public virtual void remove(IList<string> ids)
        {
            if (ids == null || ids.Count <= 0)
            {
                return;
            }
            string sql = "";
            for (Int32 i = 0; i < ids.Count; i++)
            {
                if (sql.Length > 0)
                {
                    sql += ",";
                }
                sql += ("'" + ids[i] + "'");
            }
            sql += ")";
            sql = this.getDeleteSQL() + sql;
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(sql, conn);
            OleDbTransaction tx = null;
            bool success = false;
            try
            {
                conn.Open();
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                int i = cmd.ExecuteNonQuery();
                success = true;
            }
            finally
            {
                //this.closeConn(conn);
                this.closeConn(conn, tx, success);
            }
        }

        public void save(T entity)
        {
            if (this.getId(entity) != null)
            {
                Console.WriteLine("update");
                this.update(entity);
            }
            else
            {
                Console.WriteLine("add");
                this.add(entity);
            }
        }

        public virtual void add(T entity)
        {
            entity.setId(this.generateId());
            OleDbConnection conn = this.connPool.getConnection();
            OleDbCommand cmd = new OleDbCommand(this.getInsertSQL(), conn);
            setParameters(cmd.Parameters, entity);
            bool success = false;
            OleDbTransaction tx = null;
            try
            {
                conn.Open();
                foreach (OleDbParameter p in cmd.Parameters)
                {
                    Console.WriteLine(p.ParameterName+":"+p.Value);
                }
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                int i = cmd.ExecuteNonQuery();
                Console.WriteLine(i + " Add " + entity.GetType());
                success = true;
            }
            finally
            {
                //this.closeConn(conn);
                this.closeConn(conn, tx, success);
            }
        }

        public void update(T entity)
        {
            OleDbConnection conn = this.connPool.getConnection();
            Console.WriteLine(this.getUpdateSQL());
            OleDbCommand cmd = new OleDbCommand(this.getUpdateSQL(), conn);
            setParameters(cmd.Parameters, entity);
            bool success = false;
            OleDbTransaction tx = null;
            try
            {
                conn.Open();
                tx = conn.BeginTransaction();
                cmd.Transaction = tx;
                foreach (OleDbParameter p in cmd.Parameters)
                {
                    Console.WriteLine(p.ParameterName + " : " + p.Value);
                }
                int i = cmd.ExecuteNonQuery();
                Console.WriteLine(i + " Update " + entity.GetType() + " : " + entity.getId());
                success = true;
            }
            finally
            {
                //this.closeConn(conn);
                this.closeConn(conn, tx, success);
            }
        }

        public string getConditionsPre(string conditions, string logic, string addCondition)
        {
            string rs = null;
            if (string.IsNullOrWhiteSpace(conditions))
            {
                rs += "WHERE ";
            }
            else
            {
                rs += (logic + " ");
            }
            rs += addCondition;
            rs += " ";
            return rs;
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

        #region abstract methods
        protected abstract T parseEntity(DataRow row, bool display);

        protected abstract void setParameters(OleDbParameterCollection parameters, T entity);

        protected abstract void setQueryParameters(OleDbParameterCollection parameters, QueryCondition queryCondition);

        protected abstract String getQueryAllSQL();

        protected abstract String getDeleteSQL();

        protected abstract String getUpdateSQL();

        protected abstract String getInsertSQL();

        protected abstract String getQueryByIdSQL();

        protected abstract String getQuerySQL(QueryCondition queryCondition);

        protected abstract string getId(T entity);

        protected abstract string generateId();

        #endregion
    }
}
