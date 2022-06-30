package com.product.repository;

import com.product.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("select m from product m", Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.createQuery("select m from product m where id = ?1", Product.class).setParameter(1, id).getSingleResult();
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        String search = "select m from product m where m.name Like ?1";
        List<Product> products = BaseRepository.entityManager.createQuery(search, Product.class).setParameter(1, "%" + name + "%").getResultList();
        return products;
    }
}