namespace BeFun.View.Component.Common
{
    partial class MyMessageBox
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tableLayoutPanel_Main = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel_Button = new System.Windows.Forms.TableLayoutPanel();
            this.button_OK = new System.Windows.Forms.Button();
            this.tableLayoutPanel_Message = new System.Windows.Forms.TableLayoutPanel();
            this.label_Prompt = new System.Windows.Forms.Label();
            this.panel_Message = new System.Windows.Forms.Panel();
            this.label_Message = new System.Windows.Forms.Label();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.tableLayoutPanel_Button.SuspendLayout();
            this.tableLayoutPanel_Message.SuspendLayout();
            this.panel_Message.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel_Button, 0, 1);
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel_Message, 0, 0);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 2;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(484, 262);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // tableLayoutPanel_Button
            // 
            this.tableLayoutPanel_Button.AutoSize = true;
            this.tableLayoutPanel_Button.ColumnCount = 1;
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Button.Controls.Add(this.button_OK, 0, 0);
            this.tableLayoutPanel_Button.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Button.Location = new System.Drawing.Point(3, 230);
            this.tableLayoutPanel_Button.Name = "tableLayoutPanel_Button";
            this.tableLayoutPanel_Button.RowCount = 1;
            this.tableLayoutPanel_Button.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Button.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 29F));
            this.tableLayoutPanel_Button.Size = new System.Drawing.Size(478, 29);
            this.tableLayoutPanel_Button.TabIndex = 0;
            // 
            // button_OK
            // 
            this.button_OK.Anchor = System.Windows.Forms.AnchorStyles.None;
            this.button_OK.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_OK.Location = new System.Drawing.Point(214, 3);
            this.button_OK.Name = "button_OK";
            this.button_OK.Size = new System.Drawing.Size(50, 23);
            this.button_OK.TabIndex = 0;
            this.button_OK.Text = "OK";
            this.button_OK.UseVisualStyleBackColor = true;
            // 
            // tableLayoutPanel_Message
            // 
            this.tableLayoutPanel_Message.AutoScroll = true;
            this.tableLayoutPanel_Message.ColumnCount = 1;
            this.tableLayoutPanel_Message.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Message.Controls.Add(this.label_Prompt, 0, 0);
            this.tableLayoutPanel_Message.Controls.Add(this.panel_Message, 0, 1);
            this.tableLayoutPanel_Message.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel_Message.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel_Message.Name = "tableLayoutPanel_Message";
            this.tableLayoutPanel_Message.RowCount = 2;
            this.tableLayoutPanel_Message.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Message.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Message.Size = new System.Drawing.Size(478, 221);
            this.tableLayoutPanel_Message.TabIndex = 1;
            // 
            // label_Prompt
            // 
            this.label_Prompt.AutoSize = true;
            this.label_Prompt.Font = new System.Drawing.Font("宋体", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.label_Prompt.ForeColor = System.Drawing.SystemColors.ControlText;
            this.label_Prompt.Location = new System.Drawing.Point(3, 3);
            this.label_Prompt.Margin = new System.Windows.Forms.Padding(3);
            this.label_Prompt.Name = "label_Prompt";
            this.label_Prompt.Size = new System.Drawing.Size(55, 14);
            this.label_Prompt.TabIndex = 0;
            this.label_Prompt.Text = "prompt";
            // 
            // panel_Message
            // 
            this.panel_Message.AutoScroll = true;
            this.panel_Message.Controls.Add(this.label_Message);
            this.panel_Message.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel_Message.Location = new System.Drawing.Point(3, 23);
            this.panel_Message.Name = "panel_Message";
            this.panel_Message.Size = new System.Drawing.Size(472, 195);
            this.panel_Message.TabIndex = 1;
            // 
            // label_Message
            // 
            this.label_Message.AutoSize = true;
            this.label_Message.Location = new System.Drawing.Point(3, 3);
            this.label_Message.Margin = new System.Windows.Forms.Padding(3);
            this.label_Message.Name = "label_Message";
            this.label_Message.Size = new System.Drawing.Size(47, 12);
            this.label_Message.TabIndex = 2;
            this.label_Message.Text = "message";
            // 
            // MyMessageBox
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_OK;
            this.ClientSize = new System.Drawing.Size(484, 262);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.MinimumSize = new System.Drawing.Size(500, 300);
            this.Name = "MyMessageBox";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Message";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.tableLayoutPanel_Button.ResumeLayout(false);
            this.tableLayoutPanel_Message.ResumeLayout(false);
            this.tableLayoutPanel_Message.PerformLayout();
            this.panel_Message.ResumeLayout(false);
            this.panel_Message.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Button;
        private System.Windows.Forms.Button button_OK;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Message;
        private System.Windows.Forms.Label label_Prompt;
        private System.Windows.Forms.Panel panel_Message;
        private System.Windows.Forms.Label label_Message;
    }
}