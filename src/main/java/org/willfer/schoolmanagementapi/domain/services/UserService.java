package org.willfer.schoolmanagementapi.domain.services;

import org.springframework.security.core.userdetails.UserDetails;

import org.willfer.schoolmanagementapi.domain.dtos.auth.UserDTO;
import org.willfer.schoolmanagementapi.domain.entities.auth.User;

/**
 * User service interface for managing user information.
 *
 * @see User
 * @author Williams Fernández
 * @version 1.0
 */
public interface UserService {

    /**
     * Adds a new user to the repository.
     *
     * @param userDTO A data transfer object representing a user to add.
     * @return The saved user if successful,  or null if there is an error.
     */
    public User addUser(UserDTO userDTO);


    /**
     * Finds a stored user information by login.
     *
     * @param login A string representing the user's system login
     * @return The corresponding user information if successful, or null if it is non-existent.
     */
    public UserDetails findUserByLogin(String login);

}