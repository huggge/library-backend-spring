package com.hugo.librarycrud.dao;

import com.hugo.librarycrud.entity.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

@Repository
public class BookDAOHibernateImpl implements BookDAO {

    // define fields for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public BookDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Book> findAll() {
        // get the current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the query
        Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);

        // execute the query and get the result list
        List<Book> books = theQuery.getResultList();

        // return the results
        return books;
    }

    @Override
    public Book findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Book theBook = currentSession.get(Book.class, theId);

        return theBook;
    }

    @Override
    public void save(Book theBook) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theBook);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery(
                        "delete from Book where id=:bookId");
        theQuery.setParameter("bookId", theId);

        theQuery.executeUpdate();
    }

    @Override
    public List<Book> findByName(String theName) {
        // get the current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the query
        Query<Book> theQuery = currentSession.createQuery("from Book where name = :bookName", Book.class);
        theQuery.setParameter("bookName", theName);
        // execute the query and get the result list
        List<Book> books = theQuery.getResultList();

        // return the results
        return books;
    }

    @Override
    public List<Book> findByAuthor(String theAuthor) {
        // get the current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the query
        Query<Book> theQuery = currentSession.createQuery("from Book where author = :authorName", Book.class);
        theQuery.setParameter("authorName", theAuthor);
        // execute the query and get the result list
        List<Book> books = theQuery.getResultList();

        // return the results
        return books;
    }

    @Override
    public BigInteger countBooks() {
        // get the current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the query
        Query<BigInteger> theQuery = currentSession.createSQLQuery("select count(*) from books");
        BigInteger count = theQuery.uniqueResult();
        return count;

    }
}
