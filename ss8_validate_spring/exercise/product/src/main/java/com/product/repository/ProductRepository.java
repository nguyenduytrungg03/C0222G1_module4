package com.product.repository;

import com.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product", nativeQuery = true)
    List<Product> findAllProduct();

    @Query(value = "select * from product", nativeQuery = true)
    Page<Product> findAllProduct(Pageable pageable);


    @Modifying
    @Query(value = "insert into prodcut(`name`,price,producer,status) value(:name,:price,:producer,:status) ", nativeQuery = true)
    void save(@Param("name") String name, @Param("price") String price, @Param("producer") String producer, @Param("status") String status);

    @Query(value = " select  * from product where id_product = :id", nativeQuery = true)
    Product findById(@Param("id") int id);

    @Modifying
    @Query(value = "update product set name =:name,price=:price, producer =:producer, status =:status where id_product =:id", nativeQuery = true)
    void update(@Param("name") String name, @Param("price") String price, @Param("producer") String producer, @Param("status") String status, @Param("id") Integer idProduct);


    @Modifying
    @Query(value = "delete from product where id_product =:idProduct", nativeQuery = true)
    void remove(@Param("idProduct") Integer idProduct);

    @Query(value = "select * from product where `name` Like :name", nativeQuery = true)
    Page<Product> searchByName(@Param("name") String name, Pageable pageable);
}
