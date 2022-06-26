package com.codegym.furama.service.customer;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Page<Customer> getAll(Pageable pageable);

    List<CustomerType> customerType();

    void save(Customer customer);

    Object findById(int id);

    void update(Customer customer);

    void remove(int id);

    Page<Customer> searchByName(String Customer,Pageable p);
}
