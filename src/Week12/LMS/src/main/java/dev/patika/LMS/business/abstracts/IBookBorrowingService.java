package dev.patika.LMS.business.abstracts;

import dev.patika.LMS.dto.request.BookBorrowingRequest;
import dev.patika.LMS.dto.request.BookBorrowingUpdateRequest;
import dev.patika.LMS.dto.request.BookForBorrowingRequest;
import dev.patika.LMS.entities.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing getById (long id);
    BookBorrowing create(BookBorrowing bookBorrowing);
    void delete(long id);
    BookBorrowing update(BookBorrowing bookBorrowing);

    List<BookBorrowing> findAll ();

}
