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
    public partial class ProjectEditor : MyEditor
    {
        private ProjectDao dao;
        private StageDao stageDao = new StageDao();
        private BuildingDao buildingDao = new BuildingDao();
        private MediaDao MediaDao = new MediaDao();

        public Project entity { get; set; }

        private Media picture = null;

        private Media logo = null;

        public ProjectEditor()
            : base()
        {
            this.dao = new ProjectDao();
            this.InitializeComponent();
        }

        public ProjectEditor(ProjectDao dao)
        {
            this.dao = dao;
            this.InitializeComponent();
        }

        public override void renderEntity()
        {
            if (this.entity == null)
            {
                return;
            }
            this.textBox_Block.Text = this.entity.block;
            this.textBox_Name.Text = this.entity.name;
            this.textBox_SiteURL.Text = this.entity.site_url;
            this.textBox_Developer.Text = this.entity.developer;
            this.dateTimePicker_FinishDate.Value = this.entity.finish_date;
            this.numericUpDown_DistanceToCity.Value = (decimal)this.entity.distancetocity;
            this.textBox_Address.Text = this.entity.address;
            this.textBox_PostCode.Text = this.entity.postcode;
            this.checkBox_BBQ.Checked = this.entity.bbq;
            this.checkBox_GYM.Checked = this.entity.gym;
            this.checkBox_LandScaping.Checked = this.entity.land_scaping;
            this.checkBox_Library.Checked = this.entity.library;
            this.checkBox_FuncRoom.Checked = this.entity.func_room;
            this.checkBox_MusicRoom.Checked = this.entity.music_room;
            this.checkBox_Others.Checked = this.entity.others;
            this.checkBox_PlayGround.Checked = this.entity.kids_play_ground;
            this.checkBox_PlayRoom.Checked = this.entity.play_room;
            this.checkBox_Receiption.Checked = this.entity.receiption;
            this.checkBox_RecreationPlace.Checked = this.entity.recreation_place;
            this.checkBox_Sauna.Checked = this.entity.sauna;
            this.checkBox_SkyGarden.Checked = this.entity.sky_garden;
            this.checkBox_SwimmingPool.Checked = this.entity.swimming_pool;
            this.checkBox_TennisCourt.Checked = this.entity.tennis_court;
            this.checkBox_TheatreCinema.Checked = this.entity.theatre_cinema;
            this.checkBox_VisitorParking.Checked = this.entity.visitor_parking;
            this.checkBox_CarWashBay.Checked = this.entity.car_wash_bay;
            this.richTextBox_Description.Text = this.entity.description;
            this.richTextBox_Features.Text = this.entity.features;
            this.richTextBox_FinishScheme.Text = this.entity.finish_schema;
            this.textBox_PictureId.Text = this.entity.picture_id.ToString();
            this.numericUpDown_Longitude.Value = (decimal)this.entity.longitude;
            this.numericUpDown_Latitude.Value = (decimal)this.entity.latitude;
            if (!string.IsNullOrWhiteSpace(this.entity.picture_id))
            {
                this.picture = this.MediaDao.queryById(this.entity.picture_id);
                if (this.picture != null)
                {
                    this.renderPicture();
                }
            }
            this.textBox_LogoId.Text = this.entity.logo_id.ToString();
            if (!string.IsNullOrWhiteSpace(this.entity.logo_id))
            {
                this.logo = this.MediaDao.queryById(this.entity.logo_id);
                if (this.logo != null)
                {
                    this.renderLogo();
                }
            }
            MediaQueryCondition queryCondition = new MediaQueryCondition();
            queryCondition.overview_project_id = this.entity.id;
            queryCondition.media_type = Media.MEDIA_TYPE_PIC;
            this.mediaListView.queryCondition = queryCondition;

            MediaQueryCondition chooseQueryCondition = new MediaQueryCondition();
            chooseQueryCondition.project_id = this.entity.id;
            chooseQueryCondition.media_type = Media.MEDIA_TYPE_PIC;
            this.mediaListView.chooseQueryCondition = chooseQueryCondition;
            this.mediaListView.InitData();
        }

        public override void saveEntity()
        {
            if (this.entity == null)
            {
                this.entity = new Project();
            }
            this.entity.block = this.textBox_Block.Text;
            this.entity.name = this.textBox_Name.Text;
            this.entity.site_url = this.textBox_SiteURL.Text;
            this.entity.developer = this.textBox_Developer.Text;
            this.entity.finish_date = this.dateTimePicker_FinishDate.Value;
            this.entity.distancetocity = (Double)this.numericUpDown_DistanceToCity.Value;
            this.entity.address = this.textBox_Address.Text;
            this.entity.postcode = this.textBox_PostCode.Text;
            this.entity.bbq = this.checkBox_BBQ.Checked;
            this.entity.gym = this.checkBox_GYM.Checked;
            this.entity.land_scaping = this.checkBox_LandScaping.Checked;
            this.entity.library = this.checkBox_Library.Checked;
            this.entity.func_room = this.checkBox_FuncRoom.Checked;
            this.entity.music_room = this.checkBox_MusicRoom.Checked;
            this.entity.others = this.checkBox_Others.Checked;
            this.entity.kids_play_ground = this.checkBox_PlayGround.Checked;
            this.entity.play_room = this.checkBox_PlayRoom.Checked;
            this.entity.receiption = this.checkBox_Receiption.Checked;
            this.entity.recreation_place = this.checkBox_RecreationPlace.Checked;
            this.entity.sauna = this.checkBox_Sauna.Checked;
            this.entity.sky_garden = this.checkBox_SkyGarden.Checked;
            this.entity.swimming_pool = this.checkBox_SwimmingPool.Checked;
            this.entity.tennis_court = this.checkBox_TennisCourt.Checked;
            this.entity.theatre_cinema = this.checkBox_TheatreCinema.Checked;
            this.entity.visitor_parking = this.checkBox_VisitorParking.Checked;
            this.entity.car_wash_bay = this.checkBox_CarWashBay.Checked;
            this.entity.description = this.richTextBox_Description.Text;
            this.entity.features = this.richTextBox_Features.Text;
            this.entity.finish_schema = this.richTextBox_FinishScheme.Text;
            this.entity.longitude = (Double)this.numericUpDown_Longitude.Value;
            this.entity.latitude = (Double)this.numericUpDown_Latitude.Value;
            if(!string.IsNullOrWhiteSpace(this.textBox_PictureId.Text)){
                this.entity.picture_id = this.textBox_PictureId.Text;
            }
            if(!string.IsNullOrWhiteSpace(this.textBox_LogoId.Text)){
                this.entity.logo_id = this.textBox_LogoId.Text;
            }
            string originalId = this.entity.id;
            this.dao.save(this.entity);
            this.dao.removeAllOverviewMedias(this.entity.id);
            IList<String> mediaIds = new List<String>();
            if (this.mediaListView.mediaList.Count > 0)
            {
                foreach (Media m in this.mediaListView.mediaList)
                {
                    mediaIds.Add(m.id);
                }
            }
            this.dao.addMedias(this.entity.id, mediaIds);

            if (string.IsNullOrWhiteSpace(originalId))
            {
                //default stage
                Stage defaultStage = new Stage();
                defaultStage.name = "default";
                defaultStage.project_id = entity.id;
                this.stageDao.add(defaultStage);

                //default building
                Building defaultBuilding = new Building();
                defaultBuilding.building_num = "1";
                defaultBuilding.stage_id = defaultStage.id;
                this.buildingDao.add(defaultBuilding);
            }
        }

        protected override void Close_Extend(object sender, CancelEventArgs e)
        {
            this.DisposePictures();
        }

        #region event
        public void button_Save_Click_1(object sender, EventArgs e)
        {
            this.saveButton_click(sender, e);
        }

        public void button_Reset_Click_1(object sender, EventArgs e)
        {
            this.resetButton_click(sender, e);
        }

        public void button_Cancel_Click_1(object sender, EventArgs e)
        {
            this.cancelButton_click(sender, e);
        }

        private void textBox_PictureId_Double_Click(object sender, EventArgs e)
        {
            MediaQueryCondition qc = new MediaQueryCondition();
            qc.project_id = this.entity.id;
            qc.media_type = Media.MEDIA_TYPE_PIC;
            MediaWindow mediaWindow = new MediaWindow(ListWindowType.Choose, qc);
            if (mediaWindow.ShowDialog(this) == DialogResult.OK)
            {
                this.picture = mediaWindow.currentEntity;
                this.renderPicture();
            }
        }

        private void textBox_LogoId_Double_Click(object sender, EventArgs e)
        {
            MediaQueryCondition qc = new MediaQueryCondition();
            qc.project_id = this.entity.id;
            qc.media_type = Media.MEDIA_TYPE_PIC;
            MediaWindow mediaWindow = new MediaWindow(ListWindowType.Choose, qc);
            if (mediaWindow.ShowDialog(this) == DialogResult.OK)
            {
                this.logo = mediaWindow.currentEntity;
                this.renderLogo();
            }
        }
        #endregion

        private void renderPicture()
        {
            this.textBox_PictureId.Text = this.picture.id.ToString();
            PictureUtils.RenderPictureFromUrl(this.pictureBox_Picture, this.picture.default_url);
        }

        private void renderLogo()
        {
            this.textBox_LogoId.Text = this.logo.id.ToString();
            PictureUtils.RenderPictureFromUrl(this.pictureBox_Logo, this.logo.default_url);
        }

        private void DisposePictures()
        {
            PictureUtils.DisposePicture(this.pictureBox_Picture);
            PictureUtils.DisposePicture(this.pictureBox_Logo);
            this.mediaListView.DisposePictures();
        }
    }
}
