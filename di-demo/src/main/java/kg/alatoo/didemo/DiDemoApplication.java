package kg.alatoo.didemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class DiDemoApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiDemoApplication.class, args);

        GreetingController greetingController = context.getBean(GreetingController.class);

        System.out.println(greetingController.sayHello());

    }

}
