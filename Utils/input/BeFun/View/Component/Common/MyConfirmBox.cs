using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using BeFun.Common;

namespace BeFun.View.Component.Common
{
    public partial class MyConfirmBox : Form
    {
        private string message;

        public MyConfirmBox()
            : base()
        {
            InitializeComponent();
        }

        public MyConfirmBox(string message)
            : base()
        {
            this.message = message;
            InitializeComponent();
            this.RefreshComponentWithData();
        }

        public static DialogResult ShowBox(IWin32Window owner, string message)
        {
            MyConfirmBox box = new MyConfirmBox(message);
            return box.ShowDialog(owner);
        }

        private void RefreshComponentWithData()
        {
            this.label_Message.Text = this.message;
        }

        private void button_Yes_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Yes;
            this.Dispose();
            this.Close();
        }

        private void button_No_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.No;
            this.Dispose();
            this.Close();
        }
    }
}
