package com.codegym.furama.service.customer.impl;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.customer.ICustomerRepo;
import com.codegym.furama.repository.customer.ICustomerTypeRepo;
import com.codegym.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Autowired
    private ICustomerTypeRepo iCustomerTypeRepo;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return iCustomerRepo.findAllCustomer(pageable);
    }

    @Override
    public List<CustomerType> customerType() {
        return iCustomerTypeRepo.findAll();
    }


    @Override
    public void save(Customer customer) {
        iCustomerRepo.save(customer);
    }

    @Override
    public Object findById(int id) {
        return iCustomerRepo.findByIdCustomer(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepo.updateCustomer(customer.getCodeCustomer(),
                customer.getName(),
                customer.getBirthday(),
                customer.getGender(),
                customer.getCodeCard(),
                customer.getNumberPhone(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getCustomerType().getCodeCustomerType(),
                customer.getIdCustomer());
    }

    @Override
    public void remove(int id) {
        iCustomerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> searchByName(String Customer, Pageable p) {
        return null;
    }
}
