package dev.patika.LMS.api;


import dev.patika.LMS.business.abstracts.IBookService;
import dev.patika.LMS.business.concretes.BookBorrowingManager;
import dev.patika.LMS.dto.request.BookBorrowingRequest;
import dev.patika.LMS.dto.request.BookBorrowingUpdateRequest;
import dev.patika.LMS.entities.Book;
import dev.patika.LMS.entities.BookBorrowing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookBorrowingController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookBorrowingManager bookBorrowingManager;

    @GetMapping("/borrows")
    @ResponseStatus(HttpStatus.OK)
    public List<BookBorrowing> findAll(){
        return this.bookBorrowingManager.findAll();
    }
    @PostMapping("/borrows")
    @ResponseStatus(HttpStatus.CREATED)
    public BookBorrowing save(@RequestBody BookBorrowing bookBorrowing) {
        return this.bookBorrowingManager.create(bookBorrowing);
    }
    @PutMapping("/borrows/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowingUpdateRequest update(@PathVariable("id") Long id,@RequestBody BookBorrowing bookBorrowing) {

        return this.modelMapper.map(this.bookBorrowingManager.update(bookBorrowing), BookBorrowingUpdateRequest.class);
    }
    @GetMapping("/borrows/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing findById(@PathVariable("id") long id){
        return this.bookBorrowingManager.getById(id);
    }

    @DeleteMapping("/borrows/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        this.bookBorrowingManager.delete(id);

    }


}
