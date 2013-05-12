using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Domain;
using BeFun.Model.Query;
using BeFun.Model.Dao;

namespace BeFun.View.ListWindow
{
    public partial class FloorplanWindow : Form
    {
        public ListWindowType windowType = ListWindowType.View;

        private ProjectDao projectDao = new ProjectDao();

        private StageDao stageDao = new StageDao();

        private BuildingDao buildingDao = new BuildingDao();

        public Floorplan currentEntity { get; set; }

        private IList<Project> projectList;

        private IList<Stage> stageList;

        private IList<Building> buildingList;

        public FloorplanQueryCondition queryCondition { get; set; }

        public FloorplanWindow():base()
        {
            currentEntity = null;
            this.Init();
        }

        public FloorplanWindow(ListWindowType windowType)
        {
            currentEntity = null;
            this.windowType = windowType;
            this.Init();
        }

        public FloorplanWindow(FloorplanQueryCondition qc)
        {
            this.queryCondition = qc;
            currentEntity = null;
            this.Init();
        }

        public FloorplanWindow(ListWindowType windowType, FloorplanQueryCondition qc)
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
            //apartment
            System.Windows.Forms.ToolStripMenuItem queryApartmentItem = new System.Windows.Forms.ToolStripMenuItem();
            queryApartmentItem.Name = "toolStripMenuItem_QueryFloorplan";
            queryApartmentItem.Size = new System.Drawing.Size(152, 22);
            queryApartmentItem.Text = "Query A&partment";
            queryApartmentItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryApartment_Click);
            extendedItems.Add(queryApartmentItem);
            //media
            System.Windows.Forms.ToolStripMenuItem queryMediaItem = new System.Windows.Forms.ToolStripMenuItem();
            queryMediaItem.Name = "toolStripMenuItem_QueryMedia";
            queryMediaItem.Size = new System.Drawing.Size(152, 22);
            queryMediaItem.Text = "Query &Media";
            queryMediaItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryMedia_Click);
            extendedItems.Add(queryMediaItem);

            this.dataGridView.extendedToolStripMenuItems = extendedItems;
            this.dataGridView.ConfigContextMenu();
            this.dataGridView.RefreshGrid();
        }

        private void toolStripMenuItem_QueryApartment_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<Floorplan> objects = this.dataGridView.SelectedObjects();
                ApartmentQueryCondition qc = new ApartmentQueryCondition();
                qc.project_id = objects[0].project_id;
                qc.stage_id = objects[0].stage_id;
                qc.building_id = objects[0].building_id;
                qc.floorplan_id = objects[0].id;
                ApartmentWindow queryWindow = new ApartmentWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }
        private void toolStripMenuItem_QueryMedia_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<Floorplan> objects = this.dataGridView.SelectedObjects();
                MediaQueryCondition qc = new MediaQueryCondition();
                qc.project_id = objects[0].project_id;
                qc.content_type = Media.CONTENT_TYPE_FLOORPLAN;
                MediaWindow queryWindow = new MediaWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void button_Search_Click(object sender, EventArgs e)
        {
            this.queryCondition = new FloorplanQueryCondition();
            this.queryCondition.project_id = (string)this.comboBox_Query_Project.SelectedValue;
            this.queryCondition.stage_id = (string)this.comboBox_Query_Stage.SelectedValue;
            this.queryCondition.building_id = (string)this.comboBox_Query_Building.SelectedValue;
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
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Close();
        }

    }
}
