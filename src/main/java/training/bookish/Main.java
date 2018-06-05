package training.bookish;

import models.Book;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DatabaseService db = new DatabaseService();
        Printer printer = new Printer();
        List<Book> books = db.getBooks();
        printer.printBookList(books);
    }
}
