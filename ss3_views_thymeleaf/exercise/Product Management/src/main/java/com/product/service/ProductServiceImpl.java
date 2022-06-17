package com.product.service;

import com.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static final List<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product("AI-11", "Iphon12", 30000, "Hàng new", "100%"));
        listProduct.add(new Product("BI-12", "IphonX", 1000, "Hàng xách tay", "85%"));
        listProduct.add(new Product("CI-13", "SamSung note10+", 2500, "Hơi cũ", "88%"));
    }

    @Override
    public List<Product> findAll() {
        return listProduct;
    }

    @Override
    public void save(Product product) {
        listProduct.add(product);
    }

    @Override
    public Product findById(String id) {
        for (Product item : listProduct) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product item : listProduct) {
            if (item.getName().contains(name)) {
                productList.add(item);
            }
        }
        return productList;
    }


    @Override
    public void update(Product product) {
        for (Product item : listProduct) {
            if (item.getId().equals(product.getId())) {
                item.setName(product.getName());
                item.setPrice(product.getPrice());
                item.setDescribe(product.getDescribe());
                item.setNote(product.getNote());
            }
        }
    }

    @Override
    public void remove(String id) {
        listProduct.removeIf(item -> item.getId().equals(id));
    }
}
