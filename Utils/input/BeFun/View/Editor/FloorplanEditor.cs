using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Model.Query;
using BeFun.View.ListWindow;

namespace BeFun.View.Editor
{
    public partial class FloorplanEditor : MyEditor
    {
        private FloorplanDao dao;

        private ProjectDao projectDao = new ProjectDao();
        private StageDao stageDao = new StageDao();
        private BuildingDao buildingDao = new BuildingDao();
        private MediaDao MediaDao = new MediaDao();
        private ApartmentDao apartmentDao = new ApartmentDao();

        public Floorplan entity { get; set; }

        private Media picture = null;
        private Media salePicture = null;

        private IList<Project> projectList;
        private IList<Stage> stageList;
        private IList<Building> buildingList;
        private IList<ComboBoxItem> typeList = new List<ComboBoxItem>();

        public FloorplanEditor()
            : base()
        {
            this.dao = new FloorplanDao();
            InitializeComponent();
            InitData();
        }


        public FloorplanEditor(FloorplanDao dao)
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
                this.entity = new Floorplan();
            }
            
            //project list
            string project_id = this.entity.project_id;
            if (string.IsNullOrWhiteSpace(project_id))
            {
                if (projectList.Count > 0)
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
            string building_id = this.entity.building_id;
            Building building = null;
            string stage_id = null;
            if (!string.IsNullOrWhiteSpace(building_id))
            {
                building = this.buildingDao.queryById(building_id);
                stage_id = building.stage_id;
            }
            if (string.IsNullOrWhiteSpace(stage_id))
            {
                if (stageList != null && stageList.Count > 0)
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
                if (buildingList != null && buildingList.Count > 0)
                {
                    building_id = (string)this.comboBox_Building.SelectedValue;
                }
            }
            else
            {
                this.comboBox_Building.SelectedItem = Utils.getSelectedBuilding(this.buildingList, building_id);
            }

            this.textBox_PictureId.Text = this.entity.picture_id;
            if (!string.IsNullOrWhiteSpace(this.entity.picture_id))
            {
                this.picture = this.MediaDao.queryById(this.entity.picture_id);
                if (this.picture != null)
                {
                    this.renderPicture();
                }
            }
            this.textBox_SalePictureId.Text = this.entity.sale_picture_id;
            if (!string.IsNullOrWhiteSpace(this.entity.sale_picture_id))
            {
                this.salePicture = this.MediaDao.queryById(this.entity.sale_picture_id);
                if (this.salePicture != null)
                {
                    this.renderSalePicture();
                }
            }

            this.comboBox_Type.SelectedItem = Utils.getSelected(this.typeList, this.entity.type);
            this.checkBox_IsSplit.Checked = this.entity.is_split;
            this.checkBox_IsStudio.Checked = this.entity.is_studio;
            this.numericUpDown_BathRoom.Value = this.entity.bathroom_count;
            this.numericUpDown_BedRoom.Value = this.entity.bedroom_count;
            this.numericUpDown_CourtYard.Value = this.entity.courtyard_count;
            this.numericUpDown_ExternalSize.Value = (decimal)this.entity.external_size;
            this.numericUpDown_InternalSize.Value = (decimal)this.entity.internal_size;
            this.numericUpDown_StudyRoom.Value = this.entity.studyroom_count;
            this.numericUpDown_TotalSize.Value = (decimal)this.entity.total_size;
            this.numericUpDown_LandSize.Value = (decimal)this.entity.land_size;
            this.numericUpDown_OpenBalcony.Value = this.entity.open_baclony_count;
            this.numericUpDown_EnclosedBalcony.Value = this.entity.enclosed_baclony_count;
            BeFun.Model.Domain.Orientation ori = Utils.getOrientation(this.entity.orientation);
            this.checkBox_Ori_East.Checked = ori.east;
            this.checkBox_Ori_South.Checked = ori.south;
            this.checkBox_Ori_West.Checked = ori.west;
            this.checkBox_Ori_North.Checked = ori.north;
            this.richTextBox_Description.Text = this.entity.description;
            if (!string.IsNullOrWhiteSpace(this.entity.id))
            {
                this.richTextBox_Apartments.ReadOnly = true;
            }
        }

