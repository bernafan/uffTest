package br.com.uff.controller;

import br.com.uff.dao.BooksDao;
import br.com.uff.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    private EntityManagerFactory emf;
    BooksDao booksDao = new BooksDao(Persistence.createEntityManagerFactory("library"));

    @GetMapping(path = "/list")
    public String getBooks(ModelMap model) {
        List<Books> books = booksDao.findAll();
        model.addAttribute("books", books);
        return "lista"; // return to a page
    }

//    @GetMapping(path = "/list/{author}")
//    public String getBooksByAuthor(@PathVariable("author") String author) {
//
//    }

//    //  localhost:8080/books/list?author=Oliver
//    @GetMapping(path = "/list")
//    public String getBooksByAuthor(@RequestParam(name = "author") String author) {
//
//    }

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute Books book) {// thymeleaf doesn't need to use ModelAttribute
        booksDao.save(book);
        return "redirect:/books/list";
    }
    // the html page would have and genre attribute that will receive return values from this method
    // spring will fill the variable values in the page with this method
//    @ModelAttribute("genre")
//    public BooksGenre[] fillComboboxGenre() {
//        return BooksGenre.values();
//    }


}
