package dev.patika.LMS.api;


import dev.patika.LMS.business.abstracts.IPublisherService;
import dev.patika.LMS.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PublisherController {
    @Autowired
    private IPublisherService publisherService;

    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> findAll(){
        List<Publisher> publisherList = this.publisherService.findAll();
        return publisherList;
    }
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher) {
        return this.publisherService.create(publisher);
    }
    @PutMapping("/publishers/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@PathVariable ("id") Long id,@RequestBody Publisher publisher) {

        return this.publisherService.update(id,publisher);
    }
    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getById(@PathVariable("id") Long id) {

        return this.publisherService.getById(id);
    }

    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        this.publisherService.delete(id);

    }


}
