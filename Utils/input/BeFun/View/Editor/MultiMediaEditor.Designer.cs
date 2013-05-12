using System.Windows.Forms;
using BeFun.Common;
using System.Collections.Generic;
namespace BeFun.View.Editor
{
    partial class MultiMediaEditor
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
            this.components = new System.ComponentModel.Container();
            this.tableLayoutPanel_Main = new System.Windows.Forms.TableLayoutPanel();
            this.groupBox_Properties = new System.Windows.Forms.GroupBox();
            this.tableLayoutPanel_Properties = new System.Windows.Forms.TableLayoutPanel();
            this.comboBox_Project = new System.Windows.Forms.ComboBox();
            this.bindingSource_Project = new System.Windows.Forms.BindingSource(this.components);
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label_MediaType = new System.Windows.Forms.Label();
            this.label_ContentType = new System.Windows.Forms.Label();
            this.comboBox_ContentType = new System.Windows.Forms.ComboBox();
            this.bindingSource_ContentType = new System.Windows.Forms.BindingSource(this.components);
            this.comboBox_MediaType = new System.Windows.Forms.ComboBox();
            this.bindingSource_MediaType = new System.Windows.Forms.BindingSource(this.components);
            this.listView_Medias = new System.Windows.Forms.ListView();
            this.contextMenuStrip_Medias = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.toolStripMenuItem_Add = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem_Remove = new System.Windows.Forms.ToolStripMenuItem();
            this.imageList_Medias = new System.Windows.Forms.ImageList(this.components);
            this.tableLayoutPanel_Button = new System.Windows.Forms.TableLayoutPanel();
            this.button_Reset = new System.Windows.Forms.Button();
            this.button_Save = new System.Windows.Forms.Button();
            this.button_Cancel = new System.Windows.Forms.Button();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.groupBox_Properties.SuspendLayout();
            this.tableLayoutPanel_Properties.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_ContentType)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_MediaType)).BeginInit();
            this.contextMenuStrip_Medias.SuspendLayout();
            this.tableLayoutPanel_Button.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel_Main
            // 
            this.tableLayoutPanel_Main.AutoSize = true;
            this.tableLayoutPanel_Main.ColumnCount = 1;
            this.tableLayoutPanel_Main.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.Controls.Add(this.groupBox_Properties, 0, 0);
            this.tableLayoutPanel_Main.Controls.Add(this.tableLayoutPanel_Button, 0, 1);
            this.tableLayoutPanel_Main.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Main.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel_Main.Name = "tableLayoutPanel_Main";
            this.tableLayoutPanel_Main.RowCount = 2;
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Main.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(684, 342);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // groupBox_Properties
            // 
            this.groupBox_Properties.AutoSize = true;
            this.groupBox_Properties.Controls.Add(this.tableLayoutPanel_Properties);
            this.groupBox_Properties.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox_Properties.Location = new System.Drawing.Point(3, 3);
            this.groupBox_Properties.Name = "groupBox_Properties";
            this.groupBox_Properties.Size = new System.Drawing.Size(678, 301);
            this.groupBox_Properties.TabIndex = 0;
            this.groupBox_Properties.TabStop = false;
            this.groupBox_Properties.Text = "Properties";
            // 
            // tableLayoutPanel_Properties
            // 
            this.tableLayoutPanel_Properties.AutoSize = true;
            this.tableLayoutPanel_Properties.ColumnCount = 2;
            this.tableLayoutPanel_Properties.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 115F));
            this.tableLayoutPanel_Properties.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Properties.Controls.Add(this.comboBox_Project, 1, 1);
            this.tableLayoutPanel_Properties.Controls.Add(this.label3, 0, 1);
            this.tableLayoutPanel_Properties.Controls.Add(this.label2, 0, 0);
            this.tableLayoutPanel_Properties.Controls.Add(this.label_MediaType, 0, 2);
            this.tableLayoutPanel_Properties.Controls.Add(this.label_ContentType, 0, 3);
            this.tableLayoutPanel_Properties.Controls.Add(this.comboBox_ContentType, 1, 3);
            this.tableLayoutPanel_Properties.Controls.Add(this.comboBox_MediaType, 1, 2);
            this.tableLayoutPanel_Properties.Controls.Add(this.listView_Medias, 1, 0);
            this.tableLayoutPanel_Properties.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Properties.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Properties.Name = "tableLayoutPanel_Properties";
            this.tableLayoutPanel_Properties.RowCount = 4;
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Properties.Size = new System.Drawing.Size(672, 281);
            this.tableLayoutPanel_Properties.TabIndex = 0;
            // 
            // comboBox_Project
            // 
            this.comboBox_Project.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.SuggestAppend;
            this.comboBox_Project.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.comboBox_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Project.DisplayMember = "name";
            this.comboBox_Project.FormattingEnabled = true;
            this.comboBox_Project.Location = new System.Drawing.Point(118, 209);
            this.comboBox_Project.Name = "comboBox_Project";
            this.comboBox_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Project.TabIndex = 3;
            this.comboBox_Project.ValueMember = "id";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 212);
            this.label3.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 12);
            this.label3.TabIndex = 3;
            this.label3.Text = "Project:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 6);
            this.label2.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(47, 12);
            this.label2.TabIndex = 2;
            this.label2.Text = "Medias:";
            // 
            // label_MediaType
            // 
            this.label_MediaType.AutoSize = true;
            this.label_MediaType.Location = new System.Drawing.Point(3, 237);
            this.label_MediaType.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label_MediaType.Name = "label_MediaType";
            this.label_MediaType.Size = new System.Drawing.Size(71, 12);
            this.label_MediaType.TabIndex = 6;
            this.label_MediaType.Text = "Media Type:";
            // 
            // label_ContentType
            // 
            this.label_ContentType.AutoSize = true;
            this.label_ContentType.Location = new System.Drawing.Point(3, 262);
            this.label_ContentType.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label_ContentType.Name = "label_ContentType";
            this.label_ContentType.Size = new System.Drawing.Size(83, 12);
            this.label_ContentType.TabIndex = 7;
            this.label_ContentType.Text = "Content Type:";
            // 
            // comboBox_ContentType
            // 
            this.comboBox_ContentType.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.SuggestAppend;
            this.comboBox_ContentType.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.comboBox_ContentType.DataSource = this.bindingSource_ContentType;
            this.comboBox_ContentType.DisplayMember = "text";
            this.comboBox_ContentType.FormattingEnabled = true;
            this.comboBox_ContentType.Location = new System.Drawing.Point(118, 259);
            this.comboBox_ContentType.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_ContentType.Name = "comboBox_ContentType";
            this.comboBox_ContentType.Size = new System.Drawing.Size(200, 20);
            this.comboBox_ContentType.TabIndex = 7;
            this.comboBox_ContentType.ValueMember = "value";
            // 
            // comboBox_MediaType
            // 
            this.comboBox_MediaType.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.SuggestAppend;
            this.comboBox_MediaType.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.comboBox_MediaType.DataSource = this.bindingSource_MediaType;
            this.comboBox_MediaType.DisplayMember = "text";
            this.comboBox_MediaType.FormattingEnabled = true;
            this.comboBox_MediaType.Location = new System.Drawing.Point(118, 234);
            this.comboBox_MediaType.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_MediaType.Name = "comboBox_MediaType";
            this.comboBox_MediaType.Size = new System.Drawing.Size(200, 20);
            this.comboBox_MediaType.TabIndex = 6;
            this.comboBox_MediaType.ValueMember = "value";
            // 
            // listView_Medias
            // 
            this.listView_Medias.ContextMenuStrip = this.contextMenuStrip_Medias;
            this.listView_Medias.Dock = System.Windows.Forms.DockStyle.Fill;
            this.listView_Medias.LargeImageList = this.imageList_Medias;
            this.listView_Medias.Location = new System.Drawing.Point(118, 3);
            this.listView_Medias.Name = "listView_Medias";
            this.listView_Medias.Size = new System.Drawing.Size(551, 200);
            this.listView_Medias.TabIndex = 8;
            this.listView_Medias.UseCompatibleStateImageBehavior = false;
            // 
            // contextMenuStrip_Medias
            // 
            this.contextMenuStrip_Medias.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripMenuItem_Add,
            this.toolStripMenuItem_Remove});
            this.contextMenuStrip_Medias.Name = "contextMenuStrip_Medias";
            this.contextMenuStrip_Medias.Size = new System.Drawing.Size(124, 48);
            // 
            // toolStripMenuItem_Add
            // 
            this.toolStripMenuItem_Add.Name = "toolStripMenuItem_Add";
            this.toolStripMenuItem_Add.Size = new System.Drawing.Size(123, 22);
            this.toolStripMenuItem_Add.Text = "Add";
            this.toolStripMenuItem_Add.Click += new System.EventHandler(this.toolStripMenuItem_Add_Click);
            // 
            // toolStripMenuItem_Remove
            // 
            this.toolStripMenuItem_Remove.Name = "toolStripMenuItem_Remove";
            this.toolStripMenuItem_Remove.Size = new System.Drawing.Size(123, 22);
            this.toolStripMenuItem_Remove.Text = "Remove";
            this.toolStripMenuItem_Remove.Click += new System.EventHandler(this.toolStripMenuItem_Remove_Click);
            // 
            // imageList_Medias
            // 
            this.imageList_Medias.ColorDepth = System.Windows.Forms.ColorDepth.Depth8Bit;
            this.imageList_Medias.ImageSize = new System.Drawing.Size(16, 16);
            this.imageList_Medias.TransparentColor = System.Drawing.Color.Transparent;
            // 
            // tableLayoutPanel_Button
            // 
            this.tableLayoutPanel_Button.AutoSize = true;
            this.tableLayoutPanel_Button.ColumnCount = 4;
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Button.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Absolute, 80F));
            this.tableLayoutPanel_Button.Controls.Add(this.button_Reset, 3, 0);
            this.tableLayoutPanel_Button.Controls.Add(this.button_Save, 1, 0);
            this.tableLayoutPanel_Button.Controls.Add(this.button_Cancel, 2, 0);
            this.tableLayoutPanel_Button.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.tableLayoutPanel_Button.Location = new System.Drawing.Point(3, 310);
            this.tableLayoutPanel_Button.Name = "tableLayoutPanel_Button";
            this.tableLayoutPanel_Button.RowCount = 1;
            this.tableLayoutPanel_Button.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel_Button.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Button.Size = new System.Drawing.Size(678, 29);
            this.tableLayoutPanel_Button.TabIndex = 1;
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
            // MultiMediaEditor
            // 
            this.AutoScroll = true;
            this.CancelButton = this.button_Cancel;
            this.ClientSize = new System.Drawing.Size(684, 347);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimumSize = new System.Drawing.Size(700, 330);
            this.Name = "MultiMediaEditor";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "MediaEditor";
            this.tableLayoutPanel_Main.ResumeLayout(false);
            this.tableLayoutPanel_Main.PerformLayout();
            this.groupBox_Properties.ResumeLayout(false);
            this.groupBox_Properties.PerformLayout();
            this.tableLayoutPanel_Properties.ResumeLayout(false);
            this.tableLayoutPanel_Properties.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_ContentType)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_MediaType)).EndInit();
            this.contextMenuStrip_Medias.ResumeLayout(false);
            this.tableLayoutPanel_Button.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion


        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.GroupBox groupBox_Properties;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Properties;
        private System.Windows.Forms.Label label_MediaType;
        private System.Windows.Forms.Label label_ContentType;
        private System.Windows.Forms.ComboBox comboBox_MediaType;
        private System.Windows.Forms.ComboBox comboBox_ContentType;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Button;
        private System.Windows.Forms.Button button_Reset;
        private System.Windows.Forms.Button button_Save;
        private System.Windows.Forms.Button button_Cancel;
        private BindingSource bindingSource_MediaType;
        private BindingSource bindingSource_ContentType;
        private Label label3;
        private ComboBox comboBox_Project;
        private BindingSource bindingSource_Project;
        private Label label2;
        private ListView listView_Medias;
        private ContextMenuStrip contextMenuStrip_Medias;
        private ToolStripMenuItem toolStripMenuItem_Add;
        private ToolStripMenuItem toolStripMenuItem_Remove;
        private ImageList imageList_Medias;
    }
}
