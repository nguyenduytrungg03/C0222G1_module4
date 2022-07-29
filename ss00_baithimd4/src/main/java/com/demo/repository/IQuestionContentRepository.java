package com.demo.repository;

import com.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    @Query(value = "select * from customer where status_delete =0", nativeQuery = true)
    Page<QuestionContent> findAllCustomer(Pageable p);

    @Modifying
    @Query(value = "update customer set status_delete =1 where id_customer=:id", nativeQuery = true)
    void deleteById(@Param("id") Integer idCustomer);


}
