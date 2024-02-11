package org.willfer.schoolmanagementapi.application.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.willfer.schoolmanagementapi.domain.dtos.auth.UserDTO;
import org.willfer.schoolmanagementapi.domain.entities.auth.User;
import org.willfer.schoolmanagementapi.domain.services.UserService;
import org.willfer.schoolmanagementapi.domain.services.auth.AuthService;

/**
 * This class is an implementation of the AuthService interface.
 * This class provides methods to perform operations on users registration and authentication
 *
 * @author Williams Fernández
 * @version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Performs the user login
     *
     * @param userDTO Data transfer object containing user credentials for authentication operations
     * @return authentication object including the credentials
     */
    @Override
    public Authentication login(UserDTO userDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.login(),
                userDTO.password());

        return manager.authenticate(token);
    }

    /**
     * Performs the user registration
     *
     * @param userDTO Data transfer object containing user credentials for authentication operations
     * @return A user object including the credentials
     */
    @Override
    public User register(UserDTO userDTO) {

        String encodedPassword = passwordEncoder.encode(userDTO.password());
        userDTO = new UserDTO(userDTO.login(), encodedPassword);

        return this.userService.addUser(userDTO);
    }
}