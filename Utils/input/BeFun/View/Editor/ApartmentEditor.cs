using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Common;
using BeFun.Model.Query;

namespace BeFun.View.Editor
{
    public partial class ApartmentEditor : MyEditor
    {
        private ApartmentDao dao;
        private ProjectDao projectDao = new ProjectDao();
        private StageDao stageDao = new StageDao();
        private BuildingDao buildingDao = new BuildingDao();
        private FloorplanDao floorplanDao = new FloorplanDao();

        public Apartment entity { get; set; }

        private IList<Project> projectList;
        private IList<Stage> stageList;
        private IList<Building> buildingList;
        private IList<Floorplan> floorplanList;

        private IList<ComboBoxItem> colorSchemeList = new List<ComboBoxItem>();
        
        public ApartmentEditor()
            : base()
        {
            this.dao = new ApartmentDao();
            InitializeComponent();
            InitData();
        }


        public ApartmentEditor(ApartmentDao dao)
            : base()
        {
            this.dao = dao;
            InitializeComponent();
            InitData();
        }

        public override void renderEntity()
        {
            if (this.entity == null)
            {
                this.entity = new Apartment();
            }
            string floorplan_id = entity.floorplan_id;
            string building_id = entity.building_id;
            string stage_id = entity.stage_id;
            string project_id = entity.project_id;

            if (!string.IsNullOrWhiteSpace(floorplan_id))
            {
                Floorplan floorplan = this.floorplanDao.queryById(floorplan_id);
                building_id = floorplan.building_id;
            }
            if (!string.IsNullOrWhiteSpace(building_id))
            {
                Building building = this.buildingDao.queryById(building_id);
                stage_id = building.stage_id;
            }
            if (!string.IsNullOrWhiteSpace(stage_id))
            {
                Stage stage = this.stageDao.queryById(stage_id);
                project_id = stage.project_id;
            }


            //project list
            if (string.IsNullOrWhiteSpace(project_id))
            {
                if (this.projectList != null && this.projectList.Count > 0)
                {
                    project_id = (string)this.comboBox_Project.SelectedValue;
                }
            }
            else
            {
                this.comboBox_Project.SelectedItem = Utils.getSelectedProject(this.projectList, project_id);
            }
            this.comboBox_Project_SelectedIndexChanged(null, null);
            //stage list
            if (string.IsNullOrWhiteSpace(stage_id))
            {
                if (this.stageList != null && this.stageList.Count > 0)
                {
                    stage_id = (string)this.comboBox_Stage.SelectedValue;
                }
            }
            else
            {
                this.comboBox_Stage.SelectedItem = Utils.getSelectedStage(this.stageList, stage_id);
            }
            this.comboBox_Stage_SelectedIndexChanged(null, null);
            //building list
            if (string.IsNullOrWhiteSpace(building_id))
            {
                if (this.buildingList != null && this.buildingList.Count > 0)
                {
                    building_id = (string)this.comboBox_Building.SelectedValue;
                }
            }
            else
            {
                this.comboBox_Building.SelectedItem = Utils.getSelectedBuilding(this.buildingList, building_id);
            }
            this.comboBox_Building_SelectedIndexChanged(null, null);

            //floorplan list
            if (string.IsNullOrWhiteSpace(floorplan_id))
            {
                if (this.floorplanList != null && this.floorplanList.Count > 0)
                {
                    floorplan_id = (string)this.comboBox_Floorplan.SelectedValue;
                }
            }
            else
            {
                this.comboBox_Floorplan.SelectedItem = Utils.getSelectedFloorplan(this.floorplanList, floorplan_id);
            }

            this.textBox_ColorScheme.Text = this.entity.colorscheme;
            this.textBox_LotNumber.Text = this.entity.lot_number;
            this.textBox_UnitNumber.Text = this.entity.unit_number;
            this.numericUpDown_CarParking.Value = this.entity.car_parking_count;
            this.numericUpDown_StorageRoom.Value = this.entity.storageroom_count;
            this.numericUpDown_Floor.Value = this.entity.floor;
            this.numericUpDown_Price.Value = this.entity.price;
            this.numericUpDown_UnitEntitlement.Value = this.entity.unit_entitle_ment;
            this.checkBox_Penthouse.Checked = this.entity.penthouse;
            this.checkBox_SoldOut.Checked = this.entity.sold_out;
            this.richTextBox_Description.Text = this.entity.description;
        }

        public override void saveEntity()
        {
            if (this.entity == null)
            {
                this.entity = new Apartment();
            }
            this.entity.floorplan_id = (string)this.comboBox_Floorplan.SelectedValue;
            this.entity.building_id = (string)this.comboBox_Building.SelectedValue;
            this.entity.colorscheme = this.textBox_ColorScheme.Text;
            this.entity.lot_number = this.textBox_LotNumber.Text;
            this.entity.unit_number = this.textBox_UnitNumber.Text;
            this.entity.car_parking_count = (Int16)this.numericUpDown_CarParking.Value;
            this.entity.storageroom_count = (Int16)this.numericUpDown_StorageRoom.Value;
            this.entity.floor = (Int16)this.numericUpDown_Floor.Value;
            this.entity.price = (Int32)this.numericUpDown_Price.Value;
            this.entity.unit_entitle_ment = (Int16)this.numericUpDown_UnitEntitlement.Value;
            this.entity.penthouse = this.checkBox_Penthouse.Checked;
            this.entity.sold_out = this.checkBox_SoldOut.Checked;
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
            this.comboBox_Stage_SelectedIndexChanged(null, null);
        }

        private void comboBox_Stage_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Stage.SelectedValue == null)
            {
                return;
            }
            BuildingQueryCondition qc = new BuildingQueryCondition();
            qc.stage_id = (string)this.comboBox_Stage.SelectedValue;
            this.buildingList = this.buildingDao.query(qc);
            this.bindingSource_Building.DataSource = this.buildingList;
            this.comboBox_Building_SelectedIndexChanged(null, null);
        }

        private void comboBox_Building_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (this.comboBox_Building.SelectedValue == null)
            {
                return;
            }
            FloorplanQueryCondition qc = new FloorplanQueryCondition();
            qc.building_id = (string)this.comboBox_Building.SelectedValue;
            this.floorplanList = this.floorplanDao.query(qc);
            this.bindingSource_Floorplan.DataSource = this.floorplanList;
        }

    }
}
