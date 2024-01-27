package dev.patika.LMS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    private long id;
    private String name;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
}
