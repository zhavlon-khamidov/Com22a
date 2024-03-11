package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("localpgsql")
class BookServiceJPATest {

    @Autowired
    BookServiceJPA bookServiceJPA;

    @Test
    void findBookByID() {
        System.out.println("Hello World");
    }

    Long id;

    @Test
    void updateBook() {
        BookDTO dto = bookServiceJPA.findBooks(0, 1)
                .get().findFirst().get();

        System.out.println("Old name: " + dto.getName());
        dto.setName("Updated name");
        this.id = dto.getId();
        bookServiceJPA.updateBook(dto.getId(), dto);
    }

    @AfterEach
    void tearDown() {
        System.out.println("New name: " + bookServiceJPA.findBookByID(id)
                .get().getName());
    }
}