package kg.alatoo.libraryapp.repositories;

import kg.alatoo.libraryapp.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findAll();
}
