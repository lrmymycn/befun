package com.befun.dao.common;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class OrderBy {

    private Map<String, Order> orders = new HashMap<String, Order>();

    public void add(Order order) {
        orders.put(order.getPropertyName(), order);
    }

    public void remove(String propertyName) {
        orders.remove(propertyName);
    }

    public void build(Criteria criteria) {
        for (Order order : orders.values()) {
            criteria.addOrder(order);
        }
    }
}
