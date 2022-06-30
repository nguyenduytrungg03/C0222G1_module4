package com.product.service;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service
    public class ProductService implements IProductService {
        private static List<Product> productList = new ArrayList<>();

        @Autowired
        private IProductRepository iProductRepository;

        @Override
        public List<Product> findAll() {
            return iProductRepository.findAll();
        }

        @Override
        public void save(Product product) {
            iProductRepository.save(product);
        }

        @Override
        public Product findById(int id) {
            return iProductRepository.findById(id);
        }

        @Override
        public void update(Product product) {
            iProductRepository.update(product);
        }

        @Override
        public void remove(int id) {
            iProductRepository.remove(id);
        }

        @Override
        public List<Product> searchByName(String name) {
            return iProductRepository.searchByName(name);
        }
    }

