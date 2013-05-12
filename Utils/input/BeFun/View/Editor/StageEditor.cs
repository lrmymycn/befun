using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Common;

namespace BeFun.View.Editor
{
    public partial class StageEditor : MyEditor
    {
        private StageDao dao;

        private ProjectDao projectDao;

        public Stage entity { get; set; }

        private IList<Project> projectList;
        
        public StageEditor()
            : base()
        {
            this.dao = new StageDao();
            this.projectDao = new ProjectDao();
            InitializeComponent();
            InitData();
        }


        public StageEditor(StageDao dao)
            : base()
        {
            this.dao = dao;
            this.projectDao = new ProjectDao();
            InitializeComponent();
            InitData();
        }

        public override void renderEntity()
        {
            if (this.entity == null)
            {
                return;
            }
            this.comboBox_Project.SelectedItem = Utils.getSelectedProject(this.projectList, this.entity.project_id);
            this.textBox_Name.Text = this.entity.name;
            this.dateTimePicker_FinishDate.Value = this.entity.finish_date;
            this.richTextBox_Description.Text = this.entity.description;
        }

        public override void saveEntity()
        {
            if (this.entity == null)
            {
                this.entity = new Stage();
            }
            this.entity.project_id = (string)this.comboBox_Project.SelectedValue;
            this.entity.name = this.textBox_Name.Text;
            this.entity.finish_date = this.dateTimePicker_FinishDate.Value;
            this.entity.description = this.richTextBox_Description.Text;

            this.dao.save(this.entity);
        }

        #region user defined init

        private void InitData()
        {
            projectList = this.projectDao.queryAll();
            this.bindingSource_Project.DataSource = projectList;
        }

        #endregion

        #region event
        public void button_Save_Click(object sender, EventArgs e)
        {
            this.saveButton_click(sender, e);
        }

        public void button_Reset_Click(object sender, EventArgs e)
        {
            this.resetButton_click(sender, e);
        }

        public void button_Cancel_Click(object sender, EventArgs e)
        {
            this.cancelButton_click(sender, e);
        }
        #endregion
    }
}
