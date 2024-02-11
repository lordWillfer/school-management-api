package org.willfer.schoolmanagementapi.application.usecase.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import org.willfer.schoolmanagementapi.domain.repositories.auth.UserRepository;

/**
 * This class is used to execute the findUserByLogin method
 *
 * @author Williams Fernández
 * @version 1.0
 */
@Component
public class FindUserByLoginUseCase {

    @Autowired
    private UserRepository userRepository;

    /**
     * Executes the findUserByLogin method from User repository
     *
     * @param login A string representing the user's system login
     *
     * @return The corresponding user information if successful, or null if it is non-existent
     *
     */
    public UserDetails execute(String login) {
        return userRepository.findUserByLogin(login);
    }
}