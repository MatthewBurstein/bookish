package models;

import java.util.List;

public class Book {

    private final Integer id;
    private final String isbn;
    private final String title;
    private final Integer numberOfCopies;
    private final String author;

    public Book(int id, String isbn, String title, String author, int numberOfCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

}
