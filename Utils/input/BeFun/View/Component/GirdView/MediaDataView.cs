using System;
using System.Collections.Generic;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.View.Component.Common;
using BeFun.View.Component.GridView;
using BeFun.View.Editor;
using BeFun.View.ListWindow;

namespace BeFun.View.Component.GirdView
{
    public class MediaDataView : MyDataGridView<Media>
    {
        public MediaWindow parentWindow { get; set; }

        public MediaDataView()
            : base()
        {
            this.dao = new MediaDao();
        }

        #region override default method
        protected override DialogResult showEditDialog(Media entity)
        {
            MediaEditor editor = new MediaEditor((MediaDao)this.dao);
            editor.entity = entity;
            try
            {
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

        protected override DialogResult showAddDialog(Media entity)
        {
            MediaEditor editor = new MediaEditor((MediaDao)this.dao);
            try
            {
                Media media = new Media();
                if (this.parentWindow.queryCondition != null)
                {
                    media.project_id = this.parentWindow.queryCondition.project_id;
                }
                editor.entity = media;
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
                            Media entity = this.SelectedObjects()[0];
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

        protected override void dataGridViewSelect_click(object sender, EventArgs e)
        {
            if (this.SelectedRows.Count > 0)
            {
                IList<Media> medias = this.SelectedObjects();
                if (medias.Count > 0)
                {
                    this.parentWindow.currentEntities = medias;
                    this.parentWindow.currentEntity = medias[0];
                    this.parentWindow.DialogResult = DialogResult.OK;
                    this.parentWindow.Close();
                }
            }
        }
        #endregion
    }
}
