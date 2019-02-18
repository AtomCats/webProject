package com.webProject.webProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Objects;

@Entity
public class OrderProduct {

    @EmbeddedId
    @JsonIgnore
    private OrderProductPk pk;

    @Column(nullable = false)
    private Integer quantity;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, Integer quantity) {
        pk = new OrderProductPk();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity = quantity;
    }

    @Transient
    public Product getitem() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getitem().getPrice() * getQuantity();
    }

    public OrderProductPk getPk() {
        return pk;
    }

    public void setPk(OrderProductPk pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct orderProduct = (OrderProduct) o;
        return Objects.equals(pk, orderProduct.pk) &&
                Objects.equals(quantity, orderProduct.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pk, quantity);
    }
}
