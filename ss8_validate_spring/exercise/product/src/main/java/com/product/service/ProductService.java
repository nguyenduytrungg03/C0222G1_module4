package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product.getName(), String.valueOf(product.getPrice()), product.getProducer(), product.getStatus(), product.getIdProduct());
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAllProduct();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAllProduct(pageable);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.searchByName("%" + name + "%", pageable);
    }
}
