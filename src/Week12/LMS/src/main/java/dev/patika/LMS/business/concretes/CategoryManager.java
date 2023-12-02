package dev.patika.LMS.business.concretes;

import dev.patika.LMS.business.abstracts.ICategoryService;
import dev.patika.LMS.dal.ICategoryRepo;
import dev.patika.LMS.entities.Category;

import dev.patika.LMS.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManager implements ICategoryService {
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public Category getById(long id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public Category create(Category category) {
        Optional<Category> isCategoryExist = categoryRepo.findByName(category.getName());

        if(isCategoryExist.isPresent()){
            throw new RuntimeException("BU KATEGORİ DAHA ÖNCE OLUŞTURULMUŞ");
        }
        Category newCategory = categoryRepo.save(category);
        return newCategory;
    }

    @Override
    public String delete(long id) {
        if(this.getById(id).getBookList().isEmpty()){
            this.categoryRepo.delete(this.getById(id));

              return "işlem başarılı";
        }else {
            throw new RuntimeException("bu kategoriye ait bir kitap var. bu kategori silinemedi");

        }

    }

    @Override
    public Category update(Long id, Category category) {
        Optional<Category> categoryFromDb = categoryRepo.findById(id);

        Optional<Category> isCategoryExist = categoryRepo.findByName(category.getName());
        if(categoryFromDb.isEmpty()){
            throw new RuntimeException("Güncellemeye calıştığınız kategori sistemde bulunamadı");
        }
        if(isCategoryExist.isPresent()){
            throw new RuntimeException("bu kategori daha önce sisteme kayıt olmuş ");
        }
        Category updatedCategory = categoryFromDb.get();
        updatedCategory.setName(category.getName());
        updatedCategory.setDescription(category.getDescription());

        return this.categoryRepo.save(updatedCategory);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }
}
