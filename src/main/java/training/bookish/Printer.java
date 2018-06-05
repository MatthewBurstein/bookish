package training.bookish;

import models.Book;

import java.util.List;

public class Printer {

    public void printBook(Book book) {
        System.out.println("id: " + book.getId());
        System.out.println("isbn: " + book.getIsbn());
        System.out.println("title: " + book.getTitle());
        System.out.println("author: " + book.getAuthor());
        System.out.println("number of copies: " + book.getNumberOfCopies());
    }

    public void printBookList(List<Book> books) {
        books.forEach(book -> {
            System.out.println("=================");
            printBook(book);
        });
    }


}
