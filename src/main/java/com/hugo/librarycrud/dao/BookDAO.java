package com.hugo.librarycrud.dao;

import com.hugo.librarycrud.entity.Book;

import java.math.BigInteger;
import java.util.List;

public interface BookDAO {

    public List<Book> findAll();

    public Book findById(int theId);

    public void save(Book theBook);

    public void deleteById(int theId);

    public List<Book> findByName(String theName);

    public List<Book> findByAuthor(String theAuthor);

    public BigInteger countBooks();


}
