package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> findBooks();

    Optional<BookDTO> findBookByID(Long id);
}
