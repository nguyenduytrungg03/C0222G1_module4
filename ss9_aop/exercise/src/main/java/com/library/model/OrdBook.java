package com.library.model;

import javax.persistence.*;

@Entity(name = "ord_book")
public class OrdBook {
    @Id
    @Column(name = "code_random")
    private Integer codeRandom;
    @Column(name = "name_ord")
    private String nameOrd;

    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    public OrdBook() {
    }

    public OrdBook(Integer codeRandom, String nameOrd, Book book) {
        this.codeRandom = codeRandom;
        this.nameOrd = nameOrd;
        this.book = book;
    }

    public OrdBook(Integer codeRandom, Book book) {
        this.codeRandom = codeRandom;
        this.book = book;
    }

    public Integer getCodeRandom() {
        return codeRandom;
    }

    public void setCodeRandom(Integer codeRandom) {
        this.codeRandom = codeRandom;
    }

    public String getNameOrd() {
        return nameOrd;
    }

    public void setNameOrd(String nameOrd) {
        this.nameOrd = nameOrd;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
