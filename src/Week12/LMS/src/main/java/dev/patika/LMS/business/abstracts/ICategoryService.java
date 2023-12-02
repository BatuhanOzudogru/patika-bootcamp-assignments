package dev.patika.LMS.business.abstracts;

import dev.patika.LMS.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category getById (long id);

    Category create(Category category);
    String delete(long id);
    Category update(Long id, Category category);

    List<Category> findAll ();
}
