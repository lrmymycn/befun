using BeFun.Model;
using BeFun.Model.Dao;
using BeFun.View.Component;
using System;
using BeFun.View.Component.GirdView;
namespace BeFun.View.ListWindow
{
    partial class MainWindow
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.toolStripMenuItem_File = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_File_Open = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Query = new System.Windows.Forms.ToolStripMenuItem();
            this.stageToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.buildingToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Query_Floorplan = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Query_Apartment = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Query_Media = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip_Main = new System.Windows.Forms.MenuStrip();
            this.tableLayoutPanel_Main = new System.Windows.Forms.TableLayoutPanel();
            this.panel_Grid = new System.Windows.Forms.Panel();
            this.dataGridView = new BeFun.View.Component.GirdView.ProjectDataView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.BLOCK = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.logo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.description = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.developer = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.address = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.label1 = new System.Windows.Forms.Label();
            this.textBox_BlockOrName = new System.Windows.Forms.TextBox();
            this.button_Search = new System.Windows.Forms.Button();
            this.button_Close = new System.Windows.Forms.Button();
            this.dataToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.outputToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip_Main.SuspendLayout();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.panel_Grid.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).BeginInit();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStripMenuItem_File
            // 
            this.toolStripMenuItem_File.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem_File_Open});
            this.toolStripMenuItem_File.Name = "toolStripMenuItem_File";
            this.toolStripMenuItem_File.Size = new System.Drawing.Size(39, 21);
            this.toolStripMenuItem_File.Text = "&File";
            // 
            // toolStripMenuItem_File_Open
            // 
            this.toolStripMenuItem_File_Open.Name = "toolStripMenuItem_File_Open";
            this.toolStripMenuItem_File_Open.Size = new System.Drawing.Size(108, 22);
            this.toolStripMenuItem_File_Open.Text = "&Open";
            this.toolStripMenuItem_File_Open.Click += new System.EventHandler(this.openToolStripMenuItem1_Click);
            // 
            // toolStripMenuItem_Query
            // 
            this.toolStripMenuItem_Query.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stageToolStripMenuItem,
            this.buildingToolStripMenuItem,
            this.toolStripMenuItem_Query_Floorplan,
            this.toolStripMenuItem_Query_Apartment,
            this.toolStripMenuItem_Query_Media});
            this.toolStripMenuItem_Query.Enabled = false;
            this.toolStripMenuItem_Query.Name = "toolStripMenuItem_Query";
            this.toolStripMenuItem_Query.Size = new System.Drawing.Size(55, 21);
            this.toolStripMenuItem_Query.Text = "&Query";
            // 
            // stageToolStripMenuItem
            // 
            this.stageToolStripMenuItem.Name = "stageToolStripMenuItem";
            this.stageToolStripMenuItem.Size = new System.Drawing.Size(137, 22);
            this.stageToolStripMenuItem.Text = "&Stage";
            this.stageToolStripMenuItem.Click += new System.EventHandler(this.stageToolStripMenuItem_Click);
            // 
            // buildingToolStripMenuItem
            // 
            this.buildingToolStripMenuItem.Name = "buildingToolStripMenuItem";
            this.buildingToolStripMenuItem.Size = new System.Drawing.Size(137, 22);
            this.buildingToolStripMenuItem.Text = "&Building";
            this.buildingToolStripMenuItem.Click += new System.EventHandler(this.buildingToolStripMenuItem_Click);
            // 
            // toolStripMenuItem_Query_Floorplan
            // 
            this.toolStripMenuItem_Query_Floorplan.Name = "toolStripMenuItem_Query_Floorplan";
            this.toolStripMenuItem_Query_Floorplan.Size = new System.Drawing.Size(137, 22);
            this.toolStripMenuItem_Query_Floorplan.Text = "&Floorplan";
            this.toolStripMenuItem_Query_Floorplan.Click += new System.EventHandler(this.toolStripMenuItem_Query_Floorplan_Click);
            // 
            // toolStripMenuItem_Query_Apartment
            // 
            this.toolStripMenuItem_Query_Apartment.Name = "toolStripMenuItem_Query_Apartment";
            this.toolStripMenuItem_Query_Apartment.Size = new System.Drawing.Size(137, 22);
            this.toolStripMenuItem_Query_Apartment.Text = "&Apartment";
            this.toolStripMenuItem_Query_Apartment.Click += new System.EventHandler(this.toolStripMenuItem_Query_Apartment_Click);
            // 
            // toolStripMenuItem_Query_Media
            // 
            this.toolStripMenuItem_Query_Media.Name = "toolStripMenuItem_Query_Media";
            this.toolStripMenuItem_Query_Media.Size = new System.Drawing.Size(137, 22);
            this.toolStripMenuItem_Query_Media.Text = "&Media";
            this.toolStripMenuItem_Query_Media.Click += new System.EventHandler(this.toolStripMenuItem_Query_Media_Click);
            // 
            // menuStrip_Main
            // 
            this.menuStrip_Main.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem_File,
            this.toolStripMenuItem_Query,
            this.dataToolStripMenuItem});
            this.menuStrip_Main.Location = new System.Drawing.Point(0, 0);
            this.menuStrip_Main.Name = "menuStrip_Main";
            this.menuStrip_Main.Size = new System.Drawing.Size(891, 25);
            this.menuStrip_Main.TabIndex = 0;
            this.menuStrip_Main.Text = "menuStrip_Main";
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.panel_Grid, 0, 1);
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel1, 0, 0);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 25);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 2;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(891, 584);
            this.tableLayoutPanel_Main.TabIndex = 1;
            // 
            // panel_Grid
            // 
            this.panel_Grid.AutoSize = true;
            this.panel_Grid.Controls.Add(this.dataGridView);
            this.panel_Grid.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel_Grid.Location = new System.Drawing.Point(3, 38);
            this.panel_Grid.Name = "panel_Grid";
            this.panel_Grid.Size = new System.Drawing.Size(885, 543);
            this.panel_Grid.TabIndex = 1;
            // 
            // dataGridView
            // 
            this.dataGridView.AllowUserToDeleteRows = false;
            this.dataGridView.AutoGenerateColumns = false;
            this.dataGridView.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.ColumnHeader;
            this.dataGridView.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id,
            this.BLOCK,
            this.name,
            this.logo,
            this.description,
            this.developer,
            this.address});
            this.dataGridView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dataGridView.EnableHeadersVisualStyles = false;
            this.dataGridView.Location = new System.Drawing.Point(0, 0);
            this.dataGridView.Name = "dataGridView";
            this.dataGridView.queryCondition = null;
            this.dataGridView.ReadOnly = true;
            this.dataGridView.RowTemplate.Height = 23;
            this.dataGridView.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridView.Size = new System.Drawing.Size(885, 543);
            this.dataGridView.TabIndex = 0;
            this.dataGridView.type = BeFun.View.ListWindow.ListWindowType.View;
            // 
            // id
            // 
            this.id.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.id.DataPropertyName = "id";
            this.id.FillWeight = 437.9562F;
            this.id.HeaderText = "ID";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            this.id.Width = 60;
            // 
            // BLOCK
            // 
            this.BLOCK.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.BLOCK.DataPropertyName = "block";
            this.BLOCK.HeaderText = "BLOCK";
            this.BLOCK.Name = "BLOCK";
            this.BLOCK.ReadOnly = true;
            // 
            // name
            // 
            this.name.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.name.DataPropertyName = "name";
            this.name.FillWeight = 32.40876F;
            this.name.HeaderText = "NAME";
            this.name.Name = "name";
            this.name.ReadOnly = true;
            // 
            // logo
            // 
            this.logo.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.None;
            this.logo.DataPropertyName = "logo_id";
            this.logo.FillWeight = 32.40876F;
            this.logo.HeaderText = "LOGO";
            this.logo.Name = "logo";
            this.logo.ReadOnly = true;
            this.logo.Width = 150;
            // 
            // description
            // 
            this.description.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.Fill;
            this.description.DataPropertyName = "description";
            this.description.FillWeight = 32.40876F;
            this.description.HeaderText = "DESCRIPTION";
            this.description.Name = "description";
            this.description.ReadOnly = true;
            // 
            // developer
            // 
            this.developer.DataPropertyName = "developer";
            this.developer.FillWeight = 32.40876F;
            this.developer.HeaderText = "DEVELOPER";
            this.developer.Name = "developer";
            this.developer.ReadOnly = true;
            this.developer.Width = 84;
            // 
            // address
            // 
            this.address.DataPropertyName = "address";
            this.address.FillWeight = 32.40876F;
            this.address.HeaderText = "ADDRESS";
            this.address.Name = "address";
            this.address.ReadOnly = true;
            this.address.Width = 72;
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.AutoSize = true;
            this.tableLayoutPanel1.ColumnCount = 3;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 100F));
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle());
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel1.Controls.Add(this.label1, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.textBox_BlockOrName, 1, 0);
            this.tableLayoutPanel1.Controls.Add(this.button_Search, 2, 0);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(3, 3);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 1;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 29F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(885, 29);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 7);
            this.label1.Margin = new System.Windows.Forms.Padding(3, 7, 0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(65, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "Condition:";
            // 
            // textBox_BlockOrName
            // 
            this.textBox_BlockOrName.Location = new System.Drawing.Point(103, 3);
            this.textBox_BlockOrName.Margin = new System.Windows.Forms.Padding(3, 3, 3, 0);
            this.textBox_BlockOrName.Name = "textBox_BlockOrName";
            this.textBox_BlockOrName.Size = new System.Drawing.Size(200, 21);
            this.textBox_BlockOrName.TabIndex = 1;
            // 
            // button_Search
            // 
            this.button_Search.Location = new System.Drawing.Point(309, 3);
            this.button_Search.Name = "button_Search";
            this.button_Search.Size = new System.Drawing.Size(75, 23);
            this.button_Search.TabIndex = 2;
            this.button_Search.Text = "&Search";
            this.button_Search.UseVisualStyleBackColor = true;
            this.button_Search.Click += new System.EventHandler(this.button_Search_Click);
            // 
            // button_Close
            // 
            this.button_Close.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.button_Close.Location = new System.Drawing.Point(406, 2);
            this.button_Close.Name = "button_Close";
            this.button_Close.Size = new System.Drawing.Size(0, 0);
            this.button_Close.TabIndex = 2;
            this.button_Close.Text = "Close";
            this.button_Close.UseVisualStyleBackColor = true;
            this.button_Close.Click += new System.EventHandler(this.button_Close_Click);
            // 
            // dataToolStripMenuItem
            // 
            this.dataToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.outputToolStripMenuItem});
            this.dataToolStripMenuItem.Name = "dataToolStripMenuItem";
            this.dataToolStripMenuItem.Size = new System.Drawing.Size(47, 21);
            this.dataToolStripMenuItem.Text = "&Data";
            // 
            // outputToolStripMenuItem
            // 
            this.outputToolStripMenuItem.Name = "outputToolStripMenuItem";
            this.outputToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.outputToolStripMenuItem.Text = "&Output";
            this.outputToolStripMenuItem.Click += new System.EventHandler(this.outputToolStripMenuItem_Click);
            // 
            // MainWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.button_Close;
            this.ClientSize = new System.Drawing.Size(891, 609);
            this.Controls.Add(this.button_Close);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.Controls.Add(this.menuStrip_Main);
            this.MainMenuStrip = this.menuStrip_Main;
            this.Name = "MainWindow";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "BeFun";
            this.menuStrip_Main.ResumeLayout(false);
            this.menuStrip_Main.PerformLayout();
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.panel_Grid.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView)).EndInit();
            this.tableLayoutPanel1.ResumeLayout(false);
            this.tableLayoutPanel1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }


        #endregion

        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_File;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_File_Open;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Query;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Query_Floorplan;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Query_Apartment;
        private System.Windows.Forms.ToolStripMenuItem toolStripMenuItem_Query_Media;
        private System.Windows.Forms.MenuStrip menuStrip_Main;
        private ProjectDao projectDao = new ProjectDao();
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.Panel panel_Grid;
        private ProjectDataView dataGridView;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBox_BlockOrName;
        private System.Windows.Forms.Button button_Search;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn BLOCK;
        private System.Windows.Forms.DataGridViewTextBoxColumn name;
        private System.Windows.Forms.DataGridViewTextBoxColumn logo;
        private System.Windows.Forms.DataGridViewTextBoxColumn description;
        private System.Windows.Forms.DataGridViewTextBoxColumn developer;
        private System.Windows.Forms.DataGridViewTextBoxColumn address;
        private System.Windows.Forms.ToolStripMenuItem stageToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem buildingToolStripMenuItem;
        private System.Windows.Forms.Button button_Close;
        private System.Windows.Forms.ToolStripMenuItem dataToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem outputToolStripMenuItem;
    }
}

