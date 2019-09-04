package br.com.uff.dao;

import br.com.uff.model.Books;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class BooksDao {
    private BooksRepository booksRepository;

    private EntityManagerFactory emf;
    private EntityManager em;

    public BooksDao(EntityManagerFactory emf) {

        this.emf = emf;

    }

    public boolean save(Books book) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            log.error("Fail to persist", e.getCause());
            return false;
        }
        return true;
    }

    public List<Books> findAll() {
        List<Books> books = new ArrayList<>();
        em = emf.createEntityManager();
        Query query = em.createQuery("Select b from Books b");

        return query.getResultList();
    }

    public void remove(Books book) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(book);
    }

    public void saveWithSpringJpa(Books book){
        booksRepository.save(book);
    }
}
