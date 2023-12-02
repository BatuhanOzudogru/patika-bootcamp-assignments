package dev.patika.LMS.business.concretes;

import dev.patika.LMS.business.abstracts.IBookBorrowingService;
import dev.patika.LMS.dal.IBookBorrowingRepo;
import dev.patika.LMS.dal.IBookRepo;
import dev.patika.LMS.dto.request.BookBorrowingRequest;
import dev.patika.LMS.dto.request.BookBorrowingUpdateRequest;
import dev.patika.LMS.dto.response.AuthorResponse;
import dev.patika.LMS.entities.Author;
import dev.patika.LMS.entities.Book;
import dev.patika.LMS.entities.BookBorrowing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookBorrowingManager implements IBookBorrowingService {
    @Autowired
    private IBookBorrowingRepo bookBorrowingRepo;

    @Autowired
    private BookManager bookManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IBookRepo bookRepo;


    @Override
    public BookBorrowing getById(long id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow();
    }



    @Override
    public BookBorrowing create(BookBorrowing bookBorrowing) { //bir kitabın ödünç verilme senaryosu.
        Book book = this.bookRepo.findById(bookBorrowing.getBook().getId()).orElseThrow();
        if (book.getStock() > 0) {
            book.setStock(book.getStock()-1);
            bookManager.update(bookBorrowing.getBook().getId(),book);
            return this.bookBorrowingRepo.save(bookBorrowing);
        } else {
            throw new RuntimeException("Kitabın Stoğu Bulunamamıştır.");
        }
    }
//    @Override
//    public BookBorrowing update(long id,BookBorrowingUpdateRequest borrowingUpdateRequest,BookBorrowing bookBorrowing) {
//        Optional<BookBorrowing> bookBorrowingFromDb = bookBorrowingRepo.findById(id);
//
//        Book book = this.bookRepo.findById(bookBorrowing.getBook().getId()).orElseThrow();
//        if(bookBorrowingFromDb.isEmpty()){
//            throw new RuntimeException("hata");
//        }
//        BookBorrowing updatedBookBorrowing = bookBorrowingFromDb.get();
//        updatedBookBorrowing.setName(borrowingUpdateRequest.getName());
//        updatedBookBorrowing.setBorrowingDate(borrowingUpdateRequest.getBorrowingDate());
//        updatedBookBorrowing.setReturnDate(borrowingUpdateRequest.getReturnDate());
//
//        if (bookBorrowing.getReturnDate() != null) {
//            book.setStock(book.getStock() + 1);
//            bookManager.update(book.getId(), book);
//        }
//
//
//
//        return updatedBookBorrowing;
//    }
@Override
public BookBorrowing update(BookBorrowing bookBorrowing) {
    Book book = this.bookRepo.findById(bookBorrowing.getBook().getId()).orElseThrow();
    if (book.getStock() >= 0) {
        book.setStock(book.getStock()+1);
        bookManager.update(bookBorrowing.getBook().getId(),book);
    }
    return this.bookBorrowingRepo.save(bookBorrowing);
}


//    @Override
//    public BookBorrowing create(long id, BookBorrowingRequest bookBorrowingRequest) {
//
//        Optional<BookBorrowing> isBorrowingExist = bookBorrowingRepo.findByNameAndBorrowingDate
//                (bookBorrowingRequest.getName(),bookBorrowingRequest.getBorrowingDate());
//        Book book = bookRepo.getById(id);
//
//
//
//
//        if (book.getStock() <= 0) {
//            throw new RuntimeException("Ödünç almak istediğiniz kitabın stoğu yoktur !!!");
//        }
//
//
//        BookBorrowing bookBorrowing = new BookBorrowing();
//
//        bookBorrowing.setName( bookBorrowingRequest.getName() );
//        bookBorrowing.setBorrowingDate( bookBorrowingRequest.getBorrowingDate() );
//
//
//        book.setStock(book.getStock() - 1);
//
//        Book bookUpdated = bookManager.update(id, book);
//        bookBorrowing.setBook(bookUpdated);
//        return this.bookBorrowingRepo.save(bookBorrowing);
//
//    }

    @Override
    public void delete(long id) {
        Optional<BookBorrowing> bookBorrowingFromDb = bookBorrowingRepo.findById(id);
        if(bookBorrowingFromDb.isPresent()){
            BookBorrowing bookBorrowing = bookBorrowingFromDb.get();
            if (bookBorrowing.getReturnDate() == null) {
                Book book = bookBorrowing.getBook();
                book.setStock(book.getStock() + 1);
                Book bookUpdated = bookManager.update(bookBorrowing.getBook().getId(), book);
                bookBorrowing.setBook(bookUpdated);
            }
            bookBorrowingRepo.delete(bookBorrowing);
        }else{
            throw new RuntimeException(id + "id li yazar sistemde bulunamadı.");
        }
    }





    @Override
    public List<BookBorrowing> findAll() {
        return this.bookBorrowingRepo.findAll();
    }
}
