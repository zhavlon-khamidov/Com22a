package kg.alatoo.libraryapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @GetMapping("not-found")
    public void getNotFoundException() {
        throw new NotFoundException();
    }
}
