using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Model.Query;
using BeFun.View.ListWindow;

namespace BeFun.View
{
    public partial class ApartmentWindow : Form
    {
        public ListWindowType windowType = ListWindowType.View;

        public Apartment currentEntity { get; set; }

        private ProjectDao projectDao = new ProjectDao();
        private StageDao stageDao = new StageDao();
        private BuildingDao buildingDao = new BuildingDao();
        private FloorplanDao floorplanDao = new FloorplanDao();

        private IList<Project> projectList;
        private IList<Stage> stageList;
        private IList<Building> buildingList;
        private IList<Floorplan> floorplanList;

        public ApartmentQueryCondition queryCondition { get; set; }

        public ApartmentWindow():base()
        {
            currentEntity = null;
            this.Init();
        }

        public ApartmentWindow(ListWindowType windowType)
        {
            currentEntity = null;
            this.windowType = windowType;
            this.Init();
        }

        public ApartmentWindow(ApartmentQueryCondition qc)
        {
            this.queryCondition = qc;
            currentEntity = null;
            this.Init();
        }

        public ApartmentWindow(ListWindowType windowType, ApartmentQueryCondition qc)
        {
            this.queryCondition = qc;
            currentEntity = null;
            this.windowType = windowType;
            this.Init();
        }

        private void Init()
        {
            InitializeComponent();
            InitData();
            RefreshData();
            configComponent();
        }

        private void InitData()
        {
            projectList = this.projectDao.queryAll();
            projectList.Insert(0, Utils.getHeadProject());
            this.bindingSource_Project.DataSource = projectList;
            if (this.queryCondition != null && !string.IsNullOrWhiteSpace(this.queryCondition.project_id))
            {
                this.comboBox_Query_Project.SelectedValue = this.queryCondition.project_id;
            }
            this.comboBox_Query_Project_SelectedIndexChanged(null, null);

            if (this.queryCondition != null && !string.IsNullOrWhiteSpace(this.queryCondition.stage_id))
            {
                this.comboBox_Query_Stage.SelectedValue = this.queryCondition.stage_id;
            }
            this.comboBox_Query_Stage_SelectedIndexChanged(null, null);

            if (this.queryCondition != null && !string.IsNullOrWhiteSpace(this.queryCondition.building_id))
            {
                this.comboBox_Query_Building.SelectedValue = this.queryCondition.building_id;
            }
            this.comboBox_Query_Building_SelectedIndexChanged(null, null);

            if (this.queryCondition != null && !string.IsNullOrWhiteSpace(this.queryCondition.floorplan_id))
            {
                this.comboBox_Query_Floorplan.SelectedValue = this.queryCondition.floorplan_id;
            }
            if (this.queryCondition != null)
            {
                this.textBox_UnitNumber.Text = this.queryCondition.unit_number;
            }
        }

        public void RefreshData()
        {
            this.dataGridView.queryCondition = this.queryCondition;
            this.dataGridView.RefreshGrid();
        }

        private void configComponent()
        {
            this.dataGridView.parentWindow = this;
        }

        private void button_Search_Click(object sender, EventArgs e)
        {
            this.queryCondition = new ApartmentQueryCondition();
            this.queryCondition.project_id = (string)this.comboBox_Query_Project.SelectedValue;
            this.queryCondition.stage_id = (string)this.comboBox_Query_Stage.SelectedValue;
            this.queryCondition.building_id = (string)this.comboBox_Query_Building.SelectedValue;
            this.queryCondition.floorplan_id = (string)this.comboBox_Query_Floorplan.SelectedValue;
            this.queryCondition.unit_number = this.textBox_UnitNumber.Text;
            this.RefreshData();
        }

        private void comboBox_Query_Project_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Query_Project.SelectedValue != null)
            {
                StageQueryCondition qc = new StageQueryCondition();
                qc.project_id = (string)this.comboBox_Query_Project.SelectedValue;
                this.stageList = this.stageDao.query(qc);
                this.stageList.Insert(0, Utils.getHeadStage());
            }
            else
            {
                this.stageList = new List<Stage>();
                this.stageList.Add(Utils.getHeadStage());
            }
            this.bindingSource_Stage.DataSource = this.stageList;
            this.comboBox_Query_Stage_SelectedIndexChanged(null, null);
        }

        private void comboBox_Query_Stage_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Query_Stage.SelectedValue != null)
            {
                BuildingQueryCondition qc = new BuildingQueryCondition();
                qc.stage_id = (string)this.comboBox_Query_Stage.SelectedValue;
                this.buildingList = this.buildingDao.query(qc);
                this.buildingList.Insert(0, Utils.getHeadBuilding());
            }
            else
            {
                this.buildingList = new List<Building>();
                this.buildingList.Add(Utils.getHeadBuilding());
            }
            this.bindingSource_Building.DataSource = this.buildingList;
            this.comboBox_Query_Building_SelectedIndexChanged(null, null);
        }

        private void comboBox_Query_Building_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Query_Building.SelectedValue != null)
            {
                FloorplanQueryCondition qc = new FloorplanQueryCondition();
                qc.building_id = (string)this.comboBox_Query_Building.SelectedValue;
                this.floorplanList = this.floorplanDao.query(qc);
                this.floorplanList.Insert(0, Utils.getHeadFloorplan());
            }
            else
            {
                this.floorplanList = new List<Floorplan>();
                this.floorplanList.Insert(0, Utils.getHeadFloorplan());
            }
            this.bindingSource_Floorplan.DataSource = this.floorplanList;
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
