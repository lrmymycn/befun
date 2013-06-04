using System.Windows.Forms;
using BeFun.Common;
using System.Collections.Generic;
namespace BeFun.View.Editor
{
    partial class MediaEditor
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
            this.textBox_Alt = new System.Windows.Forms.TextBox();
            this.textBox_Name = new System.Windows.Forms.TextBox();
            this.label_ALT = new System.Windows.Forms.Label();
            this.label_Name = new System.Windows.Forms.Label();
            this.label_MediaType = new System.Windows.Forms.Label();
            this.label_ContentType = new System.Windows.Forms.Label();
            this.comboBox_ContentType = new System.Windows.Forms.ComboBox();
            this.bindingSource_ContentType = new System.Windows.Forms.BindingSource(this.components);
            this.tableLayoutPanel4 = new System.Windows.Forms.TableLayoutPanel();
            this.pictureBox_Large = new System.Windows.Forms.PictureBox();
            this.textBox_LargeURL = new System.Windows.Forms.TextBox();
            this.comboBox_MediaType = new System.Windows.Forms.ComboBox();
            this.bindingSource_MediaType = new System.Windows.Forms.BindingSource(this.components);
            this.tableLayoutPanel_Button = new System.Windows.Forms.TableLayoutPanel();
            this.button_Reset = new System.Windows.Forms.Button();
            this.button_Save = new System.Windows.Forms.Button();
            this.button_Cancel = new System.Windows.Forms.Button();
            this.tableLayoutPanel_Main.SuspendLayout();
            this.groupBox_Properties.SuspendLayout();
            this.tableLayoutPanel_Properties.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_Project)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_ContentType)).BeginInit();
            this.tableLayoutPanel4.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox_Large)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_MediaType)).BeginInit();
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
            this.tableLayoutPanel_Main.Size = new System.Drawing.Size(684, 286);
            this.tableLayoutPanel_Main.TabIndex = 0;
            // 
            // groupBox_Properties
            // 
            this.groupBox_Properties.AutoSize = true;
            this.groupBox_Properties.Controls.Add(this.tableLayoutPanel_Properties);
            this.groupBox_Properties.Dock = System.Windows.Forms.DockStyle.Top;
            this.groupBox_Properties.Location = new System.Drawing.Point(3, 3);
            this.groupBox_Properties.Name = "groupBox_Properties";
            this.groupBox_Properties.Size = new System.Drawing.Size(678, 245);
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
            this.tableLayoutPanel_Properties.Controls.Add(this.textBox_Alt, 1, 3);
            this.tableLayoutPanel_Properties.Controls.Add(this.textBox_Name, 1, 2);
            this.tableLayoutPanel_Properties.Controls.Add(this.label_ALT, 0, 3);
            this.tableLayoutPanel_Properties.Controls.Add(this.label_Name, 0, 2);
            this.tableLayoutPanel_Properties.Controls.Add(this.label_MediaType, 0, 4);
            this.tableLayoutPanel_Properties.Controls.Add(this.label_ContentType, 0, 5);
            this.tableLayoutPanel_Properties.Controls.Add(this.comboBox_ContentType, 1, 5);
            this.tableLayoutPanel_Properties.Controls.Add(this.tableLayoutPanel4, 1, 0);
            this.tableLayoutPanel_Properties.Controls.Add(this.comboBox_MediaType, 1, 4);
            this.tableLayoutPanel_Properties.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel_Properties.Location = new System.Drawing.Point(3, 17);
            this.tableLayoutPanel_Properties.Name = "tableLayoutPanel_Properties";
            this.tableLayoutPanel_Properties.RowCount = 6;
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 25F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Properties.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 20F));
            this.tableLayoutPanel_Properties.Size = new System.Drawing.Size(672, 225);
            this.tableLayoutPanel_Properties.TabIndex = 0;
            // 
            // comboBox_Project
            // 
            this.comboBox_Project.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.SuggestAppend;
            this.comboBox_Project.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.comboBox_Project.DataSource = this.bindingSource_Project;
            this.comboBox_Project.DisplayMember = "name";
            this.comboBox_Project.FormattingEnabled = true;
            this.comboBox_Project.Location = new System.Drawing.Point(118, 103);
            this.comboBox_Project.Name = "comboBox_Project";
            this.comboBox_Project.Size = new System.Drawing.Size(200, 20);
            this.comboBox_Project.TabIndex = 3;
            this.comboBox_Project.ValueMember = "id";
            this.comboBox_Project.SelectedIndexChanged += new System.EventHandler(this.comboBox_Project_SelectedIndexChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 106);
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
            this.label2.Size = new System.Drawing.Size(29, 12);
            this.label2.TabIndex = 2;
            this.label2.Text = "URL:";
            // 
            // textBox_Alt
            // 
            this.textBox_Alt.Location = new System.Drawing.Point(118, 153);
            this.textBox_Alt.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.textBox_Alt.Name = "textBox_Alt";
            this.textBox_Alt.Size = new System.Drawing.Size(300, 21);
            this.textBox_Alt.TabIndex = 5;
            // 
            // textBox_Name
            // 
            this.textBox_Name.Location = new System.Drawing.Point(118, 128);
            this.textBox_Name.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.textBox_Name.Name = "textBox_Name";
            this.textBox_Name.Size = new System.Drawing.Size(300, 21);
            this.textBox_Name.TabIndex = 4;
            // 
            // label_ALT
            // 
            this.label_ALT.AutoSize = true;
            this.label_ALT.Location = new System.Drawing.Point(3, 156);
            this.label_ALT.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label_ALT.Name = "label_ALT";
            this.label_ALT.Size = new System.Drawing.Size(29, 12);
            this.label_ALT.TabIndex = 5;
            this.label_ALT.Text = "Alt:";
            // 
            // label_Name
            // 
            this.label_Name.AutoSize = true;
            this.label_Name.Location = new System.Drawing.Point(3, 131);
            this.label_Name.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label_Name.Name = "label_Name";
            this.label_Name.Size = new System.Drawing.Size(35, 12);
            this.label_Name.TabIndex = 4;
            this.label_Name.Text = "Name:";
            // 
            // label_MediaType
            // 
            this.label_MediaType.AutoSize = true;
            this.label_MediaType.Location = new System.Drawing.Point(3, 181);
            this.label_MediaType.Margin = new System.Windows.Forms.Padding(3, 6, 0, 0);
            this.label_MediaType.Name = "label_MediaType";
            this.label_MediaType.Size = new System.Drawing.Size(71, 12);
            this.label_MediaType.TabIndex = 6;
            this.label_MediaType.Text = "Media Type:";
            // 
            // label_ContentType
            // 
            this.label_ContentType.AutoSize = true;
            this.label_ContentType.Location = new System.Drawing.Point(3, 206);
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
            this.comboBox_ContentType.Location = new System.Drawing.Point(118, 203);
            this.comboBox_ContentType.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_ContentType.Name = "comboBox_ContentType";
            this.comboBox_ContentType.Size = new System.Drawing.Size(200, 20);
            this.comboBox_ContentType.TabIndex = 7;
            this.comboBox_ContentType.ValueMember = "value";
            this.comboBox_ContentType.SelectedIndexChanged += new System.EventHandler(this.comboBox_ContentType_SelectedIndexChanged);
            // 
            // tableLayoutPanel4
            // 
            this.tableLayoutPanel4.ColumnCount = 2;
            this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle());
            this.tableLayoutPanel4.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel4.Controls.Add(this.pictureBox_Large, 0, 0);
            this.tableLayoutPanel4.Controls.Add(this.textBox_LargeURL, 0, 0);
            this.tableLayoutPanel4.Dock = System.Windows.Forms.DockStyle.Top;
            this.tableLayoutPanel4.Location = new System.Drawing.Point(115, 0);
            this.tableLayoutPanel4.Margin = new System.Windows.Forms.Padding(0);
            this.tableLayoutPanel4.Name = "tableLayoutPanel4";
            this.tableLayoutPanel4.RowCount = 1;
            this.tableLayoutPanel4.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 100F));
            this.tableLayoutPanel4.Size = new System.Drawing.Size(557, 100);
            this.tableLayoutPanel4.TabIndex = 2;
            // 
            // pictureBox_Large
            // 
            this.pictureBox_Large.Location = new System.Drawing.Point(206, 3);
            this.pictureBox_Large.Name = "pictureBox_Large";
            this.pictureBox_Large.Size = new System.Drawing.Size(100, 94);
            this.pictureBox_Large.TabIndex = 4;
            this.pictureBox_Large.TabStop = false;
            // 
            // textBox_LargeURL
            // 
            this.textBox_LargeURL.Location = new System.Drawing.Point(3, 3);
            this.textBox_LargeURL.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.textBox_LargeURL.Name = "textBox_LargeURL";
            this.textBox_LargeURL.ReadOnly = true;
            this.textBox_LargeURL.Size = new System.Drawing.Size(200, 21);
            this.textBox_LargeURL.TabIndex = 0;
            this.textBox_LargeURL.DoubleClick += new System.EventHandler(this.textBox_LargeURL_Double_Click);
            // 
            // comboBox_MediaType
            // 
            this.comboBox_MediaType.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.SuggestAppend;
            this.comboBox_MediaType.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.comboBox_MediaType.DataSource = this.bindingSource_MediaType;
            this.comboBox_MediaType.DisplayMember = "text";
            this.comboBox_MediaType.FormattingEnabled = true;
            this.comboBox_MediaType.Location = new System.Drawing.Point(118, 178);
            this.comboBox_MediaType.Margin = new System.Windows.Forms.Padding(3, 3, 0, 0);
            this.comboBox_MediaType.Name = "comboBox_MediaType";
            this.comboBox_MediaType.Size = new System.Drawing.Size(200, 20);
            this.comboBox_MediaType.TabIndex = 6;
            this.comboBox_MediaType.ValueMember = "value";
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
            this.tableLayoutPanel_Button.Location = new System.Drawing.Point(3, 254);
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
            // MediaEditor
            // 
            this.AutoScroll = true;
            this.CancelButton = this.button_Cancel;
            this.ClientSize = new System.Drawing.Size(684, 292);
            this.Controls.Add(this.tableLayoutPanel_Main);
            this.MinimumSize = new System.Drawing.Size(700, 330);
            this.Name = "MediaEditor";
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
            this.tableLayoutPanel4.ResumeLayout(false);
            this.tableLayoutPanel4.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox_Large)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.bindingSource_MediaType)).EndInit();
            this.tableLayoutPanel_Button.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion


        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Main;
        private System.Windows.Forms.GroupBox groupBox_Properties;
        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel_Properties;
        private System.Windows.Forms.Label label_Name;
        private System.Windows.Forms.Label label_ALT;
        private System.Windows.Forms.Label label_MediaType;
        private System.Windows.Forms.Label label_ContentType;
        private System.Windows.Forms.TextBox textBox_Alt;
        private System.Windows.Forms.TextBox textBox_Name;
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
        private TableLayoutPanel tableLayoutPanel4;
        private PictureBox pictureBox_Large;
        private TextBox textBox_LargeURL;
    }
}
