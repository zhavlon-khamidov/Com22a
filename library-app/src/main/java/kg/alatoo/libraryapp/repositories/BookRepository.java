package kg.alatoo.libraryapp.repositories;

import kg.alatoo.libraryapp.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
