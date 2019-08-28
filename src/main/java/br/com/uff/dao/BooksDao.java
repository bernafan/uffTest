package br.com.uff.dao;

import br.com.uff.model.Books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public BooksDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Books book) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public List<Books> findAll(){
        List<Books> books = new ArrayList<>();
        return books;
    }
}
