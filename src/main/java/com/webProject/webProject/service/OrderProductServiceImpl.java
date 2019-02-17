package com.webProject.webProject.service;

import com.webProject.webProject.model.OrderProduct;
import com.webProject.webProject.repository.OrderProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {
    private OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }
}
