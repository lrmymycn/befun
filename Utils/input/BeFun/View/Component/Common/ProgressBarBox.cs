using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;

namespace BeFun.View.Component.Common
{
    public partial class ProgressBarBox : Form
    {
        public ProgressBarBox()
        {
        }

        public ProgressBarBox(string title, Int32 minimum, Int32 maximum, Int32 step)
        {
            InitializeComponent();
            this.Text = title;
            this.progressBar.Minimum = minimum;
            this.progressBar.Maximum = maximum;
            this.progressBar.Step = step;
        }

        public static DialogResult ShowBox(IWin32Window owner, string title, Int32 minimum, Int32 maximum, Int32 step)
        {
            ProgressBarBox box = new ProgressBarBox(title,minimum,maximum,step);
            return box.ShowDialog(owner);
        }

        public void PerformStep()
        {
            this.progressBar.PerformStep();
        }

        private void button_Cancel_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            this.Dispose();
            this.Close();
        }
    }
}
