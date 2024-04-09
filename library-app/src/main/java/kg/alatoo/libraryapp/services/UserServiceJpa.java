package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.UserDetailsImpl;
import kg.alatoo.libraryapp.entities.User;
import kg.alatoo.libraryapp.repositories.UserRepository;
import kg.alatoo.libraryapp.services.exceptions.UsernameAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.atomic.AtomicReference;


@Service
@RequiredArgsConstructor
public class UserServiceJpa implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AtomicReference<User> atomicUser = new AtomicReference<>();

        userRepository.findByUsername(username).ifPresentOrElse(
                (user)-> atomicUser.set(user),
                ()-> {
                    throw new UsernameNotFoundException(
                        String.format("User with username '%s' not found",username));
                }
        );
        User user = atomicUser.get();
        //return UserDetails instead of User
        return new UserDetailsImpl(user);
    }

    @Override
    public void createUser(User user) throws UsernameAlreadyExistsException {
        user.setId(null);

        if (StringUtils.hasLength(user.getUsername())) {
            if (userRepository.existsByUsername(user.getUsername()))
                throw new UsernameAlreadyExistsException();

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.saveAndFlush(user);
        }else {
            //TODO: username cannot be empty, throw new exception
        }
    }
}
