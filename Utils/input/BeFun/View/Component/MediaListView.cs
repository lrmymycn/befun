using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Dao;
using BeFun.Model.Domain;
using BeFun.Model.Query;
using BeFun.View.ListWindow;
using BeFun.View.Component.Common;

namespace BeFun.View.Component
{
    public partial class MediaListView : UserControl
    {
        private MediaDao dao = new MediaDao();

        public IList<Media> mediaList;

        public MediaQueryCondition chooseQueryCondition;

        public MediaListView()
        {
            InitializeComponent();
        }

        public void InitData()
        {
            /*if (queryCondition != null)
            {
                this.mediaList = dao.query(queryCondition);
            }*/
            refreshListView();
        }

        private void refreshListView()
        {
            //Add the items to the ListView.
            this.listView.Items.Clear();
            this.imageList_Large.Images.Clear();
            Media media = null;
            for (int i = 0; i < mediaList.Count; i++)
            {
                media = this.mediaList[i];
                this.listView.Items.Add(this.parseListViewItem(media, i));
                this.imageList_Large.Images.Add(this.parseImage(media));
            }
        }

        public IList<Media> getMediaList()
        {
            IList<Media> medias = new List<Media>();
            foreach (ListViewItem viewItem in this.listView.Items)
            {
                MyListViewItem i = (MyListViewItem)viewItem;
                medias.Add(i.media);
                //medias.Insert(i.ImageIndex, i.media);
            }
            this.mediaList = medias;
            return this.mediaList;
        }

        private ListViewItem parseListViewItem(Media media, int imageIndex)
        {
            MyListViewItem item = new MyListViewItem(media, imageIndex);
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
                foreach (ListViewItem viewItem in this.listView.SelectedItems)
                {
                    int i = viewItem.Index;
                    this.listView.Items.RemoveAt(i);
                    //this.mediaList.RemoveAt(i);
                }
                //refreshListView();
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

        #region drag
        private void listView_ItemDrag(object sender, ItemDragEventArgs e)
        {
            //MyMessageBox.ShowBox(this, e.ToString());
            this.listView.DoDragDrop(e.Item, DragDropEffects.Move);
        }

        private void listView_DragEnter(object sender, DragEventArgs e)
        {
            e.Effect = e.AllowedEffect;
        }

        //像拖拽项目一样移动插入标记  
        private void listView_DragOver(object sender, DragEventArgs e)
        {
            // 获得鼠标坐标  
            Point point = listView.PointToClient(new Point(e.X, e.Y));
            // 返回离鼠标最近的项目的索引  
            int index = listView.InsertionMark.NearestIndex(point);
            // 确定光标不在拖拽项目上  
            if (index > -1)
            {
                Rectangle itemBounds = listView.GetItemRect(index);
                if (point.X > itemBounds.Left + (itemBounds.Width / 2))
                {
                    listView.InsertionMark.AppearsAfterItem = true;
                }
                else
                {
                    listView.InsertionMark.AppearsAfterItem = false;
                }
            }
            listView.InsertionMark.Index = index;
        }

        // 当鼠标离开控件时移除插入标记  
        private void listView_DragLeave(object sender, EventArgs e)
        {
            listView.InsertionMark.Index = -1;
        }

        // 将项目移到插入标记所在的位置  
        private void listView_DragDrop(object sender, DragEventArgs e)
        {
            // 返回插入标记的索引值  
            int index = listView.InsertionMark.Index;
            // 如果插入标记不可见，则退出.  
            if (index == -1)
            {
                return;
            }
            // 如果插入标记在项目的右面，使目标索引值加一  
            if (listView.InsertionMark.AppearsAfterItem)
            {
                index++;
            }

            // 返回拖拽项  
            MyListViewItem item = (MyListViewItem)e.Data.GetData(typeof(MyListViewItem));
            //在目标索引位置插入一个拖拽项目的副本
            MyListViewItem ni = new MyListViewItem(item.media, item.ImageIndex);
            listView.Items.Insert(index, ni);
            // 移除拖拽项目的原文件  
            listView.Items.Remove(item);
        }

        // 对ListView里的各项根据索引进行排序  
        private class ListViewIndexComparer : System.Collections.IComparer
        {
            public int Compare(object x, object y)
            {
                return ((ListViewItem)x).Index - ((ListViewItem)y).Index;
            }
        }
        #endregion
        class MyListViewItem : ListViewItem
        {
            public Media media;

            public MyListViewItem(Media media)
                : base(media.default_url)
            {
                this.media = media;
            }

            public MyListViewItem(Media media, int imageIndex)
                : base(media.default_url, imageIndex)
            {
                this.media = media;
            }
        }
    }
}
