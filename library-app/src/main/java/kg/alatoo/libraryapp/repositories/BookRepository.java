package kg.alatoo.libraryapp.repositories;

import kg.alatoo.libraryapp.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long>,
        PagingAndSortingRepository<Book,Long>,
        ListPagingAndSortingRepository<Book, Long> {

//    Page<Book> findAll(Pageable pageable);
}
