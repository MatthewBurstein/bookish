package training.bookish;

import models.Book;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/bookish";
        String dbUsername = System.getenv("POSTGRES_USERNAME");
        String dbPassword = System.getenv("POSTGRES_PASSWORD");
        DatabaseService db = new DatabaseService(url, dbUsername, dbPassword);
        Printer printer = new Printer();
        List<Book> books = db.getBooks();
        printer.printBookList(books);
    }
}
