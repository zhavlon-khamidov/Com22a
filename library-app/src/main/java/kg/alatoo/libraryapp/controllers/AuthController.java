package kg.alatoo.libraryapp.controllers;


import kg.alatoo.libraryapp.dto.UserDetailsImpl;
import kg.alatoo.libraryapp.entities.User;
import kg.alatoo.libraryapp.services.UserService;
import kg.alatoo.libraryapp.services.exceptions.UsernameAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity registerNewUser(@Validated @RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UsernameAlreadyExistsException e) {
            return ResponseEntity.badRequest().body("username already exists");
        }
    }


    @GetMapping
    public User getCurrentUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof UserDetailsImpl principal){
            principal.getUser().setPassword(null);
            return principal.getUser();
        }

        return null;
    }
}
