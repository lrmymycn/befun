using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;

namespace WindowsFormsApplication1
{
    public partial class ProgressBarBox : Form
    {
        private IWin32Window owner;
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

        public ProgressBarBox(string title, Int32 minimum, Int32 maximum, Int32 step, IWin32Window owner)
        {
            this.owner = owner;
            InitializeComponent();
            this.Text = title;
            this.progressBar.Minimum = minimum;
            this.progressBar.Maximum = maximum;
            this.progressBar.Step = step;
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
