package com.hugo.librarycrud.service;

import com.hugo.librarycrud.dao.BookDAO;
import com.hugo.librarycrud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO theBookDAO) {
        bookDAO = theBookDAO;
    }

    @Override
    @Transactional
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    @Transactional
    public Book findById(int theId) {
        return bookDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Book theBook) {
        bookDAO.save(theBook);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        bookDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Book> findByName(String theName) {
        return bookDAO.findByName(theName);
    }

    @Override
    public List<Book> findByAuthor(String theAuthor) {
        return bookDAO.findByAuthor(theAuthor);
    }

    @Override
    public BigInteger countBooks() {
        return bookDAO.countBooks();
    }
}
