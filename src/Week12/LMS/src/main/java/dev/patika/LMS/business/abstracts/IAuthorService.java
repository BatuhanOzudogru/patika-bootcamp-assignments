package dev.patika.LMS.business.abstracts;

import dev.patika.LMS.dto.request.AuthorRequest;
import dev.patika.LMS.dto.response.AuthorResponse;

import java.util.List;

public interface IAuthorService {
    AuthorResponse getById (long id);

    AuthorResponse create(AuthorRequest authorRequest);
    void delete(long id);
    AuthorResponse update(Long id, AuthorRequest authorUpdateRequest);

    List<AuthorResponse> findAll ();
}
