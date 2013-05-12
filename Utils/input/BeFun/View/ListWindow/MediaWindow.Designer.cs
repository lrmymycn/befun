using BeFun.View.Component;
namespace BeFun.View.ListWindow
{
    partial class MediaWindow
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
            this.dataGridView = new BeFun.View.Component.GirdView.MediaDataView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_project = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_LargeURL = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_media_type = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.column_content_type = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Query = new System.Windows.Forms.TableLayoutPanel();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.textBox_Query_Url = new System.Windows.Forms.TextBox();
            this.comboBox_Query_Project = new System.Windows.Forms.ComboBox();
            this.bindingSource_Project = new System.Windows.Forms.BindingSource(this.components);
            this.comboBox_Query_ContentType = new System.Windows.Forms.ComboBox();
            this.bindingSource_ContentType = new System.Windows.Forms.BindingSource(this.components);
            this.comboBox_Query_MediaType = new System.Windows.Forms.ComboBox();
            this.bindingSource_MediaType = new System.Windows.Forms.BindingSource(this.components);
            this.tableLayoutPanel2 = new System.Windows.Forms.TableLayoutPanel();
            this.button_Search = new System.Windows.Forms.Button();
            this.bindingSource_Floorplan = new System.Windows.Forms.BindingSource(this.components);
            this.tableLayoutPanel_Main.SuspendLayout();
            this.panel_Grid.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.tableLayoutPanel_Query.SuspendLayout();
            this.tableLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_ContentType)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_MediaType)).BeginInit();
            this.tableLayoutPanel2.SuspendLayout();
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
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(891, 609);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // panel_Grid
            // 
            this.panel_Grid.AutoSize = true;
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
            this.button_Close.Location = new System.Drawing.Point(341, 83);
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
            this.column_project,
            this.column_name,
            this.column_LargeURL,
            this.column_media_type,
            this.column_content_type});
            this.dataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView.EnableHeadersVisualStyles = false;
            this.dataGridView.Location = new System.Drawing.Point(0, 0);
            this.dataGridView.MultiSelect = false;
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
            this.id.HeaderText = "Id";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            this.id.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.id.Width = 60;
            // 
            // column_project
            // 
            this.column_project.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.column_project.DataPropertyName = "project_name";
            this.column_project.HeaderText = "Project";
            this.column_project.Name = "column_project";
            this.column_project.ReadOnly = true;
            this.column_project.Width = 90;
            // 
            // column_name
            // 
            this.column_name.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.column_name.DataPropertyName = "name";
            this.column_name.HeaderText = "Name";
            this.column_name.Name = "column_name";
            this.column_name.ReadOnly = true;
            this.column_name.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.column_name.Width = 80;
            // 
            // column_LargeURL
            // 
            this.column_LargeURL.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.column_LargeURL.DataPropertyName = "large_url";
            this.column_LargeURL.HeaderText = "Large URL";
            this.column_LargeURL.Name = "column_LargeURL";
            this.column_LargeURL.ReadOnly = true;
            this.column_LargeURL.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            // 
            // column_media_type
            // 
            this.column_media_type.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.column_media_type.DataPropertyName = "media_type_name";
            this.column_media_type.HeaderText = "Media Type";
            this.column_media_type.Name = "column_media_type";
            this.column_media_type.ReadOnly = true;
            this.column_media_type.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            // 
            // column_content_type
            // 
            this.column_content_type.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.column_content_type.DataPropertyName = "content_type_name";
            this.column_content_type.HeaderText = "Content Type";
            this.column_content_type.Name = "column_content_type";
            this.column_content_type.ReadOnly = true;
            this.column_content_type.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.column_content_type.Width = 120;
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
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel1, 0, 0);
            this.tableLayoutPanel_Query.Controls.Add(this.tableLayoutPanel2, 0, 1);
            this.tableLayoutPanel_Query.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Query.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Query.Name = "tableLayoutPanel_Query";
            this.tableLayoutPanel_Query.RowCount = 2;
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Query.Size = new System.Drawing.Size(879, 91);
            this.tableLayoutPanel_Query.TabIndex = 1;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.AutoSize = true;
            this.tableLayoutPanel1.ColumnCount = 4;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Controls.Add(this.label1, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.label2, 2, 0);
            this.tableLayoutPanel1.Controls.Add(this.label4, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.label5, 2, 1);
            this.tableLayoutPanel1.Controls.Add(this.textBox_Query_Url, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.comboBox_Query_Project, 3, 0);
            this.tableLayoutPanel1.Controls.Add(this.comboBox_Query_ContentType, 1, 1);
            this.tableLayoutPanel1.Controls.Add(this.comboBox_Query_MediaType, 3, 1);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 2;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(873, 50);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 7);
            this.label1.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(29, 12);
            this.label1.TabIndex = 1;
            this.label1.Text = "Url:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(439, 7);
            this.label2.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 2;
            this.label2.Text = "Project:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(3, 32);
            this.label4.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(83, 12);
            this.label4.TabIndex = 4;
            this.label4.Text = "Content Type:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(439, 32);
            this.label5.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(71, 12);
            this.label5.TabIndex = 5;
            this.label5.Text = "Media Type:";
            // 
            // textBox_Query_Url
            // 
            this.textBox_Query_Url.Location = new System.Drawing.Point(103, 3);
            this.textBox_Query_Url.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.textBox_Query_Url.Name = "textBox_Query_Url";
            this.textBox_Query_Url.Size = new System.Drawing.Size(200, 21);
            this.textBox_Query_Url.TabIndex = 0;
            // 
            // comboBox_Query_Project
            // 
            this.comboBox_Query_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Query_Project.DisplayMember = "name";
            this.comboBox_Query_Project.FormattingEnabled = true;
            this.comboBox_Query_Project.Location = new System.Drawing.Point(539, 3);
            this.comboBox_Query_Project.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_Project.Name = "comboBox_Query_Project";
            this.comboBox_Query_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_Project.TabIndex = 1;
            this.comboBox_Query_Project.ValueMember = "id";
            this.comboBox_Query_Project.SelectedIndexChanged += new System.EventHandler(this.comboBox_Query_Project_SelectedIndexChanged);
            // 
            // comboBox_Query_ContentType
            // 
            this.comboBox_Query_ContentType.DataSource = this.bindingSource_ContentType;
            this.comboBox_Query_ContentType.DisplayMember = "text";
            this.comboBox_Query_ContentType.FormattingEnabled = true;
            this.comboBox_Query_ContentType.Location = new System.Drawing.Point(103, 28);
            this.comboBox_Query_ContentType.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_ContentType.Name = "comboBox_Query_ContentType";
            this.comboBox_Query_ContentType.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_ContentType.TabIndex = 3;
            this.comboBox_Query_ContentType.ValueMember = "value";
            // 
            // comboBox_Query_MediaType
            // 
            this.comboBox_Query_MediaType.DataSource = this.bindingSource_MediaType;
            this.comboBox_Query_MediaType.DisplayMember = "text";
            this.comboBox_Query_MediaType.FormattingEnabled = true;
            this.comboBox_Query_MediaType.Location = new System.Drawing.Point(539, 28);
            this.comboBox_Query_MediaType.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_Query_MediaType.Name = "comboBox_Query_MediaType";
            this.comboBox_Query_MediaType.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Query_MediaType.TabIndex = 4;
            this.comboBox_Query_MediaType.ValueMember = "value";
            // 
            // tableLayoutPanel2
            // 
            this.tableLayoutPanel2.AutoSize = true;
            this.tableLayoutPanel2.ColumnCount = 2;
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel2.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel2.Controls.Add(this.button_Search, 1, 0);
            this.tableLayoutPanel2.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel2.Location = new System.Drawing.Point(3, 59);
            this.tableLayoutPanel2.Name = "tableLayoutPanel2";
            this.tableLayoutPanel2.RowCount = 1;
            this.tableLayoutPanel2.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel2.Size = new System.Drawing.Size(873, 29);
            this.tableLayoutPanel2.TabIndex = 1;
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
            // MediaWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_Close;
            this.ClientSize = new System.Drawing.Size(891, 609);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimizeBox = false;
            this.Name = "MediaWindow";
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Media";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.panel_Grid.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.tableLayoutPanel_Query.ResumeLayout(false);
            this.tableLayoutPanel_Query.PerformLayout();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_ContentType)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_MediaType)).EndInit();
            this.tableLayoutPanel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Floorplan)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.Panel panel_Grid;
        private Component.GirdView.MediaDataView dataGridView;
        private System.Windows.Forms.BindingSource bindingSource_Project;
        private System.Windows.Forms.BindingSource bindingSource_Floorplan;
        private System.Windows.Forms.BindingSource bindingSource_ContentType;
        private System.Windows.Forms.BindingSource bindingSource_MediaType;
        private System.Windows.Forms.Button button_Close;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Query;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBox_Query_Url;
        private System.Windows.Forms.ComboBox comboBox_Query_Project;
        private System.Windows.Forms.ComboBox comboBox_Query_ContentType;
        private System.Windows.Forms.ComboBox comboBox_Query_MediaType;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel2;
        private System.Windows.Forms.Button button_Search;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_project;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_LargeURL;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_media_type;
        private System.Windows.Forms.DataGridViewTextBoxColumn column_content_type;
    }
}