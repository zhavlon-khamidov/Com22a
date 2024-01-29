package kg.alatoo.helloworld;

import kg.alatoo.helloworld.entity.Task;
import kg.alatoo.helloworld.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldApplication {

    private final TaskRepository taskRepository;

    public HelloWorldApplication(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }


    @Bean
    public CommandLineRunner initDatabase() {
         return new CommandLineRunner(){
            public void run(String... args) {
                System.out.println("CommandLineRunner started");

                // create some tasks in database
                Task task1 = new Task()
                        .setTitle("Task 1")
                        .setDescription("Hello World!");

                Task task2 = new Task()
                        .setTitle("Task 2")
                        .setDescription("Hello COM22A");

                taskRepository.save(task1);
                taskRepository.save(task2);

                System.out.println("2 tasks has been created");
            }
        };
    }

}
