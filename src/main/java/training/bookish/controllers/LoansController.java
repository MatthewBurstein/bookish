package training.bookish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import training.bookish.models.LoanForm;
import training.bookish.services.LoanService;

@Controller
@RequestMapping("/loans")
public class LoansController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public String getBooks(){
        return "redirect:/";
    }

    @PostMapping
    public String postBook(@ModelAttribute LoanForm loanForm) {
        System.out.println("success");
        return "redirect:/";
    }
}
