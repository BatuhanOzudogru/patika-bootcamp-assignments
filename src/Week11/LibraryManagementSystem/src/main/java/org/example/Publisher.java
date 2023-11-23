package org.example;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", columnDefinition = "serial")
    private long id;

    @Column(name = "publisher_name", length = 50, nullable = false)
    private String name;


    @Column(name = "publisher_establishmentYear")
    private int establishmentYear;

    @Column(name = "publisher_address",length = 100)
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> bookList;

    public Publisher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", establishmentYear=" + establishmentYear +
                ", address='" + address + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
