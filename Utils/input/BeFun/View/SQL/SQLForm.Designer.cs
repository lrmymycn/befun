namespace BeFun.View.SQL
{
    partial class SQLForm
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
            this.richTextBox_SQL = new System.Windows.Forms.RichTextBox();
            this.tableLayoutPanel_Button = new System.Windows.Forms.TableLayoutPanel();
            this.button_Execute = new System.Windows.Forms.Button();
            this.button_Close = new System.Windows.Forms.Button();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.tableLayoutPanel_Button.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.richTextBox_SQL, 0, 0);
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel_Button, 0, 1);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 2;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(734, 412);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // richTextBox_SQL
            // 
            this.richTextBox_SQL.Dock = System.Windows.Forms.DockStyle.Fill;
            this.richTextBox_SQL.Location = new System.Drawing.Point(3, 3);
            this.richTextBox_SQL.Name = "richTextBox_SQL";
            this.richTextBox_SQL.Size = new System.Drawing.Size(728, 371);
            this.richTextBox_SQL.TabIndex = 0;
            this.richTextBox_SQL.Text = "";
            // 
            // tableLayoutPanel_Button
            // 
            this.tableLayoutPanel_Button.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.tableLayoutPanel_Button.AutoSize = true;
            this.tableLayoutPanel_Button.ColumnCount = 3;
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle());
            this.tableLayoutPanel_Button.Controls.Add(this.button_Execute, 2, 0);
            this.tableLayoutPanel_Button.Controls.Add(this.button_Close, 1, 0);
            this.tableLayoutPanel_Button.Location = new System.Drawing.Point(638, 380);
            this.tableLayoutPanel_Button.Name = "tableLayoutPanel_Button";
            this.tableLayoutPanel_Button.RowCount = 1;
            this.tableLayoutPanel_Button.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Button.Size = new System.Drawing.Size(93, 29);
            this.tableLayoutPanel_Button.TabIndex = 1;
            // 
            // button_Execute
            // 
            this.button_Execute.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.button_Execute.Location = new System.Drawing.Point(15, 3);
            this.button_Execute.Name = "button_Execute";
            this.button_Execute.Size = new System.Drawing.Size(75, 23);
            this.button_Execute.TabIndex = 2;
            this.button_Execute.Text = "&Execute";
            this.button_Execute.UseVisualStyleBackColor = true;
            this.button_Execute.Click += new System.EventHandler(this.button_Execute_Click);
            // 
            // button_Close
            // 
            this.button_Close.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_Close.Location = new System.Drawing.Point(9, 3);
            this.button_Close.Name = "button_Close";
            this.button_Close.Size = new System.Drawing.Size(0, 0);
            this.button_Close.TabIndex = 3;
            this.button_Close.Text = "Close";
            this.button_Close.UseVisualStyleBackColor = true;
            // 
            // SQLForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_Close;
            this.ClientSize = new System.Drawing.Size(734, 412);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MaximumSize = new System.Drawing.Size(750, 450);
            this.MinimizeBox = false;
            this.MinimumSize = new System.Drawing.Size(750, 450);
            this.Name = "SQLForm";
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "SQLForm";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.tableLayoutPanel_Button.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.RichTextBox richTextBox_SQL;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Button;
        private System.Windows.Forms.Button button_Execute;
        private System.Windows.Forms.Button button_Close;
    }
}