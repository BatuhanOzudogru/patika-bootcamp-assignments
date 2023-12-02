package dev.patika.LMS.business.concretes;

import dev.patika.LMS.business.abstracts.IAuthorService;
import dev.patika.LMS.business.abstracts.IBookService;
import dev.patika.LMS.dal.IAuthorRepo;
import dev.patika.LMS.dal.IBookRepo;
import dev.patika.LMS.dto.request.AuthorRequest;
import dev.patika.LMS.dto.response.AuthorResponse;
import dev.patika.LMS.entities.Author;
import dev.patika.LMS.entities.Book;
import dev.patika.LMS.entities.Publisher;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookManager implements IBookService {

    @Autowired
    private IBookRepo bookRepo;

    @Override
    public Book getById(long id) {
        return this.bookRepo.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Book create(Book book) {
        Optional<Book> isBookExist = this.bookRepo.findByNameAndAuthor(book.getName(), book.getAuthor());

        if(isBookExist.isPresent()){
            throw new RuntimeException("BU KİTAP DAHA ÖNCE OLUŞTURULMUŞ");
        }

        return this.bookRepo.save(book);
    }

    @Override
    public void delete(long id) {
        Optional<Book> bookFromDb = bookRepo.findById(id);
        if(bookFromDb.isPresent()){
            this.bookRepo.delete(bookFromDb.get());
        }else{
            throw new RuntimeException(id + "id li kitap sistemle bulunamadı.");
        }
    }

    @Override
    public Book update(Long id, Book book) {
        Optional<Book> bookFromDb = this.bookRepo.findById(id);

        Optional<Book> isBookExist = this.bookRepo.findByNameAndAuthor(book.getName(), book.getAuthor());

        if(bookFromDb.isEmpty()){
            throw new RuntimeException("Güncellemeye calıştığınız kitap sistemde bulunamadı");
        }
//        if(isBookExist.isPresent()){
//            throw new RuntimeException("bu kitap daha önce sisteme kayıt olmuş ");
//        }
        Book updatedBook = bookFromDb.get();
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setPublicationYear(book.getPublicationYear());
        updatedBook.setStock(book.getStock());
        updatedBook.setPublisher(book.getPublisher());

        return this.bookRepo.save(updatedBook);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepo.findAll();
    }

//    public List<Book> findByCategoryId(Long id) {
//        return this.bookRepo.findByCategoryId(id);
//    }
}
