package dev.patika.LMS.api;


import dev.patika.LMS.business.abstracts.ICategoryService;
import dev.patika.LMS.business.abstracts.IPublisherService;
import dev.patika.LMS.entities.Category;
import dev.patika.LMS.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll(){
        return this.categoryService.findAll();
    }
    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return this.categoryService.create(category);
    }
    @PutMapping("/categories/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@PathVariable ("id") Long id,@RequestBody Category category) {

        return this.categoryService.update(id,category);
    }
    @GetMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category getById(@PathVariable("id") Long id) {

        return this.categoryService.getById(id);
    }

    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        this.categoryService.delete(id);

    }


}
