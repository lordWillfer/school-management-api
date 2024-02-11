package org.willfer.schoolmanagementapi.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import org.willfer.schoolmanagementapi.application.usecase.user.FindUserByLoginUseCase;
import org.willfer.schoolmanagementapi.application.usecase.user.SaveUserUseCase;
import org.willfer.schoolmanagementapi.domain.dtos.auth.UserDTO;
import org.willfer.schoolmanagementapi.domain.entities.auth.User;
import org.willfer.schoolmanagementapi.domain.services.UserService;

/**
 * This class is an implementation of the UserService interface.
 *
 * This class provides methods to perform operations on User entity
 *
 * @author Williams Fernández
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SaveUserUseCase saveUser;

    @Autowired
    private FindUserByLoginUseCase findUserByLogin;

    /**
     * Finds a stored user information by login.
     *
     * @param login A string representing the user's system login
     * @return The corresponding user information if successful, or null if it is non-existent.
     */
    @Override
    public UserDetails findUserByLogin(String login) {
        return findUserByLogin.execute(login);
    }

    /**
     * Adds a new user to the repository.
     *
     * @param userDTO A data transfer object representing a user to add.
     * @return The saved user if successful,  or null if there is an error.
     */
    @Override
    public User addUser(UserDTO userDTO) {

        User user = new User(userDTO);

        return saveUser.execute(user);
    }

}