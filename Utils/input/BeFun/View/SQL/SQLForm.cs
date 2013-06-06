using System;
using System.Collections.Generic;
using System.Windows.Forms;
using BeFun.Model;
using BeFun.Model.Service;
using BeFun.View.Component.Common;
using BeFun.Common;

namespace BeFun.View.SQL
{
    public partial class SQLForm : Form
    {
        public SQLForm()
        {
            InitializeComponent();
        }

        private void button_Execute_Click(object sender, EventArgs e)
        {
            string sqlText = this.richTextBox_SQL.Text;
            string[] sql_statements = sqlText.Split('\n');
            IList<string> sqls = new List<string>();
            foreach (string sql in sql_statements)
            {
                sqls.Add(sql);
            }
            SQLExecutor sqlExec = new SQLExecutor(ConnectionPool.getInstance().getConnection(), sqls);
            try
            {
                string message = sqlExec.execute();
                MyMessageBox.ShowBox(this, message);
            }
            catch (Exception ex)
            {
                MyMessageBox.ShowBox(this, "Execute SQL error!", ex, MyConstants.BOX_TYPE_ERROR);
            }
        }
    }
}
