namespace BeFun.View.Editor
{
    partial class StageEditor
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
            this.components = new System.ComponentModel.Container();
            this.tableLayoutPanel_Main = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel_Buttons = new System.Windows.Forms.TableLayoutPanel();
            this.button_Save = new System.Windows.Forms.Button();
            this.button_Cancel = new System.Windows.Forms.Button();
            this.button_Reset = new System.Windows.Forms.Button();
            this.tableLayoutPanel_Property = new System.Windows.Forms.TableLayoutPanel();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.comboBox_Project = new System.Windows.Forms.ComboBox();
            this.bindingSource_Project = new System.Windows.Forms.BindingSource(this.components);
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.textBox_Name = new System.Windows.Forms.TextBox();
            this.dateTimePicker_FinishDate = new System.Windows.Forms.DateTimePicker();
            this.richTextBox_Description = new System.Windows.Forms.RichTextBox();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.tableLayoutPanel_Buttons.SuspendLayout();
            this.tableLayoutPanel_Property.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.AutoSize = true;
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel_Buttons, 0, 1);
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel_Property, 0, 0);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 2;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(684, 218);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // tableLayoutPanel_Buttons
            // 
            this.tableLayoutPanel_Buttons.AutoSize = true;
            this.tableLayoutPanel_Buttons.ColumnCount = 4;
            this.tableLayoutPanel_Buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Buttons.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Buttons.Controls.Add(this.button_Save, 1, 0);
            this.tableLayoutPanel_Buttons.Controls.Add(this.button_Cancel, 2, 0);
            this.tableLayoutPanel_Buttons.Controls.Add(this.button_Reset, 3, 0);
            this.tableLayoutPanel_Buttons.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.tableLayoutPanel_Buttons.Location = new System.Drawing.Point(3, 186);
            this.tableLayoutPanel_Buttons.Name = "tableLayoutPanel_Buttons";
            this.tableLayoutPanel_Buttons.RowCount = 1;
            this.tableLayoutPanel_Buttons.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Buttons.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 29F));
            this.tableLayoutPanel_Buttons.Size = new System.Drawing.Size(678, 29);
            this.tableLayoutPanel_Buttons.TabIndex = 1;
            // 
            // button_Save
            // 
            this.button_Save.Location = new System.Drawing.Point(441, 3);
            this.button_Save.Name = "button_Save";
            this.button_Save.Size = new System.Drawing.Size(74, 23);
            this.button_Save.TabIndex = 0;
            this.button_Save.Text = "&Save";
            this.button_Save.UseVisualStyleBackColor = true;
            this.button_Save.Click += new System.EventHandler(this.button_Save_Click);
            // 
            // button_Cancel
            // 
            this.button_Cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_Cancel.Location = new System.Drawing.Point(521, 3);
            this.button_Cancel.Name = "button_Cancel";
            this.button_Cancel.Size = new System.Drawing.Size(74, 23);
            this.button_Cancel.TabIndex = 1;
            this.button_Cancel.Text = "&Cancel";
            this.button_Cancel.UseVisualStyleBackColor = true;
            this.button_Cancel.Click += new System.EventHandler(this.button_Cancel_Click);
            // 
            // button_Reset
            // 
            this.button_Reset.Location = new System.Drawing.Point(601, 3);
            this.button_Reset.Name = "button_Reset";
            this.button_Reset.Size = new System.Drawing.Size(74, 23);
            this.button_Reset.TabIndex = 2;
            this.button_Reset.Text = "&Reset";
            this.button_Reset.UseVisualStyleBackColor = true;
            this.button_Reset.Click += new System.EventHandler(this.button_Reset_Click);
            // 
            // tableLayoutPanel_Property
            // 
            this.tableLayoutPanel_Property.AutoSize = true;
            this.tableLayoutPanel_Property.ColumnCount = 2;
            this.tableLayoutPanel_Property.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel_Property.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Property.Controls.Add(this.label2, 0, 1);
            this.tableLayoutPanel_Property.Controls.Add(this.label1, 0, 0);
            this.tableLayoutPanel_Property.Controls.Add(this.comboBox_Project, 1, 0);
            this.tableLayoutPanel_Property.Controls.Add(this.label3, 0, 2);
            this.tableLayoutPanel_Property.Controls.Add(this.label4, 0, 3);
            this.tableLayoutPanel_Property.Controls.Add(this.textBox_Name, 1, 1);
            this.tableLayoutPanel_Property.Controls.Add(this.dateTimePicker_FinishDate, 1, 2);
            this.tableLayoutPanel_Property.Controls.Add(this.richTextBox_Description, 1, 3);
            this.tableLayoutPanel_Property.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Property.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel_Property.Name = "tableLayoutPanel_Property";
            this.tableLayoutPanel_Property.RowCount = 4;
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Property.Size = new System.Drawing.Size(678, 177);
            this.tableLayoutPanel_Property.TabIndex = 0;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 31);
            this.label2.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(35, 12);
            this.label2.TabIndex = 2;
            this.label2.Text = "Name:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 6);
            this.label1.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "Project:";
            // 
            // comboBox_Project
            // 
            this.comboBox_Project.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.SuggestAppend;
            this.comboBox_Project.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.comboBox_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Project.DisplayMember = "name";
            this.comboBox_Project.FormattingEnabled = true;
            this.comboBox_Project.Location = new System.Drawing.Point(118, 3);
            this.comboBox_Project.Name = "comboBox_Project";
            this.comboBox_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Project.TabIndex = 0;
            this.comboBox_Project.ValueMember = "id";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 56);
            this.label3.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(77, 12);
            this.label3.TabIndex = 3;
            this.label3.Text = "Finish Date:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(3, 81);
            this.label4.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(77, 12);
            this.label4.TabIndex = 4;
            this.label4.Text = "Description:";
            // 
            // textBox_Name
            // 
            this.textBox_Name.Location = new System.Drawing.Point(118, 28);
            this.textBox_Name.Name = "textBox_Name";
            this.textBox_Name.Size = new System.Drawing.Size(300, 21);
            this.textBox_Name.TabIndex = 1;
            // 
            // dateTimePicker_FinishDate
            // 
            this.dateTimePicker_FinishDate.Location = new System.Drawing.Point(118, 53);
            this.dateTimePicker_FinishDate.Name = "dateTimePicker_FinishDate";
            this.dateTimePicker_FinishDate.Size = new System.Drawing.Size(200, 21);
            this.dateTimePicker_FinishDate.TabIndex = 2;
            // 
            // richTextBox_Description
            // 
            this.richTextBox_Description.Dock = System.Windows.Forms.DockStyle.Fill;
            this.richTextBox_Description.Location = new System.Drawing.Point(118, 78);
            this.richTextBox_Description.Name = "richTextBox_Description";
            this.richTextBox_Description.Size = new System.Drawing.Size(557, 96);
            this.richTextBox_Description.TabIndex = 3;
            this.richTextBox_Description.Text = "";
            // 
            // StageEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.CancelButton = this.button_Cancel;
            this.ClientSize = new System.Drawing.Size(684, 218);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimumSize = new System.Drawing.Size(700, 256);
            this.Name = "StageEditor";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "StageEditor";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.tableLayoutPanel_Buttons.ResumeLayout(false);
            this.tableLayoutPanel_Property.ResumeLayout(false);
            this.tableLayoutPanel_Property.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Property;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox comboBox_Project;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBox_Name;
        private System.Windows.Forms.DateTimePicker dateTimePicker_FinishDate;
        private System.Windows.Forms.RichTextBox richTextBox_Description;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Buttons;
        private System.Windows.Forms.Button button_Save;
        private System.Windows.Forms.Button button_Cancel;
        private System.Windows.Forms.Button button_Reset;
        private System.Windows.Forms.BindingSource bindingSource_Project;
    }
}