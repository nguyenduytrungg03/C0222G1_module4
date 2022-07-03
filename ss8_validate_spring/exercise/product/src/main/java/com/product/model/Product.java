package com.product.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;
    @NotBlank(message = "Bạn phải nhập trường này!")
    private String name;
    @NotNull(message = "Nhập giá trị")
    private double price;
    @NotBlank(message = "Bạn phải nhập trường này!")
    private String status;
    @NotBlank(message = "Bạn phải nhập trường này!")
    private String producer;

    public Product() {
    }

    public Product(Integer idProduct, @NotBlank(message = "Bạn phải nhập trường này!") String name,
                   @NotNull(message = "Nhập giá trị") double price,
                   @NotBlank(message = "Bạn phải nhập trường này!") String status,
                   @NotBlank(message = "Bạn phải nhập trường này!") String producer) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.status = status;
        this.producer = producer;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}