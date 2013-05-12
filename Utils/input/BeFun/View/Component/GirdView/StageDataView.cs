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
    public class StageDataView : MyDataGridView<Stage>
    {
        public StageWindow parentWindow { get; set; }

        public StageDataView()
            : base()
        {
            this.dao = new StageDao();
        }

        #region override default method
        protected override DialogResult showEditDialog(Stage entity)
        {
            StageEditor editor = new StageEditor((StageDao)this.dao);
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

        protected override DialogResult showAddDialog(Stage entity)
        {
            StageEditor editor = new StageEditor((StageDao)this.dao);
            try
            {
                Stage stage = new Stage();
                stage.project_id = this.parentWindow.queryCondition.project_id;
                editor.entity = stage;
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
                            Stage entity = this.SelectedObjects()[0];
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
