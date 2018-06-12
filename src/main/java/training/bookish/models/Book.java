package training.bookish.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private Integer numberOfCopies;
    private String author;
    private Set<Loan> loans;

    public Book() {}

    public Book(int id, String isbn, String title, String author, int numberOfCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    @Column(nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(nullable = false)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    @JoinColumn(name = "book")
    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public int amountInStock() {
        return numberOfCopies - getLoans().size();
    }
}
