using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel;
using BeFun.Common;

namespace BeFun.Model.Domain
{
    public class Media : BaseModel
    {
        public const Byte MEDIA_TYPE_PIC = 0;
        public const Byte MEDIA_TYPE_VIDEO = 1;
        public const Byte MEDIA_TYPE_PDF = 2;

        public const Byte CONTENT_TYPE_FLOORPLAN = 0;
        public const Byte CONTENT_TYPE_RENDER_INTERNAL = 1;
        public const Byte CONTENT_TYPE_RENDER_EXTERNAL = 2;
        public const Byte CONTENT_TYPE_PHOTOGRAPH = 3;
        public const Byte CONTENT_TYPE_ENV = 4;
        public const Byte CONTENT_TYPE_FLOORPLATE = 5;
        public const Byte CONTENT_TYPE_OTHERS = 6;

        public Media()
            : base()
        {
            this.id = null;
            this.project_id = "";
            this.name = "";
            this.small_url = "";
            this.medium_url = "";
            this.large_url = "";
            this.alt = "";
            this.media_type = 0;
            this.content_type = 0;
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
        public string project_id { get; set; }
        public string name { get; set; }
        public string small_url { get; set; }
        public string medium_url { get; set; }
        public string large_url { get; set; }
        public string alt { get; set; }
        public Byte media_type { get; set; }
        public Byte content_type { get; set; }

        public override bool Equals(Object eqTo)
        {
            if (this == eqTo)
            {
                return true;
            }
            if (eqTo == null)
            {
                return false;
            }

            if (this.GetType() != eqTo.GetType())
            {
                return false;
            }
            Media other = (Media)eqTo;
            if (!Utils.Equals(this.id, other.id))
            {
                return false;
            }
            if (!Utils.Equals(this.name, other.name))
            {
                return false;
            }
            if (!Utils.Equals(this.small_url, other.small_url))
            {
                return false;
            }
            if (!Utils.Equals(this.medium_url, other.medium_url))
            {
                return false;
            }
            if (!Utils.Equals(this.large_url, other.large_url))
            {
                return false;
            }
            if (!Utils.Equals(this.alt, other.alt))
            {
                return false;
            }
            if (!Utils.Equals(this.media_type, other.media_type))
            {
                return false;
            }
            if (!Utils.Equals(this.content_type, other.content_type))
            {
                return false;
            }
            return true;
        }

        #region display properties
        public string media_type_name
        {
            get
            {
                string rs = "Undefined";
                switch (this.media_type)
                {
                    case Media.MEDIA_TYPE_PIC:
                        rs = "Picture";
                        break;
                    case Media.MEDIA_TYPE_VIDEO:
                        rs = "Video";
                        break;
                    case Media.MEDIA_TYPE_PDF:
                        rs = "PDF";
                        break;
                    default:
                        break;
                }
                return rs;
            }
        }
        public string content_type_name
        {
            get
            {
                string rs = "Undefined";
                switch (this.content_type)
                {
                    case Media.CONTENT_TYPE_ENV:
                        rs = "Environment";
                        break;
                    case Media.CONTENT_TYPE_FLOORPLAN:
                        rs = "Floorplan";
                        break;
                    case Media.CONTENT_TYPE_FLOORPLATE:
                        rs = "Floorplate";
                        break;
                    case Media.CONTENT_TYPE_OTHERS:
                        rs = "Others";
                        break;
                    case Media.CONTENT_TYPE_PHOTOGRAPH:
                        rs = "Photograph";
                        break;
                    case Media.CONTENT_TYPE_RENDER_EXTERNAL:
                        rs = "Render(External)";
                        break;
                    case Media.CONTENT_TYPE_RENDER_INTERNAL:
                        rs = "Render(Internal)";
                        break;
                    default:
                        break;
                }
                return rs;
            }
        }
        public string project_name { get; set; }
        public string default_url
        {
            get
            {
                if (!string.IsNullOrWhiteSpace(this.small_url))
                {
                    return this.small_url;
                }
                if (!string.IsNullOrWhiteSpace(this.medium_url))
                {
                    return this.medium_url;
                }
                return this.large_url;
            }
        }
        #endregion
    }
}
