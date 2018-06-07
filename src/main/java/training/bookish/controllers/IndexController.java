package training.bookish.controllers;

import training.bookish.services.LoanService;
import training.bookish.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.bookish.models.User;

import java.security.Principal;
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
        return new ModelAndView("index", "user", user);
    }

    @RequestMapping("/login")
    ModelAndView login(@RequestParam Map<String, String> params) {
        return new ModelAndView("login", params);
    }

}
