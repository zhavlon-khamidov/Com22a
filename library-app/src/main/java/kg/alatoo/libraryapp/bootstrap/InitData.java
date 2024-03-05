package kg.alatoo.libraryapp.bootstrap;

import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class InitData implements CommandLineRunner {

    private final BookRepository bookRepository;

    public InitData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        //TODO: HW create at least 3 publisher that each publisher has at least 2 books with single and multiple authors

        Book book1 = Book.builder()
                .title("Syngan kylych")
                .publishedYear(2000)
                .isbn("1513215342")
                .edition(1)
                .build();

        Book book2 = Book.builder()
                .title("Database")
                .edition(3)
                .publishedYear(2020)
                .isbn("354151446551")
                .build();

        bookRepository.save(book1);
        bookRepository.save(book2);

        generateBooks();

    }

    void generateBooks() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            Book book = Book.builder()
                    .title("Book " + (i+1))
                    .isbn(String.valueOf(random.nextInt(10000000,99999999)))
                    .publishedYear(random.nextInt(1970,2024))
                    .build();

            bookRepository.save(book);
        }
    }
}
