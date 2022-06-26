package com.codegym.furama.service.customer.impl;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.customer.ICustomerTypeRepo;
import com.codegym.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepo iCustomerTypeRepo;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepo.findAll();
    }
}
