package kg.alatoo.diintro;


import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private final GreetingService service;

    public MainController() {
        this.service = new GreetingService();
    }

    public String sayHello() {
        System.out.println("Inside of MainController");
        return service.greet();
    }
}
