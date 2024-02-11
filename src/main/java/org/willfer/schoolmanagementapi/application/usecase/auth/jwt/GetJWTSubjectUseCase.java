package org.willfer.schoolmanagementapi.application.usecase.auth.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class is used to execute the JWT verify method using Algorithm HMAC256 and application secret
 *
 * @author Williams Fernández
 * @version 1.0
 */
@Component
public class GetJWTSubjectUseCase {

    @Value("${api.security.token.secret}")
    private String secret;

    /**
     * Gets the jwt subject
     *
     * @param token The json web token on request header
     * @return A string containing the subject from the decoded jwt
     */
    public String execute(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .withIssuer("School-Management-API")
                .build()
                .verify(token);

        return decodedJWT.getSubject();
    }
}