package kg.alatoo.libraryapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryAppApplication.class, args);
    }


    @Bean
    public CommandLineRunner boostrapData() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                //TODO: HW create at least 3 books using Lombok @Builder option and save to DB
            }
        };
    }
}
