using System;
using System.Windows.Forms;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.View.Component.GridView;
using BeFun.View.Editor;
using BeFun.View.ListWindow;
using BeFun.View.Component.Common;
using BeFun.Common;

namespace BeFun.View.Component.GirdView
{
    public class BuildingDataView : MyDataGridView<Building>
    {
        public BuildingWindow parentWindow { get; set; }

        public BuildingDataView()
            : base()
        {
            this.dao = new BuildingDao();
        }

        #region override default method
        protected override DialogResult showEditDialog(Building entity)
        {
            BuildingEditor editor = new BuildingEditor((BuildingDao)this.dao);
            try{
            editor.entity = entity;
            editor.renderEntity();
            return editor.ShowDialog(this);
            }
            catch (Exception ex)
            {
                MyMessageBox msgBox = new MyMessageBox("Data error!", ex, MyConstants.BOX_TYPE_ERROR);
                msgBox.ShowDialog(this);
                return DialogResult.Abort;
            }
        }

        protected override DialogResult showAddDialog(Building entity)
        {
            BuildingEditor editor = new BuildingEditor((BuildingDao)this.dao);
            try
            {
                Building building = new Building();
                if (this.parentWindow.queryCondition != null)
                {
                    building.project_id = this.parentWindow.queryCondition.project_id;
                    building.stage_id = this.parentWindow.queryCondition.stage_id;
                }
                editor.entity = building;
                editor.renderEntity();
                return editor.ShowDialog(this);
            }
            catch (Exception ex)
            {
                MyMessageBox msgBox = new MyMessageBox("Data error!", ex, MyConstants.BOX_TYPE_ERROR);
                msgBox.ShowDialog(this);
                return DialogResult.Abort;
            }
        }

        protected override void dataGridView_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (this.parentWindow.windowType == ListWindowType.View)
            {
                base.dataGridView_CellMouseDoubleClick(sender, e);
            }
            else
            {
                if (e.Button == MouseButtons.Left)
                {
                    if (e.RowIndex >= 0)
                    {
                        this.ClearSelection();
                        this.Rows[e.RowIndex].Selected = true;
                        if (this.SelectedExistData())
                        {
                            Building entity = this.SelectedObjects()[0];
                            if (entity != null)
                            {
                                this.parentWindow.currentEntity = entity;
                                this.parentWindow.DialogResult = DialogResult.OK;
                                this.parentWindow.Close();
                            }
                        }
                    }
                }
            }
        }
        #endregion
    }
}
