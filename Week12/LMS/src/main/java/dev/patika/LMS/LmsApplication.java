package dev.patika.LMS;

import dev.patika.LMS.business.concretes.BookBorrowingManager;
import dev.patika.LMS.entities.BookBorrowing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

}
