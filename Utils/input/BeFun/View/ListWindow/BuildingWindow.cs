using System;
using System.Collections.Generic;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Model.Query;
using BeFun.View.ListWindow;

namespace BeFun.View
{
    public partial class BuildingWindow : Form
    {
        private ProjectDao projectDao = new ProjectDao();

        private StageDao stageDao = new StageDao();

        public ListWindowType windowType = ListWindowType.View;

        public Building currentEntity { get; set; }

        private IList<Project> projectList;

        private IList<Stage> stageList;

        public BuildingQueryCondition queryCondition { get; set; }

        public BuildingWindow()
            : base()
        {
            this.queryCondition = null;
            currentEntity = null;
            this.Init();
        }

        public BuildingWindow(ListWindowType windowType)
        {
            this.queryCondition = null;
            currentEntity = null;
            this.windowType = windowType;
            this.Init();
        }
        
        public BuildingWindow(BuildingQueryCondition qc)
        {
            this.queryCondition = qc;
            currentEntity = null;
            this.Init();
        }

        public BuildingWindow(ListWindowType windowType, BuildingQueryCondition qc)
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
        }

        public void RefreshData()
        {
            this.dataGridView.queryCondition = this.queryCondition;
            this.dataGridView.RefreshGrid();
        }

        private void configComponent()
        {
            this.dataGridView.parentWindow = this;
            this.ConfigDataGridView();
        }

        private void ConfigDataGridView()
        {
            IList<System.Windows.Forms.ToolStripMenuItem> extendedItems = new List<System.Windows.Forms.ToolStripMenuItem>();
            //floorplan
            System.Windows.Forms.ToolStripMenuItem queryFloorplanItem = new System.Windows.Forms.ToolStripMenuItem();
            queryFloorplanItem.Name = "toolStripMenuItem_QueryFloorplan";
            queryFloorplanItem.Size = new System.Drawing.Size(152, 22);
            queryFloorplanItem.Text = "Query &Floorplan";
            queryFloorplanItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryFloorplan_Click);
            extendedItems.Add(queryFloorplanItem);
            //apartment
            System.Windows.Forms.ToolStripMenuItem queryApartmentItem = new System.Windows.Forms.ToolStripMenuItem();
            queryApartmentItem.Name = "toolStripMenuItem_QueryFloorplan";
            queryApartmentItem.Size = new System.Drawing.Size(152, 22);
            queryApartmentItem.Text = "Query A&partment";
            queryApartmentItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryApartment_Click);
            extendedItems.Add(queryApartmentItem);

            this.dataGridView.extendedToolStripMenuItems = extendedItems;
            this.dataGridView.ConfigContextMenu();
            this.dataGridView.RefreshGrid();
        }

        private void toolStripMenuItem_QueryFloorplan_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<Building> objects = this.dataGridView.SelectedObjects();
                FloorplanQueryCondition qc = new FloorplanQueryCondition();
                qc.project_id = objects[0].project_id;
                qc.stage_id = objects[0].stage_id;
                qc.building_id = objects[0].id;
                FloorplanWindow queryWindow = new FloorplanWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }
        private void toolStripMenuItem_QueryApartment_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<Building> objects = this.dataGridView.SelectedObjects();
                ApartmentQueryCondition qc = new ApartmentQueryCondition();
                qc.project_id = objects[0].project_id;
                qc.stage_id = objects[0].stage_id;
                qc.building_id = objects[0].id;
                ApartmentWindow queryWindow = new ApartmentWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void button_Search_Click(object sender, EventArgs e)
        {
            this.queryCondition = new BuildingQueryCondition();
            this.queryCondition.project_id = (string)this.comboBox_Query_Project.SelectedValue;
            this.queryCondition.stage_id = (string)this.comboBox_Query_Stage.SelectedValue;
            this.RefreshData();
        }

        private void comboBox_Query_Project_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Query_Project.SelectedValue != null)
            {
                StageQueryCondition qc = new StageQueryCondition();
                qc.project_id = (string)this.comboBox_Query_Project.SelectedValue;
                this.stageList = this.stageDao.query(qc);
            }
            else
            {
                this.stageList = new List<Stage>();
            }
            stageList.Insert(0, Utils.getHeadStage());
            this.bindingSource_Stage.DataSource = this.stageList;
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
