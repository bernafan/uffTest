package uff.dao;

import br.com.uff.dao.BooksDao;
import br.com.uff.model.Books;
import lombok.AllArgsConstructor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
public class BooksDaoTest {
    private Books book;
    private Books book2;
    private BooksDao booksDao;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryTest");

    @Before
    public void setUp(){
        booksDao = new BooksDao(emf);
        book = Books.builder().author("Bukowisk").title("Mulheres").build();
        book2 = Books.builder().author("Fitzgerald").title("Forgot").build();
        createBooksForTest();
    }

    @Test
    public void saveClient_Success() {
        assertTrue(booksDao.save(book2));
    }

    @Test
    public void removeClient_Success() {
        booksDao.remove(book);
        List<Books> books = booksDao.findAll();
        assertFalse(books.contains(book));
    }

    @Test
    public void findAllClients_Success() {
        assertEquals(book, booksDao.findAll().get(0));
    }

    private void createBooksForTest() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    @After
    public void tearDown() {

    }
}
