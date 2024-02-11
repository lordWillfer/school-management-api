package org.willfer.schoolmanagementapi.domain.services.auth;

import org.springframework.security.core.Authentication;

import org.willfer.schoolmanagementapi.domain.dtos.auth.UserDTO;
import org.willfer.schoolmanagementapi.domain.entities.auth.User;

/**
 * Authentication service interface for managing authentication and registration.
 *
 * @see User
 * @author Williams Fernández
 * @version 1.0
 */
public interface AuthService {

    /**
     * Performs the user login
     *
     * @param userDTO Data transfer object containing user credentials for authentication operations
     * @return A fully authentication object including the credentials
     */
    public Authentication login(UserDTO userDTO);

    /**
     * Performs the user registration
     *
     * @param userDTO Data transfer object containing user credentials for authentication operations
     * @return A user object including the credentials
     */
    public User register(UserDTO userDTO);

}