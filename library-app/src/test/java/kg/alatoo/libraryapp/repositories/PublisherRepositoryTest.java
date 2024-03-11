package kg.alatoo.libraryapp.repositories;

import kg.alatoo.libraryapp.entities.Publisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles("localpgsql")
class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;



    @Test
    void getAllBooks() {
        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        Publisher x = publishers.get(0);

        System.out.println(x.getId());
        System.out.println(x.getName());
        x.setName("Updated test publisher");

        publisherRepository.flush();
        System.out.println(x.getName());

        System.out.println("size: " + x.getBooks().size());

    }

    @AfterEach
    void tearDown() {
        Publisher publisher = publisherRepository.findAll().get(0);
        System.out.println(publisher.getId());
        System.out.println(publisher.getName());
    }

    @Test
//    @Transactional
    void lazyVsEager() {

        Publisher publisher = publisherRepository.findAll().get(0);

        System.out.println("We have got publisher: " + publisher.getName());

    }


}