package com.library.service;

import com.library.model.Book;
import com.library.model.OrdBook;

import java.util.List;

public interface IOrdBookService {
    List<OrdBook> findAll();

    void save(OrdBook ordBook);

    OrdBook findById(Integer codeRandom );

    void remove(OrdBook ordBook);
}
