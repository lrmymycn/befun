using BeFun.View.ListWindow;
namespace BeFun.View
{
    partial class BuildingWindow
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
            this.panel_Grid = new System.Windows.Forms.Panel();
            this.button_Close = new System.Windows.Forms.Button();
            this.dataGridView = new BeFun.View.Component.GirdView.BuildingDataView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.project = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.stage = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.buildingNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.finishDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.floorCount = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.description = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox_Query = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Query = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel2 = new System.Windows.Forms.TableLayoutPanel();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.comboBox_Query_Project = new System.Windows.Forms.ComboBox();
            this.bindingSource_Project = new System.Windows.Forms.BindingSource(this.components);
            this.comboBox_Query_Stage = new System.Windows.Forms.ComboBox();
            this.bindingSource_Stage = new System.Windows.Forms.BindingSource(this.components);
            this.tableLayoutPanel3 = new System.Windows.Forms.TableLayoutPanel();
            this.button_Search = new System.Windows.Forms.Button();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.panel_Grid.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.groupBox_Query.SuspendLayout();
            this.tableLayoutPanel_Query.SuspendLayout();
            this.tableLayoutPanel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).BeginInit();
            this.tableLayoutPanel3.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.panel_Grid, 0, 1);
            this.tableLayoutPanel_Main.Controls.Add(this.groupBox_Query, 0, 0);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 2;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(891, 609);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // panel_Grid
            // 
            this.panel_Grid.AutoScroll = true;
            this.panel_Grid.AutoSize = true;
            this.panel_Grid.Controls.Add(this.button_Close);
            this.panel_Grid.Controls.Add(this.dataGridView);
            this.panel_Grid.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel_Grid.Location = new System.Drawing.Point(3, 95);
            this.panel_Grid.Name = "panel_Grid";
            this.panel_Grid.Size = new System.Drawing.Size(885, 511);
            this.panel_Grid.TabIndex = 1;
            // 
            // button_Close
            // 
            this.button_Close.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_Close.Location = new System.Drawing.Point(399, 74);
            this.button_Close.Name = "button_Close";
            this.button_Close.Size = new System.Drawing.Size(0, 0);
            this.button_Close.TabIndex = 1;
            this.button_Close.Text = "Close";
            this.button_Close.UseVisualStyleBackColor = true;
            this.button_Close.Click += new System.EventHandler(this.button_Close_Click);
            // 
            // dataGridView
            // 
            this.dataGridView.AllowUserToDeleteRows = false;
            this.dataGridView.AutoGenerateColumns = false;
            this.dataGridView.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.ColumnHeader;
            this.dataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id,
            this.project,
            this.stage,
            this.buildingNumber,
            this.finishDate,
            this.floorCount,
            this.description});
            this.dataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView.EnableHeadersVisualStyles = false;
            this.dataGridView.Location = new System.Drawing.Point(0, 0);
            this.dataGridView.Name = "dataGridView";
            this.dataGridView.parentWindow = null;
            this.dataGridView.queryCondition = null;
            this.dataGridView.ReadOnly = true;
            this.dataGridView.RowTemplate.Height = 23;
            this.dataGridView.Size = new System.Drawing.Size(885, 511);
            this.dataGridView.TabIndex = 0;
            this.dataGridView.type = ListWindowType.View;
            // 
            // id
            // 
            this.id.DataPropertyName = "id";
            this.id.HeaderText = "Id";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            this.id.Width = 42;
            // 
            // project
            // 
            this.project.DataPropertyName = "project_name";
            this.project.HeaderText = "Project";
            this.project.Name = "project";
            this.project.ReadOnly = true;
            this.project.Width = 72;
            // 
            // stage
            // 
            this.stage.DataPropertyName = "stage_name";
            this.stage.HeaderText = "Stage";
            this.stage.Name = "stage";
            this.stage.ReadOnly = true;
            this.stage.Width = 60;
            // 
            // buildingNumber
            // 
            this.buildingNumber.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.buildingNumber.DataPropertyName = "building_num";
            this.buildingNumber.HeaderText = "Building Number";
            this.buildingNumber.Name = "buildingNumber";
            this.buildingNumber.ReadOnly = true;
            this.buildingNumber.Width = 150;
            // 
            // finishDate
            // 
            this.finishDate.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.finishDate.DataPropertyName = "finish_date";
            this.finishDate.HeaderText = "Finish Date";
            this.finishDate.Name = "finishDate";
            this.finishDate.ReadOnly = true;
            this.finishDate.Width = 150;
            // 
            // floorCount
            // 
            this.floorCount.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.floorCount.DataPropertyName = "floor_count";
            this.floorCount.HeaderText = "Floor Count";
            this.floorCount.Name = "floorCount";
            this.floorCount.ReadOnly = true;
            this.floorCount.Width = 150;
            // 
            // description
            // 
            this.description.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.description.DataPropertyName = "description";
            this.description.HeaderText = "Description";
            this.description.Name = "description";
            this.description.ReadOnly = true;
            // 
            // groupBox_Query
            // 
            this.groupBox_Query.AutoSize = true;
            this.groupBox_Query.Controls.Add(this.tableLayoutPanel_Query);
            this.groupBox_Query.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox_Query.Location = new System.Drawing.Point(3, 3);
            this.groupBox_Query.Name = "groupBox_Query";
            this.groupBox_Query.Size = new System.Drawing.Size(885, 86);
            this.groupBox_Query.TabIndex = 0;
            this.groupBox_Query.TabStop = false;
            this.groupBox_Query.Text = "Query";
            // 
            // tableLayoutPanel_Query
            // 
            this.tableLayoutPanel_Query.AutoSize = true;
            this.tableLayoutPanel_Query.ColumnCount = 1;
            this.tableLayoutPanel_Query.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel2, 0, 0);
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel3, 0, 1);
            this.tableLayoutPanel_Query.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Query.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Query.Name = "tableLayoutPanel_Query";
            this.tableLayoutPanel_Query.RowCount = 2;
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.Size = new System.Drawing.Size(879, 66);
            this.tableLayoutPanel_Query.TabIndex = 0;
            // 
            // tableLayoutPanel2
            // 
            this.tableLayoutPanel2.AutoSize = true;
            this.tableLayoutPanel2.ColumnCount = 4;
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.Controls.Add(this.label1, 0, 0);
            this.tableLayoutPanel2.Controls.Add(this.label2, 2, 0);
            this.tableLayoutPanel2.Controls.Add(this.comboBox_Query_Project, 1, 0);
            this.tableLayoutPanel2.Controls.Add(this.comboBox_Query_Stage, 3, 0);
            this.tableLayoutPanel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel2.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel2.Name = "tableLayoutPanel2";
            this.tableLayoutPanel2.RowCount = 1;
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel2.Size = new System.Drawing.Size(873, 25);
            this.tableLayoutPanel2.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 7);
            this.label1.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "Project:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(448, 7);
            this.label2.Margin = new System.Windows.Forms.Padding(12, 7, 0, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 2;
            this.label2.Text = "Stage:";
            // 
            // comboBox_Query_Project
            // 
            this.comboBox_Query_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Query_Project.DisplayMember = "name";
            this.comboBox_Query_Project.FormattingEnabled = true;
            this.comboBox_Query_Project.Location = new System.Drawing.Point(103, 3);
            this.comboBox_Query_Project.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_Project.Name = "comboBox_Query_Project";
            this.comboBox_Query_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Project.TabIndex = 1;
            this.comboBox_Query_Project.ValueMember = "id";
            this.comboBox_Query_Project.SelectedIndexChanged += new System.EventHandler(this.comboBox_Query_Project_SelectedIndexChanged);
            // 
            // comboBox_Query_Stage
            // 
            this.comboBox_Query_Stage.DataSource = this.bindingSource_Stage;
            this.comboBox_Query_Stage.DisplayMember = "name";
            this.comboBox_Query_Stage.FormattingEnabled = true;
            this.comboBox_Query_Stage.Location = new System.Drawing.Point(539, 3);
            this.comboBox_Query_Stage.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_Stage.Name = "comboBox_Query_Stage";
            this.comboBox_Query_Stage.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Stage.TabIndex = 3;
            this.comboBox_Query_Stage.ValueMember = "id";
            // 
            // tableLayoutPanel3
            // 
            this.tableLayoutPanel3.AutoSize = true;
            this.tableLayoutPanel3.ColumnCount = 2;
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel3.Controls.Add(this.button_Search, 1, 0);
            this.tableLayoutPanel3.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel3.Location = new System.Drawing.Point(3, 34);
            this.tableLayoutPanel3.Name = "tableLayoutPanel3";
            this.tableLayoutPanel3.RowCount = 1;
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 29F));
            this.tableLayoutPanel3.Size = new System.Drawing.Size(873, 29);
            this.tableLayoutPanel3.TabIndex = 1;
            // 
            // button_Search
            // 
            this.button_Search.Location = new System.Drawing.Point(776, 3);
            this.button_Search.Name = "button_Search";
            this.button_Search.Size = new System.Drawing.Size(75, 23);
            this.button_Search.TabIndex = 0;
            this.button_Search.Text = "&Search";
            this.button_Search.UseVisualStyleBackColor = true;
            this.button_Search.Click += new System.EventHandler(this.button_Search_Click);
            // 
            // BuildingWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_Close;
            this.ClientSize = new System.Drawing.Size(891, 609);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimizeBox = false;
            this.Name = "BuildingWindow";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Building";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.panel_Grid.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.groupBox_Query.ResumeLayout(false);
            this.groupBox_Query.PerformLayout();
            this.tableLayoutPanel_Query.ResumeLayout(false);
            this.tableLayoutPanel_Query.PerformLayout();
            this.tableLayoutPanel2.ResumeLayout(false);
            this.tableLayoutPanel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).EndInit();
            this.tableLayoutPanel3.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.BindingSource bindingSource_Project;
        private System.Windows.Forms.BindingSource bindingSource_Stage;
        private System.Windows.Forms.Panel panel_Grid;
        private Component.GirdView.BuildingDataView dataGridView;
        private System.Windows.Forms.GroupBox groupBox_Query;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Query;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox comboBox_Query_Project;
        private System.Windows.Forms.ComboBox comboBox_Query_Stage;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel3;
        private System.Windows.Forms.Button button_Search;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn project;
        private System.Windows.Forms.DataGridViewTextBoxColumn stage;
        private System.Windows.Forms.DataGridViewTextBoxColumn buildingNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn finishDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn floorCount;
        private System.Windows.Forms.DataGridViewTextBoxColumn description;
        private System.Windows.Forms.Button button_Close;
    }
}