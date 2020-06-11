package com.rest.RestFulApi.Authentication;

import java.util.ArrayList;

import com.rest.RestFulApi.Client.ExistingClients;
import com.rest.RestFulApi.Client.OficialClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ExistingClients myClients = ExistingClients.getInstance();
        OficialClient client = myClients.getUserByUsername(username);
        if (client != null) {
            return new User(client.getUsername(), bcryptEncoder.encode(client.getPassword()),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}