        public override void saveEntity()
        {
            if (this.entity == null)
            {
                this.entity = new Floorplan();
            }
            this.entity.project_id = (string)this.comboBox_Project.SelectedValue;
            this.entity.building_id = (string)this.comboBox_Building.SelectedValue;
            if (!string.IsNullOrWhiteSpace(this.textBox_PictureId.Text))
            {
                this.entity.picture_id = this.textBox_PictureId.Text;
            }
            if (!string.IsNullOrWhiteSpace(this.textBox_SalePictureId.Text))
            {
                this.entity.sale_picture_id = this.textBox_SalePictureId.Text;
            }
            this.entity.type = (Byte)this.comboBox_Type.SelectedValue;
            this.entity.is_split = this.checkBox_IsSplit.Checked;
            this.entity.is_studio = this.checkBox_IsStudio.Checked;
            this.entity.bathroom_count = (Int16)this.numericUpDown_BathRoom.Value;
            this.entity.bedroom_count = (Int16)this.numericUpDown_BedRoom.Value;
            this.entity.courtyard_count = (Int16)this.numericUpDown_CourtYard.Value;
            this.entity.external_size = (Double)this.numericUpDown_ExternalSize.Value;
            this.entity.internal_size = (Double)this.numericUpDown_InternalSize.Value;
            this.entity.studyroom_count = (Int16)this.numericUpDown_StudyRoom.Value;
            this.entity.total_size = (Double)this.numericUpDown_TotalSize.Value;
            this.entity.land_size = (Double)this.numericUpDown_LandSize.Value;
            this.entity.open_baclony_count = (Int16)this.numericUpDown_OpenBalcony.Value;
            this.entity.enclosed_baclony_count = (Int16)this.numericUpDown_EnclosedBalcony.Value;
            this.entity.orientation = Utils.getOrientationValue(this.checkBox_Ori_East.Checked, this.checkBox_Ori_South.Checked, this.checkBox_Ori_West.Checked, this.checkBox_Ori_North.Checked);
            this.entity.description = this.richTextBox_Description.Text;
            string originalId = this.entity.id;
            this.dao.save(this.entity);

            if (string.IsNullOrWhiteSpace(originalId))
            {
                string apartmentsStr = this.richTextBox_Apartments.Text;
                string[] apartments = apartmentsStr.Split(new string[]{","}, StringSplitOptions.RemoveEmptyEntries);
                foreach (string apartment in apartments)
                {
                    Apartment tmpa = new Apartment();
                    string unit_number = apartment.Trim();
                    tmpa.unit_number = unit_number;
                    tmpa.floorplan_id = this.entity.id;
                    tmpa.building_id = this.entity.building_id;
                    this.apartmentDao.save(tmpa);
                }
            }
        }

        protected override void Close_Extend(object sender, CancelEventArgs e)
        {
            this.DisposePictures();
        }

        #region user defined init

        private void InitData()
        {
            projectList = this.projectDao.queryAll();
            this.bindingSource_Project.DataSource = projectList;

            typeList.Add(new ComboBoxItem((Byte)1, "Apartment"));
            typeList.Add(new ComboBoxItem((Byte)2, "Town House"));
            typeList.Add(new ComboBoxItem((Byte)3, "House"));
            this.bindingSource_Type.DataSource = typeList;
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

        private void textBox_PictureId_Double_Click(object sender, EventArgs e)
        {
            MediaQueryCondition qc = new MediaQueryCondition();
            qc.project_id = this.entity.project_id;
            qc.media_type = Media.MEDIA_TYPE_PIC;
            qc.content_type = Media.CONTENT_TYPE_FLOORPLAN;
            MediaWindow mediaWindow = new MediaWindow(ListWindowType.Choose, qc);
            if (mediaWindow.ShowDialog(this) == DialogResult.OK)
            {
                this.picture = mediaWindow.currentEntity;
                this.renderPicture();
            }
        }

        private void textBox_SalePictureId_Double_Click(object sender, EventArgs e)
        {
            MediaQueryCondition qc = new MediaQueryCondition();
            qc.project_id = this.entity.project_id;
            qc.media_type = Media.MEDIA_TYPE_PIC;
            qc.content_type = Media.CONTENT_TYPE_FLOORPLAN;
            MediaWindow mediaWindow = new MediaWindow(ListWindowType.Choose, qc);
            if (mediaWindow.ShowDialog(this) == DialogResult.OK)
            {
                this.salePicture = mediaWindow.currentEntity;
                this.renderSalePicture();
            }
        }

        private void renderPicture()
        {
            this.textBox_PictureId.Text = this.picture.id;
            PictureUtils.RenderPictureFromUrl(this.pictureBox_Picture, this.picture.default_url);
        }

        private void renderSalePicture()
        {
            this.textBox_SalePictureId.Text = this.salePicture.id;
            PictureUtils.RenderPictureFromUrl(this.pictureBox_SalePicture, this.salePicture.default_url);
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
        }
        #endregion

        private void DisposePictures()
        {
            PictureUtils.DisposePicture(this.pictureBox_Picture);
            PictureUtils.DisposePicture(this.pictureBox_SalePicture);
        }
    }
}
