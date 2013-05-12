using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;

namespace BeFun.Model.Domain
{
    public class Project : BaseModel
    {
        public Project()
            : base()
        {
            this.id = null;
            this.picture_id = "";
            this.logo_id = "";
            this.swimming_pool = false;
            this.gym = false;
            this.sauna = false;
            this.tennis_court = false;
            this.play_room = false;
            this.func_room = false;
            this.theatre_cinema = false;
            this.music_room = false;
            this.library = false;
            this.bbq = false;
            this.receiption = false;
            this.visitor_parking = false;
            this.kids_play_ground = false;
            this.sky_garden = false;
            this.land_scaping = false;
            this.recreation_place = false;
            this.car_wash_bay = false;
            this.others = false;
            this.finish_date = DateTime.Now;
            this.distancetocity = -1;
            this.longitude = 180;
            this.latitude = 0;
            this.removed = false;
            this.creation_date = DateTime.Now;
            this.last_modified_date = DateTime.Now;
            this.enabled = true;
        }

        public override string getId()
        {
            return this.id;
        }

        public override void setId(string id)
        {
            this.id = id;
        }

        public string id { get; set; }

        public string block { get; set; }

        public string name { get; set; }

        public string picture_id { get; set; }

        public string logo_id { get; set; }

        public string site_url { get; set; }

        public string description { get; set; }

        public string features { get; set; }

        public string finish_schema { get; set; }

        public string developer { get; set; }

        public string address { get; set; }

        public string postcode { get; set; }

        public Boolean swimming_pool { get; set; }

        public Boolean gym { get; set; }

        public Boolean sauna { get; set; }

        public Boolean tennis_court { get; set; }

        public Boolean play_room { get; set; }

        public Boolean func_room { get; set; }

        public Boolean theatre_cinema { get; set; }

        public Boolean music_room { get; set; }

        public Boolean library { get; set; }

        public Boolean bbq { get; set; }

        public Boolean receiption { get; set; }

        public Boolean visitor_parking { get; set; }

        public Boolean kids_play_ground { get; set; }

        public Boolean sky_garden { get; set; }

        public Boolean land_scaping { get; set; }

        public Boolean recreation_place { get; set; }

        public Boolean car_wash_bay { get; set; }

        public Boolean others { get; set; }

        public DateTime start_date { get; set; }

        public DateTime finish_date { get; set; }

        public Double distancetocity { get; set; }

        public Double longitude { get; set; }

        public Double latitude { get; set; }

    }
}
