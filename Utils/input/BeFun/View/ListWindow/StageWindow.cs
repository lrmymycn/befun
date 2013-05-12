using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Model.Dao;
using BeFun.Common;
using BeFun.Model.Domain;
using BeFun.Model.Query;

namespace BeFun.View.ListWindow
{
    public partial class StageWindow : Form
    {
        private ProjectDao projectDao = new ProjectDao();

        public ListWindowType windowType = ListWindowType.View;

        public Stage currentEntity { get; set; }

        private IList<Project> projectList;

        public StageQueryCondition queryCondition { get; set; }
        
        public StageWindow()
            : base()
        {
            this.queryCondition = null;
            currentEntity = null;
            this.Init();
        }

        public StageWindow(ListWindowType windowType)
        {
            this.queryCondition = null;
            currentEntity = null;
            this.windowType = windowType;
            this.Init();
        }

        public StageWindow(StageQueryCondition qc)
        {
            this.queryCondition = qc;
            currentEntity = null;
            this.Init();
        }

        public StageWindow(ListWindowType windowType, StageQueryCondition qc)
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
            //building
            System.Windows.Forms.ToolStripMenuItem queryBuildingItem = new System.Windows.Forms.ToolStripMenuItem();
            queryBuildingItem.Name = "toolStripMenuItem_QueryBuilding";
            queryBuildingItem.Size = new System.Drawing.Size(152, 22);
            queryBuildingItem.Text = "Query &Building";
            queryBuildingItem.Click += new System.EventHandler(this.toolStripMenuItem_QueryBuilding_Click);
            extendedItems.Add(queryBuildingItem);
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

        private void toolStripMenuItem_QueryBuilding_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<Stage> objects = this.dataGridView.SelectedObjects();
                BuildingQueryCondition qc = new BuildingQueryCondition();
                qc.project_id = objects[0].project_id;
                qc.stage_id = objects[0].id;
                BuildingWindow queryWindow = new BuildingWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }
        private void toolStripMenuItem_QueryFloorplan_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<Stage> objects = this.dataGridView.SelectedObjects();
                FloorplanQueryCondition qc = new FloorplanQueryCondition();
                qc.project_id = objects[0].project_id;
                qc.stage_id = objects[0].id;
                FloorplanWindow queryWindow = new FloorplanWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }
        private void toolStripMenuItem_QueryApartment_Click(object sender, EventArgs e)
        {
            if (this.dataGridView.SelectedExistData())
            {
                IList<Stage> objects = this.dataGridView.SelectedObjects();
                ApartmentQueryCondition qc = new ApartmentQueryCondition();
                qc.project_id = objects[0].project_id;
                qc.stage_id = objects[0].id;
                ApartmentWindow queryWindow = new ApartmentWindow(qc);
                queryWindow.ShowDialog(this);
            }
        }

        private void button_Search_Click(object sender, EventArgs e)
        {
            this.queryCondition = new StageQueryCondition();
            this.queryCondition.project_id = (string)this.comboBox_Query_Project.SelectedValue;
            this.RefreshData();
        }

        private void button_Close_Click(object sender, EventArgs e)
        {
            this.Close();
        }

    }
}
