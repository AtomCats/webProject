package com.webProject.webProject.service;

import com.webProject.webProject.model.Order;

public interface OrderService {
    public Iterable<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order);
}
