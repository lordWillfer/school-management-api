package org.willfer.schoolmanagementapi.application.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.willfer.schoolmanagementapi.domain.dtos.auth.UserDTO;
import org.willfer.schoolmanagementapi.domain.entities.auth.User;
import org.willfer.schoolmanagementapi.domain.services.auth.AuthService;
import org.willfer.schoolmanagementapi.domain.services.auth.jwt.TokenService;

import jakarta.validation.Valid;

/**
 * A Spring REST controller for managing authentication and user information.
 *
 * @author Williams Fernández
 * @version 1.0
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    /**
     * Performs the user login
     *
     * @param userDTO A data transfer object containing the user data to perform the login
     *
     * @return The authorization token if successful, or an unauthorized status if there is an error.
     */
    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserDTO userDTO) {

        Authentication auth = authService.login(userDTO);

        User authenticatedUser = (User) auth.getPrincipal();

        String token = tokenService.generateToken(authenticatedUser);

        return ResponseEntity.ok(token);
    }

    /**
     * Performs the user registration
     *
     * @param userDTO A data transfer object containing the user data to perform the registration
     *
     * @return The registered user if successful, or null if there is an error.
     */

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UserDTO userDTO) {

        User user = authService.register(userDTO);

        return ResponseEntity.ok(user);
    }

}