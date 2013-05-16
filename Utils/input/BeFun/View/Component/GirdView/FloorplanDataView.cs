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
    class FloorplanDataView: MyDataGridView<Floorplan>
    {
        public FloorplanWindow parentWindow { get; set; }

        public FloorplanDataView()
            : base()
        {
            this.dao = new FloorplanDao();
        }
        
        #region override default method
        protected override DialogResult showEditDialog(Floorplan entity)
        {
            FloorplanEditor editor = new FloorplanEditor((FloorplanDao)this.dao);
            try
            {
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

        protected override DialogResult showAddDialog(Floorplan entity)
        {
            FloorplanEditor editor = new FloorplanEditor((FloorplanDao)this.dao);
            try
            {
                Floorplan floorplan = new Floorplan();
                if (this.parentWindow.queryCondition != null)
                {
                    floorplan.project_id = this.parentWindow.queryCondition.project_id;
                    floorplan.stage_id = this.parentWindow.queryCondition.stage_id;
                    floorplan.building_id = this.parentWindow.queryCondition.building_id;
                }
                editor.entity = floorplan;
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
                            Floorplan entity = this.SelectedObjects()[0];
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
