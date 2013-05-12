using BeFun.View.ListWindow;
namespace BeFun.View
{
    partial class ApartmentWindow
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
            this.dataGridView = new BeFun.View.Component.GirdView.ApartmentDataView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_Project = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_Stage = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_Building = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_floorplan = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_UnitNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_LotNumber = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_price = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_SoldOut = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Query = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel3 = new System.Windows.Forms.TableLayoutPanel();
            this.button_Search = new System.Windows.Forms.Button();
            this.tableLayoutPanel2 = new System.Windows.Forms.TableLayoutPanel();
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
            this.comboBox_Query_Floorplan = new System.Windows.Forms.ComboBox();
            this.bindingSource_Floorplan = new System.Windows.Forms.BindingSource(this.components);
            this.label5 = new System.Windows.Forms.Label();
            this.textBox_UnitNumber = new System.Windows.Forms.TextBox();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.panel_Grid.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.tableLayoutPanel_Query.SuspendLayout();
            this.tableLayoutPanel3.SuspendLayout();
            this.tableLayoutPanel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Building)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Floorplan)).BeginInit();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
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
            this.panel_Grid.Location = new System.Drawing.Point(3, 145);
            this.panel_Grid.Name = "panel_Grid";
            this.panel_Grid.Size = new System.Drawing.Size(885, 461);
            this.panel_Grid.TabIndex = 2;
            // 
            // button_Close
            // 
            this.button_Close.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_Close.Location = new System.Drawing.Point(366, 89);
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
            this.column_Project,
            this.column_Stage,
            this.column_Building,
            this.column_floorplan,
            this.column_UnitNumber,
            this.column_LotNumber,
            this.column_price,
            this.column_SoldOut});
            this.dataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView.EnableHeadersVisualStyles = false;
            this.dataGridView.Location = new System.Drawing.Point(0, 0);
            this.dataGridView.Name = "dataGridView";
            this.dataGridView.parentWindow = null;
            this.dataGridView.queryCondition = null;
            this.dataGridView.ReadOnly = true;
            this.dataGridView.RowTemplate.Height = 23;
            this.dataGridView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView.Size = new System.Drawing.Size(885, 461);
            this.dataGridView.TabIndex = 0;
            this.dataGridView.type = BeFun.View.ListWindow.ListWindowType.View;
            // 
            // id
            // 
            this.id.DataPropertyName = "id";
            this.id.HeaderText = "Id";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            this.id.Width = 42;
            // 
            // column_Project
            // 
            this.column_Project.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.column_Project.DataPropertyName = "project_name";
            this.column_Project.HeaderText = "Project";
            this.column_Project.Name = "column_Project";
            this.column_Project.ReadOnly = true;
            this.column_Project.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.column_Project.Width = 90;
            // 
            // column_Stage
            // 
            this.column_Stage.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.column_Stage.DataPropertyName = "stage_name";
            this.column_Stage.HeaderText = "Stage";
            this.column_Stage.Name = "column_Stage";
            this.column_Stage.ReadOnly = true;
            this.column_Stage.Width = 90;
            // 
            // column_Building
            // 
            this.column_Building.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.column_Building.DataPropertyName = "building_num";
            this.column_Building.HeaderText = "Building";
            this.column_Building.Name = "column_Building";
            this.column_Building.ReadOnly = true;
            this.column_Building.Width = 90;
            // 
            // column_floorplan
            // 
            this.column_floorplan.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.column_floorplan.DataPropertyName = "floorplan_desc";
            this.column_floorplan.HeaderText = "Floorplan";
            this.column_floorplan.MinimumWidth = 120;
            this.column_floorplan.Name = "column_floorplan";
            this.column_floorplan.ReadOnly = true;
            // 
            // column_UnitNumber
            // 
            this.column_UnitNumber.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.column_UnitNumber.DataPropertyName = "unit_number";
            this.column_UnitNumber.HeaderText = "Unit Number";
            this.column_UnitNumber.Name = "column_UnitNumber";
            this.column_UnitNumber.ReadOnly = true;
            this.column_UnitNumber.Width = 96;
            // 
            // column_LotNumber
            // 
            this.column_LotNumber.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.column_LotNumber.DataPropertyName = "lot_number";
            this.column_LotNumber.HeaderText = "Lot Number";
            this.column_LotNumber.Name = "column_LotNumber";
            this.column_LotNumber.ReadOnly = true;
            this.column_LotNumber.Width = 90;
            // 
            // column_price
            // 
            this.column_price.DataPropertyName = "price";
            this.column_price.HeaderText = "Price";
            this.column_price.Name = "column_price";
            this.column_price.ReadOnly = true;
            this.column_price.Width = 60;
            // 
            // column_SoldOut
            // 
            this.column_SoldOut.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.ColumnHeader;
            this.column_SoldOut.DataPropertyName = "sold_out";
            this.column_SoldOut.HeaderText = "Sold Out";
            this.column_SoldOut.Name = "column_SoldOut";
            this.column_SoldOut.ReadOnly = true;
            this.column_SoldOut.Width = 78;
            // 
            // groupBox1
            // 
            this.groupBox1.AutoSize = true;
            this.groupBox1.Controls.Add(this.tableLayoutPanel_Query);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox1.Location = new System.Drawing.Point(3, 3);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(885, 136);
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
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel2, 0, 0);
            this.tableLayoutPanel_Query.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Query.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Query.Name = "tableLayoutPanel_Query";
            this.tableLayoutPanel_Query.RowCount = 2;
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.Size = new System.Drawing.Size(879, 116);
            this.tableLayoutPanel_Query.TabIndex = 2;
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
            this.tableLayoutPanel3.Location = new System.Drawing.Point(3, 84);
            this.tableLayoutPanel3.Name = "tableLayoutPanel3";
            this.tableLayoutPanel3.RowCount = 1;
            this.tableLayoutPanel3.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel3.Size = new System.Drawing.Size(873, 29);
            this.tableLayoutPanel3.TabIndex = 2;
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
            // tableLayoutPanel2
            // 
            this.tableLayoutPanel2.AutoSize = true;
            this.tableLayoutPanel2.ColumnCount = 4;
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel2.Controls.Add(this.comboBox_Query_Building, 1, 1);
            this.tableLayoutPanel2.Controls.Add(this.comboBox_Query_Stage, 3, 0);
            this.tableLayoutPanel2.Controls.Add(this.label2, 0, 0);
            this.tableLayoutPanel2.Controls.Add(this.label1, 2, 0);
            this.tableLayoutPanel2.Controls.Add(this.label3, 0, 1);
            this.tableLayoutPanel2.Controls.Add(this.comboBox_Query_Project, 1, 0);
            this.tableLayoutPanel2.Controls.Add(this.label4, 2, 1);
            this.tableLayoutPanel2.Controls.Add(this.comboBox_Query_Floorplan, 3, 1);
            this.tableLayoutPanel2.Controls.Add(this.label5, 0, 2);
            this.tableLayoutPanel2.Controls.Add(this.textBox_UnitNumber, 1, 2);
            this.tableLayoutPanel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel2.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel2.Name = "tableLayoutPanel2";
            this.tableLayoutPanel2.RowCount = 3;
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel2.Size = new System.Drawing.Size(873, 75);
            this.tableLayoutPanel2.TabIndex = 0;
            // 
            // comboBox_Query_Building
            // 
            this.comboBox_Query_Building.DataSource = this.bindingSource_Building;
            this.comboBox_Query_Building.DisplayMember = "building_num";
            this.comboBox_Query_Building.FormattingEnabled = true;
            this.comboBox_Query_Building.Location = new System.Drawing.Point(118, 28);
            this.comboBox_Query_Building.Name = "comboBox_Query_Building";
            this.comboBox_Query_Building.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Building.TabIndex = 2;
            this.comboBox_Query_Building.ValueMember = "id";
            this.comboBox_Query_Building.SelectedIndexChanged += new System.EventHandler(this.comboBox_Query_Building_SelectedIndexChanged);
            // 
            // comboBox_Query_Stage
            // 
            this.comboBox_Query_Stage.DataSource = this.bindingSource_Stage;
            this.comboBox_Query_Stage.DisplayMember = "name";
            this.comboBox_Query_Stage.FormattingEnabled = true;
            this.comboBox_Query_Stage.Location = new System.Drawing.Point(554, 3);
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
            this.label2.TabIndex = 1;
            this.label2.Text = "Project:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(439, 7);
            this.label1.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "Stage:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 32);
            this.label3.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(59, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "Building:";
            // 
            // comboBox_Query_Project
            // 
            this.comboBox_Query_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Query_Project.DisplayMember = "name";
            this.comboBox_Query_Project.FormattingEnabled = true;
            this.comboBox_Query_Project.Location = new System.Drawing.Point(118, 3);
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
            this.label4.Size = new System.Drawing.Size(65, 12);
            this.label4.TabIndex = 6;
            this.label4.Text = "Floorplan:";
            // 
            // comboBox_Query_Floorplan
            // 
            this.comboBox_Query_Floorplan.DataSource = this.bindingSource_Floorplan;
            this.comboBox_Query_Floorplan.DisplayMember = "description";
            this.comboBox_Query_Floorplan.FormattingEnabled = true;
            this.comboBox_Query_Floorplan.Location = new System.Drawing.Point(554, 28);
            this.comboBox_Query_Floorplan.Name = "comboBox_Query_Floorplan";
            this.comboBox_Query_Floorplan.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Floorplan.TabIndex = 3;
            this.comboBox_Query_Floorplan.ValueMember = "id";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(3, 57);
            this.label5.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(77, 12);
            this.label5.TabIndex = 7;
            this.label5.Text = "Unit Number:";
            // 
            // textBox_UnitNumber
            // 
            this.textBox_UnitNumber.Location = new System.Drawing.Point(118, 53);
            this.textBox_UnitNumber.Name = "textBox_UnitNumber";
            this.textBox_UnitNumber.Size = new System.Drawing.Size(200, 21);
            this.textBox_UnitNumber.TabIndex = 8;
            // 
            // ApartmentWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_Close;
            this.ClientSize = new System.Drawing.Size(891, 609);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimizeBox = false;
            this.Name = "ApartmentWindow";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Apartment";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.panel_Grid.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.tableLayoutPanel_Query.ResumeLayout(false);
            this.tableLayoutPanel_Query.PerformLayout();
            this.tableLayoutPanel3.ResumeLayout(false);
            this.tableLayoutPanel2.ResumeLayout(false);
            this.tableLayoutPanel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Building)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Stage)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Floorplan)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.BindingSource bindingSource_Project;
        private System.Windows.Forms.BindingSource bindingSource_Stage;
        private System.Windows.Forms.BindingSource bindingSource_Building;
        private System.Windows.Forms.BindingSource bindingSource_Floorplan;
        private System.Windows.Forms.Panel panel_Grid;
        private Component.GirdView.ApartmentDataView dataGridView;
        private System.Windows.Forms.Button button_Close;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Query;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel3;
        private System.Windows.Forms.Button button_Search;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel2;
        private System.Windows.Forms.ComboBox comboBox_Query_Building;
        private System.Windows.Forms.ComboBox comboBox_Query_Stage;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox comboBox_Query_Project;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox comboBox_Query_Floorplan;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBox_UnitNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_Project;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_Stage;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_Building;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_floorplan;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_UnitNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_LotNumber;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_price;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_SoldOut;
    }
}