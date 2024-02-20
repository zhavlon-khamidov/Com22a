package kg.alatoo.libraryapp.controllers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BookApiController {

    private final String API_PATH = "/api/v1/";
    private final String BOOK_PATH = API_PATH + "book";
    private final String ID_PATH = BOOK_PATH + "/{id}";


    private final BookService bookService;

    @GetMapping(BOOK_PATH)
    public List<BookDTO> getBooks() {
        return bookService.findBooks();
    }

    @GetMapping(ID_PATH)
    public BookDTO getById(@PathVariable Long id) {
        log.info("Getting book with id:" + id);
        return bookService.findBookByID(id).orElseThrow(NoSuchElementException::new);
    }
}
