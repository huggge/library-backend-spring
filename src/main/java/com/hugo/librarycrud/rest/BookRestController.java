package com.hugo.librarycrud.rest;


import com.hugo.librarycrud.dao.BookDAO;
import com.hugo.librarycrud.entity.Book;
import com.hugo.librarycrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService theBookService) {
        bookService = theBookService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {

        Book theBook = bookService.findById(bookId);

        if (theBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }

        return theBook;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {

        theBook.setId(0);

        bookService.save(theBook);

        return theBook;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {

        bookService.save(theBook);

        return theBook;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {

        Book tempBook = bookService.findById(bookId);

        if(tempBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }

        bookService.deleteById(bookId);

        return "Deleted book id - " + bookId;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books/n/{theName}")
    public List<Book> findByName(@PathVariable String theName) {
        return bookService.findByName(theName);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/books/a/{theAuthor}")
    public List<Book> findByAuthor(@PathVariable String theAuthor) {
        return bookService.findByAuthor(theAuthor);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/count")
    public BigInteger countBooks() {
        return bookService.countBooks();
    }

}

