package dev.patika.LMS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private long id;
    private String name;
    private String country;
    private LocalDate birthDate;
}
