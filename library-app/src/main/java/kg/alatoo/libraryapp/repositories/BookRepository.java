package kg.alatoo.libraryapp.repositories;

import kg.alatoo.libraryapp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends CrudRepository<Book,Long>,
        PagingAndSortingRepository<Book,Long>,
        ListPagingAndSortingRepository<Book, Long>,
        JpaRepository<Book, Long>
{
}
