package dev.patika.LMS.dal;

import dev.patika.LMS.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPublisherRepo extends JpaRepository<Publisher,Long> {
    Optional<Publisher> findByNameAndEstablishmentYearAndAddress(String name, Integer year,String address);
}
