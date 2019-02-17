package com.webProject.webProject.repository;

import com.webProject.webProject.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {}
