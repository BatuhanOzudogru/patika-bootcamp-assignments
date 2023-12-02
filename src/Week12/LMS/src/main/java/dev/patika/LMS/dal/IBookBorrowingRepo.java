package dev.patika.LMS.dal;

import dev.patika.LMS.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IBookBorrowingRepo extends JpaRepository<BookBorrowing,Long> {

    Optional<BookBorrowing> findByNameAndBorrowingDate(String name, LocalDate borrowingDate);
}
