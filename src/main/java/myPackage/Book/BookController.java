package myPackage.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController
{
    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public ModelAndView getAllBooks(Model model)
    {
        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("books", bookService.getAllBooks());
        return modelAndView;
    }

    @RequestMapping("/books/{id}")
    public ModelAndView getBook(@PathVariable int id)
    {
        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("books", bookService.getBook(id));
        return modelAndView;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String bookForm(Model model)
    {
        model.addAttribute("book", new Book());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String bookSubmit(@ModelAttribute Book book, Model model)
    {
        model.addAttribute("book", book);
        //String info = String.format("Book id: %d\n title: %s\n description: %s\n" );
        bookService.addBook(book);
        return "result";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    public void updateBook(@RequestBody Book book,  @PathVariable int id)
    {
        bookService.updateBook(id, book);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public void deleteBook(@PathVariable int id)
    {
        bookService.deleteBook(id);
    }
}
