using System.Windows.Forms;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.View.Editor;
using BeFun.View.Component.GridView;
using BeFun.View.Component.Common;
using BeFun.Common;
using System;

namespace BeFun.View.Component.GirdView
{
    public class ProjectDataView : MyDataGridView<Project>
    {
        public ProjectDataView()
            : base()
        {
            this.dao = new ProjectDao();
        }

        #region
        protected override DialogResult showEditDialog(Project entity)
        {
            ProjectEditor projectEditor = new ProjectEditor((ProjectDao)this.dao);
            try
            {
                projectEditor.entity = entity;
                projectEditor.renderEntity();
                return projectEditor.ShowDialog(this);
            }
            catch (Exception ex)
            {
                MyMessageBox msgBox = new MyMessageBox("Data error!", ex, MyConstants.BOX_TYPE_ERROR);
                msgBox.ShowDialog(this);
                return DialogResult.Abort;
            }
        }

        protected override DialogResult showAddDialog(Project entity)
        {
            ProjectEditor projectEditor = new ProjectEditor((ProjectDao)this.dao);
            try
            {
                projectEditor.renderEntity();
                return projectEditor.ShowDialog(this);
            }
            catch (Exception ex)
            {
                MyMessageBox msgBox = new MyMessageBox("Data error!", ex, MyConstants.BOX_TYPE_ERROR);
                msgBox.ShowDialog(this);
                return DialogResult.Abort;
            }
        }
        #endregion
    }
}
