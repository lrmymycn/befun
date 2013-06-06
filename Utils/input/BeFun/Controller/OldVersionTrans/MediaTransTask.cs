using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;
using BeFun.View.Component.Common;
using BeFun.Model.Domain;

namespace BeFun.Controller.OldVersionTrans
{
    class MediaTransTask
    {
        IList<Media> medias;
        public bool stopflag = false;
        public ProgressBarBox pb;
        public Thread t;
        
        IWin32Window owner;
        private MediaTrans mediaTrans = new MediaTrans();

        public MediaTransTask(IList<Media> medias, IWin32Window owner)
        {
            this.medias = medias;
            this.t = new Thread(new ThreadStart(Worker));
            this.t.IsBackground = true;
            this.owner = owner;
            this.pb = new ProgressBarBox("Translate Old Medias", 1, medias.Count, 1);
        }
        
        public void Worker()
        {
            for (int i = 0; i < medias.Count && !stopflag; i++)
            {
                System.Threading.Thread.Sleep(50 * 1);
                mediaTrans.translate(medias[i]);
                pb.ThreadSafePerformStep();
            }
            pb.ThreadSafeClose();
        }
    }
}
