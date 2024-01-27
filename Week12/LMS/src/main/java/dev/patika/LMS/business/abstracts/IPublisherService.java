package dev.patika.LMS.business.abstracts;



import dev.patika.LMS.entities.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher getById (long id);

    Publisher create(Publisher publisher);
    void delete(long id);
    Publisher update(Long id, Publisher publisher);

    List<Publisher> findAll ();
}
