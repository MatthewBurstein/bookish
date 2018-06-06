package training.bookish.compositemodels;

import training.bookish.models.Loan;
import training.bookish.models.User;

import java.util.List;

public class UserLoans {

    private User user;
    private List<Loan> loans;

    public UserLoans(User user, List<Loan> loans) {
        this.user = user;
        this.loans = loans;
    }

    public User getUser() {
        return user;
    }

    public List<Loan> getLoans() {
        return loans;
    }





}
