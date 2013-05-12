using BeFun.View.Component.GirdView;
namespace BeFun.View.ListWindow
{
    partial class StageWindow
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
            this.groupBox_Query = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Query = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.button_Search = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.comboBox_Query_Project = new System.Windows.Forms.ComboBox();
            this.bindingSource_Project = new System.Windows.Forms.BindingSource(this.components);
            this.panel_Grid = new System.Windows.Forms.Panel();
            this.button_Close = new System.Windows.Forms.Button();
            this.dataGridView = new Component.GirdView.StageDataView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.projectId = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.finishDate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.description = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.groupBox_Query.SuspendLayout();
            this.tableLayoutPanel_Query.SuspendLayout();
            this.tableLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            this.panel_Grid.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.groupBox_Query, 0, 0);
            this.tableLayoutPanel_Main.Controls.Add(this.panel_Grid, 0, 1);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 2;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(891, 609);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // groupBox_Query
            // 
            this.groupBox_Query.AutoSize = true;
            this.groupBox_Query.Controls.Add(this.tableLayoutPanel_Query);
            this.groupBox_Query.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox_Query.Location = new System.Drawing.Point(3, 3);
            this.groupBox_Query.Name = "groupBox_Query";
            this.groupBox_Query.Size = new System.Drawing.Size(885, 55);
            this.groupBox_Query.TabIndex = 0;
            this.groupBox_Query.TabStop = false;
            this.groupBox_Query.Text = "Query";
            // 
            // tableLayoutPanel_Query
            // 
            this.tableLayoutPanel_Query.AutoSize = true;
            this.tableLayoutPanel_Query.ColumnCount = 1;
            this.tableLayoutPanel_Query.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel1, 0, 0);
            this.tableLayoutPanel_Query.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Query.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Query.Name = "tableLayoutPanel_Query";
            this.tableLayoutPanel_Query.RowCount = 1;
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 35F));
            this.tableLayoutPanel_Query.Size = new System.Drawing.Size(879, 35);
            this.tableLayoutPanel_Query.TabIndex = 0;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.AutoSize = true;
            this.tableLayoutPanel1.ColumnCount = 3;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel1.Controls.Add(this.button_Search, 2, 0);
            this.tableLayoutPanel1.Controls.Add(this.label1, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.comboBox_Query_Project, 1, 0);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 1;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel1.Size = new System.Drawing.Size(873, 29);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // button_Search
            // 
            this.button_Search.Location = new System.Drawing.Point(776, 3);
            this.button_Search.Name = "button_Search";
            this.button_Search.Size = new System.Drawing.Size(75, 23);
            this.button_Search.TabIndex = 2;
            this.button_Search.Text = "&Search";
            this.button_Search.UseVisualStyleBackColor = true;
            this.button_Search.Click += new System.EventHandler(this.button_Search_Click);
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
            // comboBox_Query_Project
            // 
            this.comboBox_Query_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Query_Project.DisplayMember = "name";
            this.comboBox_Query_Project.FormattingEnabled = true;
            this.comboBox_Query_Project.Location = new System.Drawing.Point(118, 3);
            this.comboBox_Query_Project.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_Project.Name = "comboBox_Query_Project";
            this.comboBox_Query_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Project.TabIndex = 1;
            this.comboBox_Query_Project.ValueMember = "id";
            // 
            // panel_Grid
            // 
            this.panel_Grid.Controls.Add(this.button_Close);
            this.panel_Grid.Controls.Add(this.dataGridView);
            this.panel_Grid.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel_Grid.Location = new System.Drawing.Point(3, 64);
            this.panel_Grid.Name = "panel_Grid";
            this.panel_Grid.Size = new System.Drawing.Size(885, 542);
            this.panel_Grid.TabIndex = 1;
            // 
            // button_Close
            // 
            this.button_Close.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_Close.Location = new System.Drawing.Point(408, 66);
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
            this.projectId,
            this.name,
            this.finishDate,
            this.description});
            this.dataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView.EnableHeadersVisualStyles = false;
            this.dataGridView.Location = new System.Drawing.Point(0, 0);
            this.dataGridView.Name = "dataGridView";
            this.dataGridView.parentWindow = null;
            this.dataGridView.queryCondition = null;
            this.dataGridView.ReadOnly = true;
            this.dataGridView.RowTemplate.Height = 23;
            this.dataGridView.Size = new System.Drawing.Size(885, 542);
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
            // projectId
            // 
            this.projectId.DataPropertyName = "project_name";
            this.projectId.HeaderText = "Project";
            this.projectId.Name = "projectId";
            this.projectId.ReadOnly = true;
            this.projectId.Width = 72;
            // 
            // name
            // 
            this.name.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.name.DataPropertyName = "name";
            this.name.HeaderText = "Name";
            this.name.Name = "name";
            this.name.ReadOnly = true;
            this.name.Width = 120;
            // 
            // finishDate
            // 
            this.finishDate.DataPropertyName = "finish_date";
            this.finishDate.HeaderText = "Finish Date";
            this.finishDate.Name = "finishDate";
            this.finishDate.ReadOnly = true;
            this.finishDate.Width = 96;
            // 
            // description
            // 
            this.description.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.description.DataPropertyName = "description";
            this.description.HeaderText = "Description";
            this.description.Name = "description";
            this.description.ReadOnly = true;
            // 
            // StageWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_Close;
            this.ClientSize = new System.Drawing.Size(891, 609);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimizeBox = false;
            this.Name = "StageWindow";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Stage";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.groupBox_Query.ResumeLayout(false);
            this.groupBox_Query.PerformLayout();
            this.tableLayoutPanel_Query.ResumeLayout(false);
            this.tableLayoutPanel_Query.PerformLayout();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            this.panel_Grid.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.GroupBox groupBox_Query;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Query;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox comboBox_Query_Project;
        private System.Windows.Forms.BindingSource bindingSource_Project;
        private System.Windows.Forms.Button button_Search;
        private System.Windows.Forms.Panel panel_Grid;
        private StageDataView dataGridView;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn projectId;
        private System.Windows.Forms.DataGridViewTextBoxColumn name;
        private System.Windows.Forms.DataGridViewTextBoxColumn finishDate;
        private System.Windows.Forms.DataGridViewTextBoxColumn description;
        private System.Windows.Forms.Button button_Close;
    }
}