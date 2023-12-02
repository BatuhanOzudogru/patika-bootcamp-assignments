package dev.patika.LMS.business.abstracts;

import dev.patika.LMS.entities.Book;

import java.util.List;

public interface IBookService {
    Book getById (long id);

    Book create(Book book);
    void delete(long id);
    Book update(Long id, Book book);

    List<Book> findAll ();
}
