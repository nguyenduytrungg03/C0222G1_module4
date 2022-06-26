package com.codegym.furama.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_customer_type")
    private Integer codeCustomerType;

    @Column(name = "customer_type_name")
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType() {
    }

    public Integer getCodeCustomerType() {
        return codeCustomerType;
    }

    public void setCodeCustomerType(Integer codeCustomerType) {
        this.codeCustomerType = codeCustomerType;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public CustomerType(Integer codeCustomerType, String customerTypeName) {
        this.codeCustomerType = codeCustomerType;
        this.customerTypeName = customerTypeName;
    }

    public Integer getCustomerTypeId() {
        return codeCustomerType;
    }

    public void setCustomerTypeId(Integer codeCustomerType) {
        this.codeCustomerType = codeCustomerType;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
