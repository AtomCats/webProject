package com.webProject.webProject.service;

import com.webProject.webProject.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {
    @NotNull Iterable<Product> getAllItems();
    Product getItemById(@Min(value = 1L, message = "Invalid product ID.") long id);
    Product save(@NotNull @Valid Product product);
}
