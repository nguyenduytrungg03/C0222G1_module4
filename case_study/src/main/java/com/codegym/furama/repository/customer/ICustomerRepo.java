package com.codegym.furama.repository.customer;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ICustomerRepo extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where status_delete <>1", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable p);

    @Modifying
    @Query(value = "insert into customer (code_customer,name_customer,birthday,gender,code_card,number_phone,email,address,status_delete,code_customer_type) " +
                   "values (:codeCustomer,:nameCustomer,:birthday,:gender,:codeCard,:numberPhone,:email,:address,0,:codeCustomerType) ", nativeQuery = true)
    void save(@Param("codeCustomer") String codeCustomer, @Param("nameCustomer") String nameCustomer, @Param("birthday") String birthday,@Param("gender") Integer gender
            ,@Param("codeCard") String codeCard,@Param("numberPhone") String numberPhone,@Param("email") String email, @Param("address") String address,@Param("codeCustomerType") Integer codeCustomerType);

    @Modifying
    @Query(value = "update customer set status_delete =1 where id_customer=:id", nativeQuery = true)
    void deleteById(@Param("id") Integer idCustomer);

    @Query(value = "select * from customer where id_customer =:id ", nativeQuery = true)
    Customer findByIdCustomer(@Param("id") Integer id);

    @Modifying
    @Query(value = "update customer set " +
            "code_customer=:codeCustomer," +
            "name_customer=:nameCustomer," +
            "birthday=:birthday," +
            "gender=:gender," +
            "code_card=:codeCard," +
            "number_phone=:numberPhone," +
            "email=:email," +
            "address=:address," +
            "code_customer_type=:codeCustomerType where id_customer=:id", nativeQuery = true)
    void updateCustomer(@Param("codeCustomer") String codeCustomer,
                        @Param("nameCustomer") String nameCustomer,
                        @Param("birthday") String birthday,
                        @Param("gender") Integer gender,
                        @Param("codeCard") String codeCard,
                        @Param("numberPhone") String numberPhone,
                        @Param("email") String email,
                        @Param("address") String address,
                        @Param("codeCustomerType") Integer codeCustomerType,
                        @Param("id") Integer id);

}
