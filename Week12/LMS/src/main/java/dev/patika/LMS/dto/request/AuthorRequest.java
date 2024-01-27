package dev.patika.LMS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    private String name;
    private String country;
    private LocalDate birthDate;
}
