package dev.patika.LMS.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id",columnDefinition = "serial")
    private long id ;

    @Column(name = "category_name",length = 50,nullable = false)
    private String name;

    @Column(name ="category_description")
    private String description;

    @ManyToMany(mappedBy = "categoryList")
    @JsonIgnore
    private List<Book> bookList;

}
