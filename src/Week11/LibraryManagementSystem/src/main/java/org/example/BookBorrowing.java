package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book_borrowing")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id", columnDefinition = "serial")
    private long id;

    @Column(name = "borrower_name", length = 50, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date",nullable = false)
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookborrowing_book_id",referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookBorrowing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                ", book=" + book +
                '}';
    }
}
