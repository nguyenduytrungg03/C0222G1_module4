package com.library.repository;

import com.library.model.OrdBook;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IOrdRepository extends JpaRepository<OrdBook, Integer> {
OrdBook findByCodeRandom(Integer codeRandom);

}
