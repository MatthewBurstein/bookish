package training.bookish.controllers;

import training.bookish.compositemodels.UserLoans;
import training.bookish.models.Loan;
import training.bookish.services.LoanService;
import training.bookish.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.bookish.models.User;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * Controller for the index page
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoanService loanService;

    @RequestMapping("/")
    ModelAndView home(Principal principal) {
        User user = userService.getUser(principal.getName());
        List<Loan> loans = loanService.getUserLoans(user.getId());
        UserLoans userLoans = new UserLoans(user, loans);
        return new ModelAndView("index", "userLoans", userLoans);
    }

    @RequestMapping("/login")
    ModelAndView login(@RequestParam Map<String, String> params) {
        return new ModelAndView("login", params);
    }

}
