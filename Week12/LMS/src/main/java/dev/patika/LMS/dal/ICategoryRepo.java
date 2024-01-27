package dev.patika.LMS.dal;

import dev.patika.LMS.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepo extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
