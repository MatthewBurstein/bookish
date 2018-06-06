package training.bookish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import training.bookish.models.Book;
import training.bookish.services.BookService;

import java.util.List;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    ModelAndView books() {
        List<Book> books = bookService.getBooks();
        return new ModelAndView("books","books", books);
    }


}
