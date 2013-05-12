using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Model.Domain;
using BeFun.Model.Dao;
using BeFun.Common;
using BeFun.Model.Query;

namespace BeFun.View.Editor
{
    public partial class BuildingEditor :  MyEditor
    {
        private BuildingDao dao;

        private ProjectDao projectDao;

        private StageDao stageDao;

        public Building entity { get; set; }

        private IList<Project> projectList;

        private IList<Stage> stageList;

        public BuildingEditor()
            : base()
        {
            this.dao = new BuildingDao();
            this.projectDao = new ProjectDao();
            this.stageDao = new StageDao();
            InitializeComponent();
            InitData();
        }


        public BuildingEditor(BuildingDao dao)
            : base()
        {
            this.dao = dao;
            this.projectDao = new ProjectDao();
            this.stageDao = new StageDao();
            InitializeComponent();
            InitData();
        }

        public override void renderEntity()
        {
            if (this.entity == null)
            {
                return;
            }
            if (!string.IsNullOrWhiteSpace(this.entity.stage_id))
            {
                Stage stage = stageDao.queryById(this.entity.stage_id);
                this.comboBox_Project.SelectedItem = Utils.getSelectedProject(this.projectList, stage.project_id);
                this.comboBox_Stage.SelectedItem = Utils.getSelectedStage(this.stageList, this.entity.stage_id);
            }
            this.textBox_BuildingNum.Text = this.entity.building_num;
            this.dateTimePicker_FinishDate.Value = this.entity.finish_date;
            this.numericUpDown_FloorCount.Value = this.entity.floor_count;
            BeFun.Model.Domain.Orientation ori = Utils.getOrientation(this.entity.orientation);
            this.checkBox_Ori_East.Checked = ori.east;
            this.checkBox_Ori_South.Checked = ori.south;
            this.checkBox_Ori_West.Checked = ori.west;
            this.checkBox_Ori_North.Checked = ori.north;
            this.checkBox_ReadyHouse.Checked = this.entity.ready_house;
            this.richTextBox_Description.Text = this.entity.description;
        }

        public override void saveEntity()
        {
            if (this.entity == null)
            {
                this.entity = new Building();
            }
            this.entity.stage_id = (string)this.comboBox_Stage.SelectedValue;
            this.entity.ready_house = this.checkBox_ReadyHouse.Checked;
            this.entity.building_num = this.textBox_BuildingNum.Text;
            this.entity.description = this.richTextBox_Description.Text;
            this.entity.finish_date = this.dateTimePicker_FinishDate.Value;
            this.entity.floor_count = (Int16)this.numericUpDown_FloorCount.Value;
            this.entity.orientation = Utils.getOrientationValue(this.checkBox_Ori_East.Checked, this.checkBox_Ori_South.Checked, this.checkBox_Ori_West.Checked, this.checkBox_Ori_North.Checked);

            this.dao.save(this.entity);
        }

        #region user defined init

        private void InitData()
        {
            projectList = this.projectDao.queryAll();
            this.bindingSource_Project.DataSource = projectList;
            if (projectList.Count > 0)
            {
                StageQueryCondition qc = new StageQueryCondition();
                qc.project_id = projectList.ElementAt(0).getId();
                stageList = stageDao.query(qc);
            }
            else
            {
                stageList = new List<Stage>();
            }
            this.bindingSource_Stage.DataSource = stageList;
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

        private void comboBox_Project_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Project.SelectedValue == null)
            {
                return;
            }
            StageQueryCondition qc = new StageQueryCondition();
            qc.project_id = (string)this.comboBox_Project.SelectedValue;
            this.stageList = this.stageDao.query(qc);
            this.bindingSource_Stage.DataSource = this.stageList;
        }
        #endregion
    }
}
