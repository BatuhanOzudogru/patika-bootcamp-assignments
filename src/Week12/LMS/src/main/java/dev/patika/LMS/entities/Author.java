package dev.patika.LMS.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial")
    private long id;

    @Column(name = "author_name", length = 50, nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "author_birth_date")
    private LocalDate birthDate;

    @Column(name = "author_country", length = 50)
    private String country;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book> bookList;
}
