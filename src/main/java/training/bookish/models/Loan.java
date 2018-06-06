package training.bookish.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
    @AttributeOverrides({
            @AttributeOverride(name = "userAccount", column = @Column(name = "user_account")),
            @AttributeOverride(name = "startDate", column = @Column(name = "startDate")),
            @AttributeOverride(name = "endDate", column = @Column(name = "end_date"))
    })
@Table(name = "loans")
public class Loan {
    private int id;
    private Date startDate;
    private Date endDate;
    private User userAccount;
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
    @JoinColumn(name = "user_account")
    public User getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(User userAccount) {
        this.userAccount= userAccount;
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
