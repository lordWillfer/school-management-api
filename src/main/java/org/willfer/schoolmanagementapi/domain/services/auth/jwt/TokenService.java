package org.willfer.schoolmanagementapi.domain.services.auth.jwt;

import org.willfer.schoolmanagementapi.domain.entities.auth.User;

/**
 * Token service interface for managing the jwt feature
 *
 * @author Williams Fernández
 * @version 1.0
 */
public interface TokenService {

    /**
     * Generates the authorization token
     *
     * @param user The authenticated user
     * @return A string containing the authorization token
     */
    public String generateToken(User user);

    /**
     * Gets the jwt subject
     *
     * @param token The json web token on request header
     * @return A string containing the subject from the decoded jwt
     */
    public String getTokenSubject(String token);

}