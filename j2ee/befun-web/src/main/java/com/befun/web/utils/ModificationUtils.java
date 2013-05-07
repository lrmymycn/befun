package com.befun.web.utils;

import org.hibernate.criterion.Order;

import com.befun.dao.common.QueryCondition;
import com.befun.service.query.QCUtils;

public class ModificationUtils {

    private static final String PROP_CREATION_DATE = "modification.creationDate";

    private static final String PROP_LAST_MODIFIED_DATE = "modification.lastModifiedDate";

    public static void setDefaultOrder(QueryCondition qc) {
        String lastModifiedDateProp = QCUtils.generatePropertyName(qc.getSelfAlias(), PROP_LAST_MODIFIED_DATE);
        qc.getOrderBy().add(Order.desc(lastModifiedDateProp));
        String creationDateProp = QCUtils.generatePropertyName(qc.getSelfAlias(), PROP_CREATION_DATE);
        qc.getOrderBy().add(Order.desc(creationDateProp));
    }
}
