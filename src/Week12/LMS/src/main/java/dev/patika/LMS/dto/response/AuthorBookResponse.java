package dev.patika.LMS.dto.response;

import dev.patika.LMS.entities.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBookResponse {
    private String name;
    private int stock;
    private int publicationYear;
}
