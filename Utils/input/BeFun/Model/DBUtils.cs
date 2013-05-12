using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;

namespace BeFun.Model
{
    public class DBUtils
    {
        public static string GenerateId(string pre)
        {
            return pre + "_" + System.Guid.NewGuid().ToString();
        }
        public static string GenerateProjectId()
        {
            return GenerateId("pro");
        }

        public static string GenerateStageId()
        {
            return GenerateId("st");
        }

        public static string GenerateBuildingId()
        {
            return GenerateId("bd");
        }

        public static string GenerateFloorplanId()
        {
            return GenerateId("fp");
        }

        public static string GenerateApartmentId()
        {
            return GenerateId("ap");
        }

        public static string GenerateMediaId()
        {
            return GenerateId("md");
        }

        public static string GeneratePOIId()
        {
            return GenerateId("poi");
        }

        public static Int32 GetInt32FromRow(DataRow row, string columnName)
        {
            if (!(row[columnName] is System.DBNull))
            {
                return -1;
            }
            return (Int32)row[columnName];
        }
    }
}
