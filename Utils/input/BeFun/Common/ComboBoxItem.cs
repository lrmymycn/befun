using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Common
{
    [Serializable]
    public class ComboBoxItem
    {
        public ComboBoxItem()
        {
        }

        public ComboBoxItem(object value, string text)
        {
            this.value = value;
            this.text = text;
        }

        public object value { get; set; }
        public string text { get; set; }

    }
}
