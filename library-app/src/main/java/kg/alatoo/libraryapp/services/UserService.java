package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.entities.User;
import kg.alatoo.libraryapp.services.exceptions.UsernameAlreadyExistsException;

public interface UserService {

    void createUser(User user) throws UsernameAlreadyExistsException;
}
