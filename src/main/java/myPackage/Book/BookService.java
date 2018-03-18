package myPackage.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks()
    {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll()
        .forEach(books::add);
        return books;
    }

    public Book getBook(int id)
    {
        return bookRepository.findOne(id);
    }

    public void addBook(Book book)
    {
        bookRepository.save(book);
    }

    public void updateBook(int id, Book book)
    {
        bookRepository.save(book);
    }
    public void deleteBook(int id)
    {
        bookRepository.delete(id);
    }
}
