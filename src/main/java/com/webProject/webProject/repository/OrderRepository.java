package com.webProject.webProject.repository;

import com.webProject.webProject.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {}
