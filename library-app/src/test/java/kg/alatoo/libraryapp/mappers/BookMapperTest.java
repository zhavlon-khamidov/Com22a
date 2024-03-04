package kg.alatoo.libraryapp.mappers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.entities.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void bookToBookDto() {
        Book book = Book.builder()
                .id(12L)
                .title("Test book")
                .isbn("13241584")
                .publishedYear(2020)
                .build();

        Publisher publisher = Publisher.builder()
                .id(1L)
                .name("Test publisher")
                .email("test@example.com")
                .books(Set.of(book))
                .build();

        book.setPublisher(publisher);

        BookDTO dto = bookMapper.bookToBookDto(book);

        assertNotNull(dto);
        assertEquals("Test book",dto.getName());
        assertEquals("13241584", dto.getIsbn());
        assertEquals(2020, dto.getPublishedYear());
        assertEquals("Test publisher",dto.getPublisher().getName());
    }
}