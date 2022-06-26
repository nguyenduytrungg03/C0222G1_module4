package com.codegym.furama.model.customer;

import javax.persistence.*;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int idCustomer;
    @Column(name = "code_customer")
    private String codeCustomer;

    @Column(name = "name_customer")
    private String name;
    private String birthday;
    private int gender;

    @Column(name = "code_card")
    private String codeCard;

    @Column(name = "number_phone")
    private String numberPhone;
    private String email;
    private String address;

    @Column(name = "status_delete")
    private int statusDelete;
    @ManyToOne
    @JoinColumn(name = "code_customer_type")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(int idCustomer,
                    String codeCustomer,
                    String name,
                    String birthday,
                    int gender,
                    String codeCard,
                    String numberPhone,
                    String email,
                    String address,
                    int statusDelete,
                    CustomerType customerType) {
        this.idCustomer = idCustomer;
        this.codeCustomer = codeCustomer;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.codeCard = codeCard;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.statusDelete = statusDelete;
        this.customerType = customerType;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCodeCard() {
        return codeCard;
    }

    public void setCodeCard(String codeCard) {
        this.codeCard = codeCard;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
