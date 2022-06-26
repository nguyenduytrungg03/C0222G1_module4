package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerTypeRepo extends JpaRepository<CustomerType, Integer> {
}
