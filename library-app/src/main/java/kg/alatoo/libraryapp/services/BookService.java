package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BookService {

    Page<BookDTO> findBooks(Integer pageNumber, Integer pageSize);

    Optional<BookDTO> findBookByID(Long id);

    BookDTO saveBook(BookDTO dto);
}
