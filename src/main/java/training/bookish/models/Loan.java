package training.bookish.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
    @AttributeOverrides({
            @AttributeOverride(name = "user", column = @Column(name = "user")),
            @AttributeOverride(name = "startDate", column = @Column(name = "startDate")),
            @AttributeOverride(name = "endDate", column = @Column(name = "end_date"))
    })
@Table(name = "loans")
public class Loan {
    private int id;
    private Date startDate;
    private Date endDate;
    private User user;
    private Book book;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToOne
    @JoinColumn(name = "user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }

    @ManyToOne
    @JoinColumn(name = "book")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
