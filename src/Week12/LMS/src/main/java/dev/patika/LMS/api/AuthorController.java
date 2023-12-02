package dev.patika.LMS.api;

import dev.patika.LMS.business.abstracts.IAuthorService;
import dev.patika.LMS.dto.request.AuthorRequest;
import dev.patika.LMS.dto.response.AuthorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> findAll(){
        List<AuthorResponse> authorResponseList = this.authorService.findAll().stream().map(
                author -> this.modelMapper.map(author, AuthorResponse.class)
        ).collect(Collectors.toList());
        return authorResponseList;
   }
//    @GetMapping("/authors/{id}/books")
//    @ResponseStatus(HttpStatus.OK)
//    public List<AuthorBookResponse> findAuthorsAllBooks(@PathVariable("id") long id){
//
//
//        return this.authorService.getById(id).getBookList().stream().map(
//                book -> this.modelMapper.map(book, AuthorBookResponse.class)).collect(Collectors.toList());
//
//    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponse save(@RequestBody AuthorRequest authorRequest) {
        return this.authorService.create(authorRequest);
    }
    @PutMapping("/authors/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse update(@PathVariable ("id") Long id,@RequestBody AuthorRequest authorUpdateRequest) {

        return this.authorService.update(id,authorUpdateRequest);
    }
    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse getById(@PathVariable("id") Long id) {

        return this.modelMapper.map(this.authorService.getById(id), AuthorResponse.class);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        this.authorService.delete(id);

    }



}
