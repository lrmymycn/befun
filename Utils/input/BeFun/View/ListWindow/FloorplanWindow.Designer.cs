namespace BeFun.View.ListWindow
{
    partial class FloorplanWindow
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
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            this.tableLayoutPanel_Main = new System.Windows.Forms.TableLayoutPanel();
            this.panel_Grid = new System.Windows.Forms.Panel();
            this.button_Close = new System.Windows.Forms.Button();
            this.dataGridView = new BeFun.View.Component.GirdView.FloorplanDataView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.project_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.StageName = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.BuildingNum = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.description = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.type = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.is_split = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.is_studio = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.bedroom_count = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.bathroom_count = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.total_size = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Query = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel3 = new System.Windows.Forms.TableLayoutPanel();
            this.button_Search = new System.Windows.Forms.Button();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.comboBox_Query_Building = new System.Windows.Forms.ComboBox();
            this.bindingSource_Building = new System.Windows.Forms.BindingSource(this.components);
            this.comboBox_Query_Stage = new System.Windows.Forms.ComboBox();
            this.bindingSource_Stage = new System.Windows.Forms.BindingSource(this.components);
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.comboBox_Query_Project = new System.Windows.Forms.ComboBox();
            this.bindingSource_Project = new System.Windows.Forms.BindingSource(this.components);
            this.label4 = new System.Windows.Forms.Label();
            this.textBox_ID = new System.Windows.Forms.TextBox();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.panel_Grid.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.tableLayoutPanel_Query.SuspendLayout();
            this.tableLayoutPanel3.SuspendLayout();
            this.tableLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Building)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.AutoSize = true;
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.panel_Grid, 0, 1);
            this.tableLayoutPanel_Main.Controls.Add(this.groupBox1, 0, 0);
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
            this.panel_Grid.Controls.Add(this.button_Close);
            this.panel_Grid.Controls.Add(this.dataGridView);
            this.panel_Grid.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel_Grid.Location = new System.Drawing.Point(3, 120);
            this.panel_Grid.Name = "panel_Grid";
            this.panel_Grid.Size = new System.Drawing.Size(885, 486);
            this.panel_Grid.TabIndex = 2;
            // 
            // button_Close
            // 
            this.button_Close.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_Close.Location = new System.Drawing.Point(387, 79);
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
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle1.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle1.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle1.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dataGridView.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle1;
            this.dataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id,
            this.project_id,
            this.StageName,
            this.BuildingNum,
            this.description,
            this.type,
            this.is_split,
            this.is_studio,
            this.bedroom_count,
            this.bathroom_count,
            this.total_size});
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.SystemColors.Window;
            dataGridViewCellStyle2.Font = new System.Drawing.Font("宋体", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.SystemColors.ControlText;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.False;
            this.dataGridView.DefaultCellStyle = dataGridViewCellStyle2;
            this.dataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView.EnableHeadersVisualStyles = false;
            this.dataGridView.Location = new System.Drawing.Point(0, 0);
            this.dataGridView.Name = "dataGridView";
            this.dataGridView.parentWindow = null;
            this.dataGridView.queryCondition = null;
            this.dataGridView.ReadOnly = true;
            this.dataGridView.RowTemplate.Height = 23;
            this.dataGridView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView.Size = new System.Drawing.Size(885, 486);
            this.dataGridView.TabIndex = 0;
            this.dataGridView.type = BeFun.View.ListWindow.ListWindowType.View;
            // 
            // id
            // 
            this.id.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.id.DataPropertyName = "id";
            this.id.HeaderText = "ID";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            this.id.Width = 42;
            // 
            // project_id
            // 
            this.project_id.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.project_id.DataPropertyName = "project_name";
            this.project_id.HeaderText = "Project";
            this.project_id.Name = "project_id";
            this.project_id.ReadOnly = true;
            this.project_id.Width = 90;
            // 
            // StageName
            // 
            this.StageName.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.StageName.DataPropertyName = "stage_name";
            this.StageName.HeaderText = "Stage Name";
            this.StageName.Name = "StageName";
            this.StageName.ReadOnly = true;
            this.StageName.Width = 90;
            // 
            // BuildingNum
            // 
            this.BuildingNum.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.BuildingNum.DataPropertyName = "building_num";
            this.BuildingNum.HeaderText = "Building Number";
            this.BuildingNum.Name = "BuildingNum";
            this.BuildingNum.ReadOnly = true;
            this.BuildingNum.Width = 90;
            // 
            // description
            // 
            this.description.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.description.DataPropertyName = "description";
            this.description.HeaderText = "Description";
            this.description.Name = "description";
            this.description.ReadOnly = true;
            // 
            // type
            // 
            this.type.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.type.DataPropertyName = "type_name";
            this.type.HeaderText = "Type";
            this.type.Name = "type";
            this.type.ReadOnly = true;
            this.type.Width = 80;
            // 
            // is_split
            // 
            this.is_split.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.is_split.DataPropertyName = "is_split";
            this.is_split.HeaderText = "Split";
            this.is_split.Name = "is_split";
            this.is_split.ReadOnly = true;
            this.is_split.Width = 50;
            // 
            // is_studio
            // 
            this.is_studio.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.is_studio.DataPropertyName = "is_studio";
            this.is_studio.HeaderText = "Studio";
            this.is_studio.Name = "is_studio";
            this.is_studio.ReadOnly = true;
            this.is_studio.Width = 50;
            // 
            // bedroom_count
            // 
            this.bedroom_count.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.bedroom_count.DataPropertyName = "bedroom_count";
            this.bedroom_count.HeaderText = "Bedroom";
            this.bedroom_count.Name = "bedroom_count";
            this.bedroom_count.ReadOnly = true;
            this.bedroom_count.Width = 50;
            // 
            // bathroom_count
            // 
            this.bathroom_count.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.bathroom_count.DataPropertyName = "bathroom_count";
            this.bathroom_count.HeaderText = "Bathroom";
            this.bathroom_count.Name = "bathroom_count";
            this.bathroom_count.ReadOnly = true;
            this.bathroom_count.Width = 60;
            // 
            // total_size
            // 
            this.total_size.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.total_size.DataPropertyName = "total_size";
            this.total_size.HeaderText = "Total Size";
            this.total_size.Name = "total_size";
            this.total_size.ReadOnly = true;
            this.total_size.Width = 50;
            // 
            // groupBox1
            // 
            this.groupBox1.AutoSize = true;
            this.groupBox1.Controls.Add(this.tableLayoutPanel_Query);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox1.Location = new System.Drawing.Point(3, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(885, 111);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Query";
            // 
            // tableLayoutPanel_Query
            // 
            this.tableLayoutPanel_Query.AutoSize = true;
            this.tableLayoutPanel_Query.ColumnCount = 1;
            this.tableLayoutPanel_Query.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel3, 0, 1);
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel1, 0, 0);
            this.tableLayoutPanel_Query.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Query.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Query.Name = "tableLayoutPanel_Query";
            this.tableLayoutPanel_Query.RowCount = 2;
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.Size = new System.Drawing.Size(879, 91);
            this.tableLayoutPanel_Query.TabIndex = 0;
            // 
            // tableLayoutPanel3
            // 
            this.tableLayoutPanel3.AutoSize = true;
            this.tableLayoutPanel3.ColumnCount = 2;
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel3.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel3.Controls.Add(this.button_Search, 1, 0);
            this.tableLayoutPanel3.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel3.Location = new System.Drawing.Point(3, 59);
            this.tableLayoutPanel3.Name = "tableLayoutPanel3";
            this.tableLayoutPanel3.RowCount = 1;
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
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
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.AutoSize = true;
            this.tableLayoutPanel1.ColumnCount = 4;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Controls.Add(this.comboBox_Query_Building, 1, 1);
            this.tableLayoutPanel1.Controls.Add(this.comboBox_Query_Stage, 3, 0);
            this.tableLayoutPanel1.Controls.Add(this.label2, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.label1, 2, 0);
            this.tableLayoutPanel1.Controls.Add(this.label3, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.comboBox_Query_Project, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.label4, 2, 1);
            this.tableLayoutPanel1.Controls.Add(this.textBox_ID, 3, 1);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 2;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(873, 50);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // comboBox_Query_Building
            // 
            this.comboBox_Query_Building.DataSource = this.bindingSource_Building;
            this.comboBox_Query_Building.DisplayMember = "building_num";
            this.comboBox_Query_Building.FormattingEnabled = true;
            this.comboBox_Query_Building.Location = new System.Drawing.Point(118, 28);
            this.comboBox_Query_Building.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_Building.Name = "comboBox_Query_Building";
            this.comboBox_Query_Building.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Building.TabIndex = 2;
            this.comboBox_Query_Building.ValueMember = "id";
            // 
            // comboBox_Query_Stage
            // 
            this.comboBox_Query_Stage.DataSource = this.bindingSource_Stage;
            this.comboBox_Query_Stage.DisplayMember = "name";
            this.comboBox_Query_Stage.FormattingEnabled = true;
            this.comboBox_Query_Stage.Location = new System.Drawing.Point(554, 3);
            this.comboBox_Query_Stage.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_Stage.Name = "comboBox_Query_Stage";
            this.comboBox_Query_Stage.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Stage.TabIndex = 1;
            this.comboBox_Query_Stage.ValueMember = "id";
            this.comboBox_Query_Stage.SelectedIndexChanged += new System.EventHandler(this.comboBox_Query_Stage_SelectedIndexChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 7);
            this.label2.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 3;
            this.label2.Text = "Project:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(439, 7);
            this.label1.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 4;
            this.label1.Text = "Stage:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 32);
            this.label3.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(59, 12);
            this.label3.TabIndex = 5;
            this.label3.Text = "Building:";
            // 
            // comboBox_Query_Project
            // 
            this.comboBox_Query_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Query_Project.DisplayMember = "name";
            this.comboBox_Query_Project.FormattingEnabled = true;
            this.comboBox_Query_Project.Location = new System.Drawing.Point(118, 3);
            this.comboBox_Query_Project.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_Project.Name = "comboBox_Query_Project";
            this.comboBox_Query_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Project.TabIndex = 0;
            this.comboBox_Query_Project.ValueMember = "id";
            this.comboBox_Query_Project.SelectedIndexChanged += new System.EventHandler(this.comboBox_Query_Project_SelectedIndexChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(439, 32);
            this.label4.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(23, 12);
            this.label4.TabIndex = 6;
            this.label4.Text = "Id:";
            // 
            // textBox_ID
            // 
            this.textBox_ID.Location = new System.Drawing.Point(554, 28);
            this.textBox_ID.Name = "textBox_ID";
            this.textBox_ID.Size = new System.Drawing.Size(200, 21);
            this.textBox_ID.TabIndex = 7;
            // 
            // FloorplanWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_Close;
            this.ClientSize = new System.Drawing.Size(891, 609);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimizeBox = false;
            this.Name = "FloorplanWindow";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Floorplan";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.panel_Grid.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.tableLayoutPanel_Query.ResumeLayout(false);
            this.tableLayoutPanel_Query.PerformLayout();
            this.tableLayoutPanel3.ResumeLayout(false);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Building)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.Panel panel_Grid;
        private Component.GirdView.FloorplanDataView dataGridView;
        private System.Windows.Forms.BindingSource bindingSource_Project;
        private System.Windows.Forms.BindingSource bindingSource_Stage;
        private System.Windows.Forms.BindingSource bindingSource_Building;
        private System.Windows.Forms.Button button_Close;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Query;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel3;
        private System.Windows.Forms.Button button_Search;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.ComboBox comboBox_Query_Building;
        private System.Windows.Forms.ComboBox comboBox_Query_Stage;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox comboBox_Query_Project;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn project_id;
        private System.Windows.Forms.DataGridViewTextBoxColumn StageName;
        private System.Windows.Forms.DataGridViewTextBoxColumn BuildingNum;
        private System.Windows.Forms.DataGridViewTextBoxColumn description;
        private System.Windows.Forms.DataGridViewTextBoxColumn type;
        private System.Windows.Forms.DataGridViewTextBoxColumn is_split;
        private System.Windows.Forms.DataGridViewTextBoxColumn is_studio;
        private System.Windows.Forms.DataGridViewTextBoxColumn bedroom_count;
        private System.Windows.Forms.DataGridViewTextBoxColumn bathroom_count;
        private System.Windows.Forms.DataGridViewTextBoxColumn total_size;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBox_ID;
    }
}