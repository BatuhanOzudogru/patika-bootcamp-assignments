package dev.patika.LMS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForBorrowingRequest {
    private Long id;
    private String name;
    private int publicationYear;
    private int stock;
}
