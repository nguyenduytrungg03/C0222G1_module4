package com.library.service;

import com.library.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void update(Book book);
}
