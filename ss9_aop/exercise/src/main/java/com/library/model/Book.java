package com.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer idBook;

    @Column(name = "name_book")
    private String nameBook;
    private String author;
    private String category;
    @Column(name = "meeting_date")
    private String meetingDate;
    private int amount;

    @OneToMany(mappedBy = "book")
    private Set<OrdBook> ordBooks;

    public Book() {
    }

    public Book(Integer idBook, String nameBook, String author, String category, String meetingDate, int amount, Set<OrdBook> ordBooks) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.author = author;
        this.category = category;
        this.meetingDate = meetingDate;
        this.amount = amount;
        this.ordBooks = ordBooks;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Set<OrdBook> getOrdBooks() {
        return ordBooks;
    }

    public void setOrdBooks(Set<OrdBook> ordBooks) {
        this.ordBooks = ordBooks;
    }
}
