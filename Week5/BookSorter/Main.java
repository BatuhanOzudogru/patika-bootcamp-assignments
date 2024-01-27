package Week5.BookSorter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone",223,"J.K.Rowling","1997");
        Book book2 = new Book("The Hobbit",310,"J.R.R.Tolkien","1937");
        Book book3 = new Book("Animal Farm",140,"George Orwell","1945");
        Book book4 = new Book("A Clockwork Orange",192,"Anthony Burgess","1962");
        Book book5 = new Book("The Alchemist",163,"Paulo Coelho","1988");


        Set<Book> setByName = new TreeSet<>();
        setByName.add(book1);
        setByName.add(book2);
        setByName.add(book3);
        setByName.add(book4);
        setByName.add(book5);

        System.out.println("----Sorted By Name----");
        for(Book b : setByName){
            System.out.println(b.getName());
        }

        Set<Book> setByPageNumber = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber()- o2.getPageNumber();
            }});
        setByPageNumber.add(book1);
        setByPageNumber.add(book2);
        setByPageNumber.add(book3);
        setByPageNumber.add(book4);
        setByPageNumber.add(book5);

        System.out.println("\n----Sorted By Page Number----");
        for(Book b : setByPageNumber){
            System.out.println(b.getName()+" Page Number : "+b.getPageNumber());
        }

    }



}
