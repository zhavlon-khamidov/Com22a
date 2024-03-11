package kg.alatoo.libraryapp.controllers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BookApiController {

    private final String API_PATH = "/api/v1/";
    private final String BOOK_PATH = API_PATH + "book";
    private final String ID_PATH = BOOK_PATH + "/{id}";


    private final BookService bookService;

    @GetMapping(BOOK_PATH)
    public Page<BookDTO> getBooks(
            @PageableDefault(size = 30) Pageable pageable
//            @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
//            @RequestParam(required = false, defaultValue = "25") Integer pageSize

    ) {

        return bookService.findBooks(pageable);
    }

    @GetMapping(ID_PATH)
    public BookDTO getById(@PathVariable Long id) {
        log.info("Getting book with id:" + id);
        return bookService.findBookByID(id).orElseThrow(NotFoundException::new);
    }


    @PostMapping(BOOK_PATH)
    public ResponseEntity<BookDTO> createBook(@Validated @RequestBody BookDTO bookDTO) {
        BookDTO dto = bookService.saveBook(bookDTO);

        return ResponseEntity.created(URI.create(BOOK_PATH + "/"+dto.getId())).body(dto);
    }



}
