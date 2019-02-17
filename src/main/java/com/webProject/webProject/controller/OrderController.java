package com.webProject.webProject.controller;

import com.webProject.webProject.dto.OrderProductDto;
import com.webProject.webProject.model.Product;
import com.webProject.webProject.model.Order;
import com.webProject.webProject.model.OrderProduct;
import com.webProject.webProject.service.ProductService;
import com.webProject.webProject.service.OrderProductService;
import com.webProject.webProject.service.OrderService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

     ProductService productService;
     OrderService orderService;
     OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        // create order logic
        // populate order with products


        Order order = new Order();
        order.setStatus("Paid");
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getItemById(dto
                    .getProduct()
                    .getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> itemDtos) {
         Set<Product> missingProducts = itemDtos.stream()
                 .map(op -> op.getProduct())
                 .filter(item -> Objects.isNull(productService.getItemById(item.getId())))
                .collect(Collectors.toSet());

        if (!missingProducts.isEmpty()) {
            String missing =  missingProducts.stream().map(item -> item.getName()).collect(Collectors.joining()).toString();
            throw new IllegalArgumentException("Following items are not exist : " + missing);
        }
    }

    public static class OrderForm {

        private List<OrderProductDto> itemOrders;

        public List<OrderProductDto> getProductOrders() {
            return itemOrders;
        }

        public void setProductOrders(List<OrderProductDto> itemOrders) {
            this.itemOrders = itemOrders;
        }
    }
}
