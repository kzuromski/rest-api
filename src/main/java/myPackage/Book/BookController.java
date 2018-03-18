package myPackage.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController
{
    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @RequestMapping("/books/{id}")
    public String getBook(@PathVariable int id, Model model)
    {
        Book getBook = bookService.getBook(id);
        model.addAttribute("id", getBook.getId());
        model.addAttribute("title", getBook.getTitle());
        model.addAttribute("description", getBook.getDescription());
        return "books";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
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
