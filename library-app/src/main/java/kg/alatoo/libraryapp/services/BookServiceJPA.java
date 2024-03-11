package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.mappers.BookMapper;
import kg.alatoo.libraryapp.repositories.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceJPA implements BookService {

    private static final int MAX_PAGE_SIZE = 1000;
    private static final int DEFAULT_PAGE_SIZE = 25;

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceJPA(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Page<BookDTO> findBooks(Integer pageNumber, Integer pageSize) {
        return bookRepository.findAll(getPageable(pageNumber, pageSize))
                .map(bookMapper::bookToBookDto);

        /*return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookDto)
                .toList();*/
    }

    public PageRequest getPageable(Integer pageNumber, Integer pageSize) {
        if (pageNumber == null || pageNumber <= 0) {
            pageNumber = 1;
        }

        if (pageSize == null || pageSize <= 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        } else if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }

        return PageRequest.of(pageNumber-1, pageSize);
    }

    @Override
    public Optional<BookDTO> findBookByID(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return Optional.ofNullable(
                bookMapper.bookToBookDto(optionalBook.orElse(null))
        );
    }

    @Override
    public BookDTO saveBook(BookDTO dto) {
        return bookMapper.bookToBookDto(
                bookRepository.save(
                        bookMapper.bookDtoToBook(dto)
                )
        );
    }

    @Override
    public Page<BookDTO> findBooks(Pageable pageable) {
        if (pageable.getSort().isUnsorted()) {
            Sort sort = Sort.by(
                    Sort.Order.desc("publishedYear"),
                    Sort.Order.asc("title"));
            pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        }

        return bookRepository.findAll(pageable)
                .map(bookMapper::bookToBookDto);
    }
}
