package org.willfer.schoolmanagementapi.application.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.willfer.schoolmanagementapi.domain.services.UserService;

/**
 * This class is an implementation of the UserDetailsService interface.
 *
 * This class provides methods to perform operations on users information
 *
 * @author Williams Fernández
 * @version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findUserByLogin(username);
    }

}