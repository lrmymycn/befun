using System;
using System.Collections.Generic;
using System.Windows.Forms;
using BeFun.Model;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Common;
using BeFun.Model.Query;
using BeFun.View.ListWindow;
using BeFun.View.Component.Common;

namespace BeFun.View.Component.GridView
{
    public class MyDataGridView<T> : DataGridView where T : BaseModel
    {
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Add;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Edit;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Remove;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Select;
        public IList<System.Windows.Forms.ToolStripMenuItem> extendedToolStripMenuItems;
        public IList<System.Windows.Forms.ToolStripMenuItem> alwaysExtendedToolStripMenuItems;
        private System.Windows.Forms.BindingSource bindingSource;
        private System.ComponentModel.IContainer parentContainer;

        public ListWindowType type { get; set; }

        protected AccessDao<T> dao;
        public QueryCondition queryCondition { get; set; }

        public MyDataGridView()
            : base()
        {
            this.type = ListWindowType.View;
            this.Init();
            this.DataSource = this.bindingSource;
        }

        public void ConfigContextMenu()
        {
            this.MultiSelect = (this.type == ListWindowType.MultiChoose || this.type == ListWindowType.View);
            if (this.type == ListWindowType.MultiChoose || this.type == ListWindowType.Choose)
            {
                this.contextMenuStrip.Items.Add(this.toolStripMenuItem_Select);
            }
            this.ConfigExtendContextMenu(this.extendedToolStripMenuItems);
            this.ConfigAlwaysExtendContextMenu(this.alwaysExtendedToolStripMenuItems);
        }

        private void ConfigExtendContextMenu(IList<System.Windows.Forms.ToolStripMenuItem> extendedToolStripMenuItems)
        {
            if (extendedToolStripMenuItems == null || extendedToolStripMenuItems.Count <= 0)
            {
                return;
            }
            foreach (System.Windows.Forms.ToolStripMenuItem item in extendedToolStripMenuItems)
            {
                this.contextMenuStrip.Items.Add(item);
            }
        }

        private void ConfigAlwaysExtendContextMenu(IList<System.Windows.Forms.ToolStripMenuItem> extendedToolStripMenuItems)
        {
            if (alwaysExtendedToolStripMenuItems == null || alwaysExtendedToolStripMenuItems.Count <= 0)
            {
                return;
            }
            foreach (System.Windows.Forms.ToolStripMenuItem item in alwaysExtendedToolStripMenuItems)
            {
                this.contextMenuStrip.Items.Add(item);
            }
        }

