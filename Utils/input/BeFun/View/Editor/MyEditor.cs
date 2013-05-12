using System.Collections.Generic;
using System.Windows.Forms;
using BeFun.Common;
using BeFun.Model.Domain;
using System;
using System.ComponentModel;

namespace BeFun.View.Editor
{
    public class MyEditor : Form
    {
        public MyEditor()
            : base()
        {
            this.ShowInTaskbar = false;
            this.InitializeComponent();
        }

        public virtual void renderEntity()
        {
        }

        public virtual void saveEntity()
        {
        }

        public void reset()
        {
            this.renderEntity();
        }

        public virtual void saveButton_click(object sender, EventArgs e)
        {
            this.saveEntity();
            this.DialogResult = DialogResult.OK;
            this.Close();
        }

        public virtual void resetButton_click(object sender, EventArgs e)
        {
            this.reset();
        }

        public virtual void cancelButton_click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            this.Close();
        }

        private void InitializeComponent()
        {
            this.SuspendLayout();
            // 
            // MyEditor
            // 
            this.ClientSize = new System.Drawing.Size(284, 262);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "MyEditor";
            this.ShowInTaskbar = false;
            this.ResumeLayout(false);

            this.Closing += new CancelEventHandler(this.Form_Closing);
        }

        private void Form_Closing(object sender, CancelEventArgs e)
        {
            this.Close_Extend(sender, e);
        }

        protected virtual void Close_Extend(object sender, CancelEventArgs e)
        {
        }
    }
}
