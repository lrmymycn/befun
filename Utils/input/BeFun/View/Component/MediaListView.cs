using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Model.Query;
using BeFun.View.ListWindow;

namespace BeFun.View.Component
{
    public partial class MediaListView : UserControl
    {
        private MediaDao dao = new MediaDao();

        public IList<Media> mediaList = new List<Media>();

        public MediaQueryCondition queryCondition;

        public MediaQueryCondition chooseQueryCondition;

        public MediaListView()
        {
            InitializeComponent();
        }

        public void InitData()
        {
            if (queryCondition != null)
            {
                this.mediaList = dao.query(queryCondition);
            }
            refreshListView(); 
        }

        private void refreshListView()
        {
            //Add the items to the ListView.
            this.listView.Items.Clear();
            this.imageList_Large.Images.Clear();
            Media media = null;
            for (int i = 0; i < mediaList.Count;i++ )
            {
                media = this.mediaList[i];
                this.listView.Items.Add(this.parseListViewItem(media,i));
                this.imageList_Large.Images.Add(this.parseImage(media));
            }
        }

        private ListViewItem parseListViewItem(Media media, int imageIndex)
        {
            ListViewItem item = new ListViewItem(media.default_url, imageIndex);
            return item;
        }

        private Image parseImage(Media media)
        {
            return PictureUtils.GenerateImageFromUrl(media.default_url);
        }

        private void addToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MediaWindow mediaWindow = new MediaWindow(ListWindowType.MultiChoose, this.chooseQueryCondition);
            if (mediaWindow.ShowDialog(this) == DialogResult.OK)
            {
                if (mediaWindow.currentEntities != null)
                {
                    foreach (Media m in mediaWindow.currentEntities)
                    {
                        if (!mediaList.Contains(m))
                        {
                            mediaList.Add(m);
                        }
                    }
                }
                if (mediaWindow.currentEntity != null)
                {
                    if (!mediaList.Contains(mediaWindow.currentEntity))
                    {
                        mediaList.Add(mediaWindow.currentEntity);
                    }
                }
            }
            refreshListView();
        }

        private void removeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.listView.SelectedItems.Count > 0)
            {
                int i = this.listView.SelectedItems[0].Index;
                this.mediaList.RemoveAt(i);
                refreshListView();
            }
        }

        public void DisposePictures()
        {
            if (this.imageList_Large.Images != null && this.imageList_Large.Images.Count > 0)
            {
                foreach (Image i in this.imageList_Large.Images)
                {
                    PictureUtils.DisposeImage(i);
                }
            }
        }
    }
}