        private void Init()
        {
            this.contextMenuStrip = new ContextMenuStrip();
            this.toolStripMenuItem_Add = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Remove = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Edit = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Select = new System.Windows.Forms.ToolStripMenuItem();

            this.bindingSource = new BindingSource();

            this.CellMouseUp += new DataGridViewCellMouseEventHandler(this.dataGridView_CellMouseUp);
            this.CellMouseDoubleClick += new DataGridViewCellMouseEventHandler(this.dataGridView_CellMouseDoubleClick);

            ((System.ComponentModel.ISupportInitialize)(this)).BeginInit();
            this.contextMenuStrip.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource)).BeginInit();
            // 
            // contextMenuStrip
            // 
            this.contextMenuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem_Add,
            this.toolStripMenuItem_Remove,
            this.toolStripMenuItem_Edit});
            this.contextMenuStrip.Name = "contextMenuStrip";
            this.contextMenuStrip.Size = new System.Drawing.Size(153, 52);
            // 
            // toolStripMenuItem_Add
            // 
            this.toolStripMenuItem_Add.Name = "toolStripMenuItem_Add";
            this.toolStripMenuItem_Add.Size = new System.Drawing.Size(123, 22);
            this.toolStripMenuItem_Add.Text = "&Add";
            this.toolStripMenuItem_Add.Click += new System.EventHandler(this.toolStripMenuItem_Add_Click);
            // 
            // toolStripMenuItem_Remove
            // 
            this.toolStripMenuItem_Remove.Name = "toolStripMenuItem_Remove";
            this.toolStripMenuItem_Remove.Size = new System.Drawing.Size(123, 22);
            this.toolStripMenuItem_Remove.Text = "&Remove";
            this.toolStripMenuItem_Remove.Click += new System.EventHandler(this.removeToolStripMenuItem_Click);
            // 
            // toolStripMenuItem_Edit
            // 
            this.toolStripMenuItem_Edit.Name = "toolStripMenuItem_Edit";
            this.toolStripMenuItem_Edit.Size = new System.Drawing.Size(152, 22);
            this.toolStripMenuItem_Edit.Text = "&Edit";
            this.toolStripMenuItem_Edit.Click += new System.EventHandler(this.toolStripMenuItem_Edit_Click);
            // 
            // toolStripMenuItem_Select
            // 
            this.toolStripMenuItem_Select = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Select.Name = "toolStripMenuItem_Select";
            this.toolStripMenuItem_Select.Size = new System.Drawing.Size(152, 22);
            this.toolStripMenuItem_Select.Text = "&Select";
            this.toolStripMenuItem_Select.Click += new System.EventHandler(this.toolStripMenuItem_Select_Click);

            ((System.ComponentModel.ISupportInitialize)(this)).EndInit();
            this.contextMenuStrip.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource)).EndInit();
            this.AllowUserToDeleteRows = false;
            this.AutoGenerateColumns = false;
            this.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.ColumnHeader;
            this.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.Dock = System.Windows.Forms.DockStyle.Fill;
            this.EnableHeadersVisualStyles = false;
            this.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.ReadOnly = true;
        }

        private void RefreshContextMenu()
        {
            this.toolStripMenuItem_Add.Visible = true;
            if (this.alwaysExtendedToolStripMenuItems != null)
            {
                foreach (System.Windows.Forms.ToolStripMenuItem item in this.alwaysExtendedToolStripMenuItems)
                {
                    item.Visible = true;
                }
            }
            if (!this.SelectedExistData())
            {
                this.toolStripMenuItem_Edit.Visible = false;
                this.toolStripMenuItem_Remove.Visible = false;
                this.toolStripMenuItem_Select.Visible = false;
                if (this.extendedToolStripMenuItems != null)
                {
                    foreach (System.Windows.Forms.ToolStripMenuItem item in extendedToolStripMenuItems)
                    {
                        item.Visible = false;
                    }
                }
            }
            else
            {
                this.toolStripMenuItem_Remove.Visible = true;
                this.toolStripMenuItem_Select.Visible = true;
                if (this.SelectedIds().Count == 1)
                {
                    this.toolStripMenuItem_Edit.Visible = true;
                    if (this.extendedToolStripMenuItems != null)
                    {
                        foreach (System.Windows.Forms.ToolStripMenuItem item in extendedToolStripMenuItems)
                        {
                            item.Visible = true;
                        }
                    }
                }
                else
                {
                    this.toolStripMenuItem_Edit.Visible = false;
                    if (this.extendedToolStripMenuItems != null)
                    {
                        foreach (System.Windows.Forms.ToolStripMenuItem item in extendedToolStripMenuItems)
                        {
                            item.Visible = false;
                        }
                    }
                }
            }
        }

        public IList<string> SelectedIds()
        {
            IList<string> rs = new List<string>();
            if (this.SelectedRows.Count > 0)
            {
                IList<string> ids = new List<string>();
                for (int i = 0; i < this.SelectedRows.Count; i++)
                {
                    DataGridViewRow row = this.SelectedRows[i];
                    if (row.Cells["id"].Value != null)
                    {
                        rs.Add(row.Cells["id"].Value.ToString());
                    }
                }
            }
            return rs;
        }

        public IList<T> SelectedObjects()
        {
            IList<string> ids = this.SelectedIds();
            IList<T> rs = new List<T>();
            foreach (string id in ids)
            {
                T entity = this.dao.queryById(id);
                if (entity != null)
                {
                    rs.Add(entity);
                }
            }
            return rs;
        }

        /// <summary>
        /// 是否已选中已存在的行
        /// </summary>
        /// <returns></returns>
        public bool SelectedExistData()
        {
            return SelectedIds().Count > 0;
        }

        protected void dataGridView_CellMouseUp(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (e.Button == MouseButtons.Right)
            {
                if (e.RowIndex >= 0)
                {
                    if ((this.SelectedRows.Count <= 1 && (this.type == ListWindowType.MultiChoose||this.type == ListWindowType.View)) || (this.type != ListWindowType.MultiChoose && this.type != ListWindowType.View))
                    {
                        this.ClearSelection();
                        this.Rows[e.RowIndex].Selected = true;
                    }
                    if (!ConnectionPool.getInstance().isInited())
                    {
                        this.contextMenuStrip.Enabled = false;
                    }
                    else
                    {
                        this.contextMenuStrip.Enabled = true;
                    }
                    this.RefreshContextMenu();
                    this.contextMenuStrip.Show(MousePosition.X, MousePosition.Y);
                }
            }
        }

        private void removeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MyConfirmBox box = new MyConfirmBox("Please confirm that you will remove this row and all data related to it!");
            if (box.ShowDialog(this) == DialogResult.Yes)
            {
                IList<string> ids = this.SelectedIds();
                if (ids.Count > 0)
                {
                    this.dao.remove(ids);
                    this.RefreshGrid();
                }
            }
        }

        private void toolStripMenuItem_Add_Click(object sender, EventArgs e)
        {
            if (this.showAddDialog(null) == DialogResult.OK)
            {
                this.RefreshGrid();
            }
        }

        private void toolStripMenuItem_Edit_Click(object sender, EventArgs e)
        {
            if (this.SelectedExistData())
            {
                T entity = this.SelectedObjects()[0];
                if (entity != null)
                {
                    if (this.showEditDialog(entity) == DialogResult.OK)
                    {
                        this.RefreshGrid();
                    }
                }
            }
        }

        private void toolStripMenuItem_Select_Click(object sender, EventArgs e)
        {
            this.dataGridViewSelect_click(sender, e);
        }

        protected virtual void dataGridViewSelect_click(object sender, EventArgs e)
        {
        }

        protected virtual void dataGridView_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (e.Button == MouseButtons.Left)
            {
                if (e.RowIndex >= 0)
                {
                    this.ClearSelection();
                    this.Rows[e.RowIndex].Selected = true;
                    this.toolStripMenuItem_Edit_Click(null, null);
                }
            }
        }

        protected virtual DialogResult showEditDialog(T entity)
        {
            return DialogResult.OK;
        }

        protected virtual DialogResult showAddDialog(T entity)
        {
            return DialogResult.OK;
        }

        public void RefreshGrid()
        {
            this.bindingSource.Clear();
            this.bindingSource.DataSource = this.dao.query(queryCondition);
        }

        private void InitializeComponent()
        {
            ((System.ComponentModel.ISupportInitialize)(this)).BeginInit();
            this.SuspendLayout();
            // 
            // MyDataGridView
            // 
            this.RowTemplate.Height = 23;
            ((System.ComponentModel.ISupportInitialize)(this)).EndInit();
            this.ResumeLayout(false);

        }

    }
}
