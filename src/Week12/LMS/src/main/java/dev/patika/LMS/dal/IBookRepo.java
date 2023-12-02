package dev.patika.LMS.dal;


import dev.patika.LMS.entities.Author;
import dev.patika.LMS.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBookRepo extends JpaRepository<Book,Long> {
    Optional<Book> findByNameAndAuthor(String name, Author author);

//    @Query("SELECT b FROM Book b JOIN b.categories c WHERE c.id = :categoryId")
//    List<Book> findByCategoryId(Long categoryId);
}
