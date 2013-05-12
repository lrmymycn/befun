namespace BeFun.View.Editor
{
    partial class BuildingEditor
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Relation = new System.Windows.Forms.TableLayoutPanel();
            this.comboBox_Stage = new System.Windows.Forms.ComboBox();
            this.bindingSource_Stage = new System.Windows.Forms.BindingSource(this.components);
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.comboBox_Project = new System.Windows.Forms.ComboBox();
            this.bindingSource_Project = new System.Windows.Forms.BindingSource(this.components);
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Property = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel_Orientation = new System.Windows.Forms.TableLayoutPanel();
            this.checkBox_Ori_West = new System.Windows.Forms.CheckBox();
            this.checkBox_Ori_North = new System.Windows.Forms.CheckBox();
            this.checkBox_Ori_East = new System.Windows.Forms.CheckBox();
            this.checkBox_Ori_South = new System.Windows.Forms.CheckBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.textBox_BuildingNum = new System.Windows.Forms.TextBox();
            this.dateTimePicker_FinishDate = new System.Windows.Forms.DateTimePicker();
            this.numericUpDown_FloorCount = new System.Windows.Forms.NumericUpDown();
            this.checkBox_ReadyHouse = new System.Windows.Forms.CheckBox();
            this.richTextBox_Description = new System.Windows.Forms.RichTextBox();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.tableLayoutPanel_Buttons.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.tableLayoutPanel_Relation.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            this.groupBox2.SuspendLayout();
            this.tableLayoutPanel_Property.SuspendLayout();
            this.tableLayoutPanel_Orientation.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_FloorCount)).BeginInit();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.AutoSize = true;
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel_Buttons, 0, 2);
            this.tableLayoutPanel_Main.Controls.Add(this.groupBox1, 0, 0);
            this.tableLayoutPanel_Main.Controls.Add(this.groupBox2, 0, 1);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 3;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(684, 362);
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
            this.tableLayoutPanel_Buttons.Location = new System.Drawing.Point(3, 330);
            this.tableLayoutPanel_Buttons.Name = "tableLayoutPanel_Buttons";
            this.tableLayoutPanel_Buttons.RowCount = 1;
            this.tableLayoutPanel_Buttons.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Buttons.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 29F));
            this.tableLayoutPanel_Buttons.Size = new System.Drawing.Size(678, 29);
            this.tableLayoutPanel_Buttons.TabIndex = 2;
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
            // groupBox1
            // 
            this.groupBox1.AutoSize = true;
            this.groupBox1.Controls.Add(this.tableLayoutPanel_Relation);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox1.Location = new System.Drawing.Point(3, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(678, 66);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Relation";
            // 
            // tableLayoutPanel_Relation
            // 
            this.tableLayoutPanel_Relation.AutoSize = true;
            this.tableLayoutPanel_Relation.ColumnCount = 2;
            this.tableLayoutPanel_Relation.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel_Relation.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Relation.Controls.Add(this.comboBox_Stage, 1, 1);
            this.tableLayoutPanel_Relation.Controls.Add(this.label2, 0, 1);
            this.tableLayoutPanel_Relation.Controls.Add(this.label1, 0, 0);
            this.tableLayoutPanel_Relation.Controls.Add(this.comboBox_Project, 1, 0);
            this.tableLayoutPanel_Relation.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Relation.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Relation.Name = "tableLayoutPanel_Relation";
            this.tableLayoutPanel_Relation.RowCount = 2;
            this.tableLayoutPanel_Relation.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel_Relation.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel_Relation.Size = new System.Drawing.Size(672, 46);
            this.tableLayoutPanel_Relation.TabIndex = 0;
            // 
            // comboBox_Stage
            // 
            this.comboBox_Stage.DataSource = this.bindingSource_Stage;
            this.comboBox_Stage.DisplayMember = "name";
            this.comboBox_Stage.FormattingEnabled = true;
            this.comboBox_Stage.Location = new System.Drawing.Point(118, 26);
            this.comboBox_Stage.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Stage.Name = "comboBox_Stage";
            this.comboBox_Stage.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Stage.TabIndex = 1;
            this.comboBox_Stage.ValueMember = "id";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 29);
            this.label2.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 2;
            this.label2.Text = "Stage:";
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
            this.comboBox_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Project.DisplayMember = "name";
            this.comboBox_Project.FormattingEnabled = true;
            this.comboBox_Project.Location = new System.Drawing.Point(118, 3);
            this.comboBox_Project.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Project.Name = "comboBox_Project";
            this.comboBox_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Project.TabIndex = 0;
            this.comboBox_Project.ValueMember = "id";
            this.comboBox_Project.SelectedIndexChanged += new System.EventHandler(this.comboBox_Project_SelectedIndexChanged);
            // 
            // groupBox2
            // 
            this.groupBox2.AutoSize = true;
            this.groupBox2.Controls.Add(this.tableLayoutPanel_Property);
            this.groupBox2.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox2.Location = new System.Drawing.Point(3, 75);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(678, 249);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Property";
            // 
            // tableLayoutPanel_Property
            // 
            this.tableLayoutPanel_Property.AutoSize = true;
            this.tableLayoutPanel_Property.ColumnCount = 2;
            this.tableLayoutPanel_Property.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel_Property.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Property.Controls.Add(this.tableLayoutPanel_Orientation, 1, 3);
            this.tableLayoutPanel_Property.Controls.Add(this.label3, 0, 0);
            this.tableLayoutPanel_Property.Controls.Add(this.label4, 0, 1);
            this.tableLayoutPanel_Property.Controls.Add(this.label5, 0, 2);
            this.tableLayoutPanel_Property.Controls.Add(this.label6, 0, 3);
            this.tableLayoutPanel_Property.Controls.Add(this.label7, 0, 4);
            this.tableLayoutPanel_Property.Controls.Add(this.label8, 0, 5);
            this.tableLayoutPanel_Property.Controls.Add(this.textBox_BuildingNum, 1, 0);
            this.tableLayoutPanel_Property.Controls.Add(this.dateTimePicker_FinishDate, 1, 1);
            this.tableLayoutPanel_Property.Controls.Add(this.numericUpDown_FloorCount, 1, 2);
            this.tableLayoutPanel_Property.Controls.Add(this.checkBox_ReadyHouse, 1, 4);
            this.tableLayoutPanel_Property.Controls.Add(this.richTextBox_Description, 1, 5);
            this.tableLayoutPanel_Property.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Property.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Property.Name = "tableLayoutPanel_Property";
            this.tableLayoutPanel_Property.RowCount = 6;
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 27F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Property.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Property.Size = new System.Drawing.Size(672, 229);
            this.tableLayoutPanel_Property.TabIndex = 0;
            // 
            // tableLayoutPanel_Orientation
            // 
            this.tableLayoutPanel_Orientation.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.tableLayoutPanel_Orientation.AutoSize = true;
            this.tableLayoutPanel_Orientation.ColumnCount = 4;
            this.tableLayoutPanel_Orientation.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Orientation.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Orientation.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Orientation.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Orientation.Controls.Add(this.checkBox_Ori_West, 0, 0);
            this.tableLayoutPanel_Orientation.Controls.Add(this.checkBox_Ori_North, 0, 0);
            this.tableLayoutPanel_Orientation.Controls.Add(this.checkBox_Ori_East, 0, 0);
            this.tableLayoutPanel_Orientation.Controls.Add(this.checkBox_Ori_South, 0, 0);
            this.tableLayoutPanel_Orientation.Location = new System.Drawing.Point(115, 80);
            this.tableLayoutPanel_Orientation.Margin = new System.Windows.Forms.Padding(0, 3, 3, 0);
            this.tableLayoutPanel_Orientation.Name = "tableLayoutPanel_Orientation";
            this.tableLayoutPanel_Orientation.RowCount = 1;
            this.tableLayoutPanel_Orientation.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Orientation.Size = new System.Drawing.Size(320, 22);
            this.tableLayoutPanel_Orientation.TabIndex = 14;
            // 
            // checkBox_Ori_West
            // 
            this.checkBox_Ori_West.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.checkBox_Ori_West.AutoSize = true;
            this.checkBox_Ori_West.Location = new System.Drawing.Point(163, 3);
            this.checkBox_Ori_West.Name = "checkBox_Ori_West";
            this.checkBox_Ori_West.Size = new System.Drawing.Size(48, 16);
            this.checkBox_Ori_West.TabIndex = 2;
            this.checkBox_Ori_West.Text = "West";
            this.checkBox_Ori_West.UseVisualStyleBackColor = true;
            // 
            // checkBox_Ori_North
            // 
            this.checkBox_Ori_North.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.checkBox_Ori_North.AutoSize = true;
            this.checkBox_Ori_North.Location = new System.Drawing.Point(243, 3);
            this.checkBox_Ori_North.Name = "checkBox_Ori_North";
            this.checkBox_Ori_North.Size = new System.Drawing.Size(54, 16);
            this.checkBox_Ori_North.TabIndex = 3;
            this.checkBox_Ori_North.Text = "North";
            this.checkBox_Ori_North.UseVisualStyleBackColor = true;
            // 
            // checkBox_Ori_East
            // 
            this.checkBox_Ori_East.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.checkBox_Ori_East.AutoSize = true;
            this.checkBox_Ori_East.Location = new System.Drawing.Point(3, 3);
            this.checkBox_Ori_East.Name = "checkBox_Ori_East";
            this.checkBox_Ori_East.Size = new System.Drawing.Size(48, 16);
            this.checkBox_Ori_East.TabIndex = 0;
            this.checkBox_Ori_East.Text = "East";
            this.checkBox_Ori_East.UseVisualStyleBackColor = true;
            // 
            // checkBox_Ori_South
            // 
            this.checkBox_Ori_South.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.checkBox_Ori_South.AutoSize = true;
            this.checkBox_Ori_South.Location = new System.Drawing.Point(83, 3);
            this.checkBox_Ori_South.Name = "checkBox_Ori_South";
            this.checkBox_Ori_South.Size = new System.Drawing.Size(54, 16);
            this.checkBox_Ori_South.TabIndex = 1;
            this.checkBox_Ori_South.Text = "South";
            this.checkBox_Ori_South.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 6);
            this.label3.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(101, 12);
            this.label3.TabIndex = 0;
            this.label3.Text = "Building Number:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(3, 31);
            this.label4.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(77, 12);
            this.label4.TabIndex = 1;
            this.label4.Text = "Finish Date:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(3, 56);
            this.label5.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(77, 12);
            this.label5.TabIndex = 2;
            this.label5.Text = "Floor Count:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(3, 81);
            this.label6.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(77, 12);
            this.label6.TabIndex = 3;
            this.label6.Text = "Orientation:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(3, 108);
            this.label7.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(77, 12);
            this.label7.TabIndex = 4;
            this.label7.Text = "Ready House:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(3, 133);
            this.label8.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(77, 12);
            this.label8.TabIndex = 5;
            this.label8.Text = "Description:";
            // 
            // textBox_BuildingNum
            // 
            this.textBox_BuildingNum.Location = new System.Drawing.Point(118, 3);
            this.textBox_BuildingNum.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.textBox_BuildingNum.Name = "textBox_BuildingNum";
            this.textBox_BuildingNum.Size = new System.Drawing.Size(300, 21);
            this.textBox_BuildingNum.TabIndex = 0;
            // 
            // dateTimePicker_FinishDate
            // 
            this.dateTimePicker_FinishDate.Location = new System.Drawing.Point(118, 28);
            this.dateTimePicker_FinishDate.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.dateTimePicker_FinishDate.Name = "dateTimePicker_FinishDate";
            this.dateTimePicker_FinishDate.Size = new System.Drawing.Size(200, 21);
            this.dateTimePicker_FinishDate.TabIndex = 1;
            // 
            // numericUpDown_FloorCount
            // 
            this.numericUpDown_FloorCount.Location = new System.Drawing.Point(118, 53);
            this.numericUpDown_FloorCount.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.numericUpDown_FloorCount.Maximum = new decimal(new int[] {
            300,
            0,
            0,
            0});
            this.numericUpDown_FloorCount.Name = "numericUpDown_FloorCount";
            this.numericUpDown_FloorCount.Size = new System.Drawing.Size(200, 21);
            this.numericUpDown_FloorCount.TabIndex = 2;
            // 
            // checkBox_ReadyHouse
            // 
            this.checkBox_ReadyHouse.AutoSize = true;
            this.checkBox_ReadyHouse.Location = new System.Drawing.Point(118, 108);
            this.checkBox_ReadyHouse.Margin = new System.Windows.Forms.Padding(3, 6, 3, 3);
            this.checkBox_ReadyHouse.Name = "checkBox_ReadyHouse";
            this.checkBox_ReadyHouse.Size = new System.Drawing.Size(54, 16);
            this.checkBox_ReadyHouse.TabIndex = 3;
            this.checkBox_ReadyHouse.Text = "Ready";
            this.checkBox_ReadyHouse.UseVisualStyleBackColor = true;
            // 
            // richTextBox_Description
            // 
            this.richTextBox_Description.Dock = System.Windows.Forms.DockStyle.Top;
            this.richTextBox_Description.Location = new System.Drawing.Point(118, 130);
            this.richTextBox_Description.Name = "richTextBox_Description";
            this.richTextBox_Description.Size = new System.Drawing.Size(551, 96);
            this.richTextBox_Description.TabIndex = 4;
            this.richTextBox_Description.Text = "";
            // 
            // BuildingEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.CancelButton = this.button_Cancel;
            this.ClientSize = new System.Drawing.Size(684, 370);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimumSize = new System.Drawing.Size(700, 408);
            this.Name = "BuildingEditor";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "BuildingEditor";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.tableLayoutPanel_Buttons.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.tableLayoutPanel_Relation.ResumeLayout(false);
            this.tableLayoutPanel_Relation.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.tableLayoutPanel_Property.ResumeLayout(false);
            this.tableLayoutPanel_Property.PerformLayout();
            this.tableLayoutPanel_Orientation.ResumeLayout(false);
            this.tableLayoutPanel_Orientation.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_FloorCount)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Buttons;
        private System.Windows.Forms.Button button_Save;
        private System.Windows.Forms.Button button_Cancel;
        private System.Windows.Forms.Button button_Reset;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Relation;
        private System.Windows.Forms.ComboBox comboBox_Stage;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox comboBox_Project;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Property;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox textBox_BuildingNum;
        private System.Windows.Forms.DateTimePicker dateTimePicker_FinishDate;
        private System.Windows.Forms.NumericUpDown numericUpDown_FloorCount;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Orientation;
        private System.Windows.Forms.CheckBox checkBox_Ori_West;
        private System.Windows.Forms.CheckBox checkBox_Ori_North;
        private System.Windows.Forms.CheckBox checkBox_Ori_East;
        private System.Windows.Forms.CheckBox checkBox_Ori_South;
        private System.Windows.Forms.CheckBox checkBox_ReadyHouse;
        private System.Windows.Forms.RichTextBox richTextBox_Description;
        private System.Windows.Forms.BindingSource bindingSource_Project;
        private System.Windows.Forms.BindingSource bindingSource_Stage;
    }
}