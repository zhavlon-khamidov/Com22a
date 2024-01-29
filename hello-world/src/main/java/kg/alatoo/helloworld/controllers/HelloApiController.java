package kg.alatoo.helloworld.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    @GetMapping
    public String hello() {
        return "<h1>Hello Spring!</h1><p>Welcome to our spring course!</p>";
    }

    @GetMapping("welcome")
    public String welcomeAibika() {
        return "Welcome, Aibika";
    }
}
