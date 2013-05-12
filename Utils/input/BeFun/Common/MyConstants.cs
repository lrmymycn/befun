using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BeFun.Common
{
    public class MyConstants
    {
        // Message/Confirm box
        public const Int16 BOX_TYPE_NORMAL = 0;
        public const Int16 BOX_TYPE_ALERT = 1;
        public const Int16 BOX_TYPE_ERROR = 2;

        public const string TITLE_NORMAL = "Message";
        public const string TITLE_ALERT = "Alert";
        public const string TITLE_ERROR = "Error";

        public const string PROMPT_NORMAL = "Please read the message.";
        public const string PROMPT_ALERT = "Please read the alert information!";
        public const string PROMPT_ERROR = "Error occurred!";
    }
}
