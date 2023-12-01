package dev.patika.LMS.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book_borrowing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id", columnDefinition = "serial")
    private long id;

    @Column(name = "borrower_name", length = 50, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date", nullable = false)
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookborrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
