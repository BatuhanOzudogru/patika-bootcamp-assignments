package dev.patika.LMS.business.concretes;

import dev.patika.LMS.business.abstracts.IPublisherService;
import dev.patika.LMS.dal.IPublisherRepo;
import dev.patika.LMS.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherManager implements IPublisherService {
    @Autowired
    private IPublisherRepo publisherRepo;

    @Override
    public Publisher getById(long id) {
        return publisherRepo.findById(id).orElseThrow();
    }

    @Override
    public Publisher create(Publisher publisher) {
        Optional<Publisher> isPublisherExist = publisherRepo.findByNameAndEstablishmentYearAndAddress
                (publisher.getName(), publisher.getEstablishmentYear(), publisher.getAddress());
        if(isPublisherExist.isPresent()){
            throw new RuntimeException("BU YAYINEVİ DAHA ÖNCE OLUŞTURULMUŞ");
        }
        Publisher newPublisher = publisherRepo.save(publisher);
        return newPublisher;
    }

    @Override
    public void delete(long id) {
        Optional<Publisher> publisherFromDb = publisherRepo.findById(id);
        if(publisherFromDb.isPresent()){
            publisherRepo.delete(publisherFromDb.get());
        }else{
            throw new RuntimeException(id + "id li yayınevi sistemle bulunamadı.");
        }
    }

    @Override
    public Publisher update(Long id, Publisher publisher) {
        Optional<Publisher> publisherFromDb = publisherRepo.findById(id);

        Optional<Publisher> isPublisherExist = publisherRepo.findByNameAndEstablishmentYearAndAddress
                (publisher.getName(), publisher.getEstablishmentYear(), publisher.getAddress());
        if(publisherFromDb.isEmpty()){
            throw new RuntimeException("Güncellemeye calıştığınız yayınevi sistemde bulunamadı");
        }
        if(isPublisherExist.isPresent()){
            throw new RuntimeException("bu yayınevi daha önce sisteme kayıt olmuş ");
        }
        Publisher updatedPublisher = publisherFromDb.get();
        updatedPublisher.setName(publisher.getName());
        updatedPublisher.setEstablishmentYear(publisher.getEstablishmentYear());
        updatedPublisher.setAddress(publisher.getAddress());

        return this.publisherRepo.save(updatedPublisher);
    }

    @Override
    public List<Publisher> findAll() {
        List<Publisher> publisherList= this.publisherRepo.findAll();
        return publisherList;
    }
}
