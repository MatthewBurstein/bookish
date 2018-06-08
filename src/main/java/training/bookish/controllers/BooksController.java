package training.bookish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import training.bookish.models.Book;
import training.bookish.services.BookService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;
    private String filter;

    @GetMapping
    public ModelAndView getBooks(@RequestParam Map<String, String> params){
        List<Book> books = null;
        if (params.containsKey("filter")) {
            books = bookService.getBooksContaining(params.get("filter"));
        } else {
            books = bookService.getBooks();
        }
        return new ModelAndView("books","books", books);
    }

    @PostMapping
    public String postBook(@ModelAttribute Book book) {
        bookService.create(book);
        return "redirect:/";
    }

    @GetMapping("/{bookId}")
    ModelAndView getBook(@PathVariable int bookId) {
        Book book = bookService.find(bookId);
        System.out.println(book.getLoans());
        book.getLoans().forEach(loan -> {
            System.out.println(loan.getEndDate());
            System.out.println(loan.getUser().getUsername());
        });
        return new ModelAndView("book", "book", book);
    }

    @GetMapping("/new")
    ModelAndView newBook() {
        Book book = new Book();
        return new ModelAndView("newBook", "book", book);
    }
}
