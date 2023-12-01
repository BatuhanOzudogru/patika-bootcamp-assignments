package dev.patika.LMS.business.concretes;

import dev.patika.LMS.business.abstracts.IAuthorService;
import dev.patika.LMS.dal.IAuthorRepo;
import dev.patika.LMS.dto.request.AuthorRequest;
import dev.patika.LMS.dto.request.AuthorUpdateRequest;
import dev.patika.LMS.dto.response.AuthorResponse;
import dev.patika.LMS.entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorManager implements IAuthorService {

    @Autowired
    private IAuthorRepo authorRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AuthorResponse getById(long id) {
        Author author =authorRepo.findById(id).orElseThrow();
        return this.modelMapper.map(author, AuthorResponse.class);
    }

    @Override
    public AuthorResponse create(AuthorRequest authorRequest) {
        //     5.İD       adı  A  country TR date 10
        //                ADI  A  country TR DATE 11    CREATE
        Optional<Author> isAuthorExist = authorRepo.findByNameAndBirthDateAndCountry
                (authorRequest.getName(), authorRequest.getBirthDate(), authorRequest.getCountry());
        if(isAuthorExist.isPresent()){
            throw new RuntimeException("BU YAZAR DAHA ÖNCE OLUŞTURULMUŞ");
        }

            Author newAuthor = authorRepo.save(this.modelMapper.map(authorRequest, Author.class));
            return this.modelMapper.map(newAuthor, AuthorResponse.class);
//        if (isAuthorExist.isEmpty()){
//            Author newAuthor = authorRepo.save(this.modelMapper.map(authorRequest, Author.class));
//            return this.modelMapper.map(newAuthor, AuthorResponse.class);
//        }
//        throw new RuntimeException("BU YAZAR DAHA ÖNCE OLUŞTURULMUŞ");


    }

//    @Override
//    public void delete(long id) {
//        if(this.getById(id).getBookList().isEmpty()){
//            this.authorRepo.delete(this.getById(id));
//            throw new RuntimeException("işlem başarılı");
//          //  return "işlem başarılı";
//        }else {
//            throw new RuntimeException("bu yazara ait bir kitap var. bu yazar silinemedi");
//           // return "bu yazara ait bir kitap var. bu yazar silinemedi";
//        }
//
//    }
    @Override
    public void delete(long id){
        Optional<Author> authorFromDb = authorRepo.findById(id);
        if(authorFromDb.isPresent()){
            authorRepo.delete(authorFromDb.get());
        }else{
            throw new RuntimeException(id + "id li yazar sistemle bulunamadı.");
        }
    }

    @Override
    public AuthorResponse update(Long id, AuthorUpdateRequest authorUpdateRequest) {
        // 5.id           adı  Atacan  country TR date 10
        //                ADI  A  country TR DATE 10    UPDATE

        Optional<Author> authorFromDb = authorRepo.findById(id);

        Optional<Author> isAuthorExist = authorRepo.findByNameAndBirthDateAndCountry
                (authorUpdateRequest.getName(), authorUpdateRequest.getBirthDate(), authorUpdateRequest.getCountry());
        if(authorFromDb.isEmpty()){
            throw new RuntimeException("Güncellemeye calıştığınız yazar sistemde bulunamadı");
        }
        if(isAuthorExist.isPresent()){
            throw new RuntimeException("bu yazar daha önce sisteme kayıt olmuş ");
        }
        Author updatedAuthor = authorFromDb.get();
        updatedAuthor.setBirthDate(authorUpdateRequest.getBirthDate());
        updatedAuthor.setName(authorUpdateRequest.getName());
        updatedAuthor.setCountry(authorUpdateRequest.getCountry());

        return this.modelMapper.map(this.authorRepo.save(updatedAuthor),AuthorResponse.class);


      //  Author yeniAtacan= this.authorRepo.save((this.modelMapper.map(authorUpdateRequest, Author.class)));
        //return this.modelMapper.map(yeniAtacan, AuthorResponse.class);


/*
        Author newAuthor = authorRepo.save(this.modelMapper.map(authorRequest, Author.class));
        return this.modelMapper.map(newAuthor, AuthorResponse.class);
         Author author = authorFromDb.get();
        authorMapper.update(author, request);
        return authorMapper.asOutput(authorRepository.save(author));*/
    }

    @Override
    public List<AuthorResponse> findAll() {
        List<AuthorResponse> authorResponseList = this.authorRepo.findAll().stream().map(
                author -> this.modelMapper.map(author, AuthorResponse.class)
        ).collect(Collectors.toList());
        return authorResponseList;
    }

}
