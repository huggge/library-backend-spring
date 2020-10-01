package com.hugo.librarycrud.service;

import com.hugo.librarycrud.entity.Book;

import java.math.BigInteger;
import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findById(int theId);

    public void save(Book theBook);

    public void deleteById(int theId);

    public List<Book> findByName(String theName);

    public List<Book> findByAuthor(String theAuthor);

    public BigInteger countBooks();

}
