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
    public partial class MyMessageBox : Form
    {
        private string message;
        private Int16 type;

        public MyMessageBox() : base()
        {
            InitializeComponent();
        }

        public MyMessageBox(string message, Int16 type)
            : base()
        {
            this.message = message;
            this.type = type;
            InitializeComponent();
            this.RefreshComponentWithData();
        }

        public MyMessageBox(string message, Exception ex, Int16 type) : base()
        {
            this.message = message;
            if(ex != null){
                this.message += "\n" + ex.Message;
                this.message += "\n" + ex.StackTrace;
            }
            this.type = type;
            InitializeComponent();
            this.RefreshComponentWithData();
        }

        public static DialogResult ShowBox(IWin32Window owner, string message)
        {
            MyMessageBox box = new MyMessageBox(message, MyConstants.BOX_TYPE_NORMAL);
            return box.ShowDialog(owner);
        }

        public static DialogResult ShowBox(IWin32Window owner, string message, Exception ex, Int16 type)
        {
            MyMessageBox box = new MyMessageBox(message, ex, type);
            return box.ShowDialog(owner);
        }

        private void RefreshComponentWithData()
        {
            string windowTitle = MyConstants.TITLE_NORMAL;
            string prompt = MyConstants.PROMPT_NORMAL;
            switch(type){
                case MyConstants.BOX_TYPE_NORMAL:
                    windowTitle = MyConstants.TITLE_NORMAL;
                    prompt = MyConstants.PROMPT_NORMAL;
                    this.label_Prompt.ForeColor = System.Drawing.Color.Green;
                    break;
                case MyConstants.BOX_TYPE_ALERT:
                    windowTitle = MyConstants.TITLE_ALERT;
                    prompt = MyConstants.PROMPT_ALERT;
                    this.label_Prompt.ForeColor = System.Drawing.Color.Yellow;
                    break;
                case MyConstants.BOX_TYPE_ERROR:
                    windowTitle = MyConstants.TITLE_ERROR;
                    prompt = MyConstants.PROMPT_ERROR;
                    this.label_Prompt.ForeColor = System.Drawing.Color.Red;
                    break;
                default:
                    break;
            }
            this.Text = windowTitle;
            this.label_Prompt.Text = prompt;
            this.label_Message.Text = this.message;
        }
    }
}
