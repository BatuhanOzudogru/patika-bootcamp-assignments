package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Author author1 = new Author();
            author1.setName("Sait Faik ABASIYANIK");
            author1.setCountry("Türkiye");
            author1.setBirthDate(LocalDate.parse("1906-11-22"));
            entityManager.persist(author1);

            Author author2 = new Author();
            author2.setName("Franz Kafka");
            author2.setCountry("Çekya");
            author2.setBirthDate(LocalDate.parse("1883-07-03"));
            entityManager.persist(author2);

            Author author3 = new Author();
            author3.setName("Paulo Coelho");
            author3.setCountry("Brezilya");
            author3.setBirthDate(LocalDate.parse("1947-08-24"));
            entityManager.persist(author3);
            ////////////////////////////////////////////
            Category category1 = new Category();
            category1.setName("Düşünce");
            category1.setDescription("Burayı null yapabiliriz.");
            entityManager.persist(category1);

            Category category2 = new Category();
            category2.setName("Edebiyat");
            category2.setDescription("Burayı null yapabiliriz.");
            entityManager.persist(category2);

            ////////////////////////////////////////////

            Publisher publisher1 = new Publisher();
            publisher1.setName("A Yayınevi");
            publisher1.setAddress("Alibeyköy");
            publisher1.setEstablishmentYear(1997);
            entityManager.persist(publisher1);

            Publisher publisher2 = new Publisher();
            publisher2.setName("B Yayınevi");
            publisher2.setAddress("Beykoz");
            publisher2.setEstablishmentYear(2000);
            entityManager.persist(publisher2);

            ////////////////////////////////////////////

            Book book1 = new Book();
            book1.setName("Semaver");
            book1.setAuthor(author1);
            book1.setPublicationYear(1936);
            book1.setStock(5);
            book1.setPublisher(publisher2);
            List<Category> categoryList1 = new ArrayList<>();
            categoryList1.add(category1);
            categoryList1.add(category2);
            book1.setCategoryList(categoryList1);
            entityManager.persist(book1);

            Book book2 = new Book();
            book2.setName("Dönüşüm");
            book2.setPublicationYear(1915);
            book2.setAuthor(author2);
            book2.setStock(7);
            book2.setPublisher(publisher2);
            List<Category> categoryList2 = new ArrayList<>();
            categoryList2.add(category2);
            book2.setCategoryList(categoryList2);
            entityManager.persist(book2);

            Book book3 = new Book();
            book3.setName("Simyacı");
            book3.setPublicationYear(1988);
            book3.setAuthor(author3);
            book3.setStock(15);
            book3.setPublisher(publisher2);
            List<Category> categoryList3 = new ArrayList<>();
            categoryList2.add(category1);
            book3.setCategoryList(categoryList3);
            entityManager.persist(book3);

            ////////////////////////////////////////////

            BookBorrowing bookBorrowing1 = new BookBorrowing();
            bookBorrowing1.setName("Sinan");
            bookBorrowing1.setBook(book2);
            bookBorrowing1.setBorrowingDate(LocalDate.parse("2023-11-23"));
            bookBorrowing1.setReturnDate(LocalDate.parse("2023-11-30"));
            entityManager.persist(bookBorrowing1);

            BookBorrowing bookBorrowing2 = new BookBorrowing();
            bookBorrowing2.setName("Atacan");
            bookBorrowing2.setBook(book2);
            bookBorrowing2.setBorrowingDate(LocalDate.parse("2023-10-23"));
            bookBorrowing2.setReturnDate(LocalDate.parse("2023-10-30"));
            entityManager.persist(bookBorrowing2);

            BookBorrowing bookBorrowing3 = new BookBorrowing();
            bookBorrowing3.setName("Batuhan");
            bookBorrowing3.setBook(book1);
            bookBorrowing3.setBorrowingDate(LocalDate.parse("2023-09-23"));
            //bookBorrowing3.setReturnDate(LocalDate.parse(""));
            entityManager.persist(bookBorrowing3);

            BookBorrowing bookBorrowing4 = new BookBorrowing();
            bookBorrowing4.setName("Can");
            bookBorrowing4.setBook(book3);
            bookBorrowing4.setBorrowingDate(LocalDate.parse("2022-11-23"));
            bookBorrowing4.setReturnDate(LocalDate.parse("2022-11-30"));
            entityManager.persist(bookBorrowing4);





            transaction.commit();


        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}