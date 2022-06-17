package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(String id);

    List<Product> searchByName(String name);

    void update(Product product);

    void remove(String id);
}
