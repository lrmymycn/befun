using System.Collections.Generic;
using BeFun.Model.Domain;

namespace BeFun.Model
{
    public class PaginationBean<T> where T : BaseModel
    {
        public long totalCount { get; set; }

        public long pageSize { get; set; }

        public long pageNum { get; set; }

        public IList<T> results { get; set; }

        public long getStartIndex()
        {
            long tmp = this.pageSize * (pageNum - 1);
            if (tmp > totalCount)
            {
                tmp = totalCount;
            }
            return tmp;
        }

        public long getEndIndex()
        {
            long tmp = this.pageSize * pageNum;
            if (tmp > totalCount)
            {
                tmp = totalCount;
            }
            return tmp;
        }
    }
}
