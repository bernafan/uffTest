package br.com.uff.dao;

import br.com.uff.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository  extends JpaRepository<Books, Long> {
}
