# Exercise - Library Management System

## Description

This is a simple Library Management System exercise which introduced us to concepts such as ORM and JPA.

This LMS consists of the following entities:

Book: Entity/table containing book properties.

![book.png](src%2Fmain%2Fjava%2Forg%2Fexample%2Fstatic%2Fbook.png)

Author: Entity/table containing author properties.

![author.png](src%2Fmain%2Fjava%2Forg%2Fexample%2Fstatic%2Fauthor.png)

Category: Entity/table containing book categories.

![category.png](src%2Fmain%2Fjava%2Forg%2Fexample%2Fstatic%2Fcategory.png)

Publisher: Entity/table containing publisher properties.

![publisher.png](src%2Fmain%2Fjava%2Forg%2Fexample%2Fstatic%2Fpublisher.png)

Book Borrowing: Entity/table that tracks book borrowing transactions. This table includes borrower information, receipt date, and delivery date.

![book_borrowing.png](src%2Fmain%2Fjava%2Forg%2Fexample%2Fstatic%2Fbook_borrowing.png)

Book to Category: This table gets created automatically by Hibernate when we define a Many-to-Many relationship between Book and Category entities.

![book2category.png](src%2Fmain%2Fjava%2Forg%2Fexample%2Fstatic%2Fbook2category.png)
### There are several relationships between these entities:

Book and Author: A book can have one author, while an author can have multiple books (One-to-Many relationship).

Category and Book: A category can contain multiple books, and a book can belong to multiple categories (Many-to-Many relationship).

Book and Publishing House: A book can have one publishing house, while a publishing house can have multiple books (One-to-Many relationship).

Book and Borrowing: A book can have multiple loans, but each loan is associated with only one book (One-to-Many relationship).



