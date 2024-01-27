package dev.patika.LMS.api;


import dev.patika.LMS.business.abstracts.IBookService;
import dev.patika.LMS.business.abstracts.IPublisherService;
import dev.patika.LMS.entities.Book;
import dev.patika.LMS.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll(){
        return this.bookService.findAll();
    }
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return this.bookService.create(book);
    }
    @PutMapping("/books/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@PathVariable ("id") Long id,@RequestBody Book book) {

        return this.bookService.update(id,book);
    }
    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getById(@PathVariable("id") Long id) {

        return this.bookService.getById(id);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        this.bookService.delete(id);

    }


}
