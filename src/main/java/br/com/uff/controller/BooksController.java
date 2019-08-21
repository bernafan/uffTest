package br.com.uff.controller;

import br.com.uff.model.Books;

@Controller
@ResquestMapping("/books")
public class BooksController {

    @GetMapping(path = "/list")
    public String getBooks(ModelMap model) {
        List<Books> books = booksDao.findAll();
        model.addAttributes("books", books);
        return "lista"; // return to a page
    }

    @GetMapping(path = "/list/{author}")
    public String getBooksByAuthor(@PathVariable("author") String author) ;

    //  localhost:8080/books/list?author=Oliver
    @GetMapping(path = "/list")
    public String getBooksByAuthor(@RequestParam(name = "author") String author) ;

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute Books book) {// thymeleaf doesn't need to use ModelAttribute
        ////
        return "redirect:/books/list";
    }
    // the html page would have and genre attribute that will receive return values from this method
    // spring will fill the variable values in the page with this method
    @ModelAttribute("genre")
    public BooksGenre[] fillComboboxGenre() {
        return BooksGenre.values();
    }


}
