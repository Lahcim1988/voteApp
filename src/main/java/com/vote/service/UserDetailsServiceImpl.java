package com.vote.service;

import com.vote.entity.User;
import com.vote.repositories.UserRepository;
import com.vote.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {       // object that is implementing in interface

    @Autowired
    private UserRepository userRepo;

    @Override           // implements by interface
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // CRUD - operations

        User user = userRepo.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("Invalid Username and password");    // instead of Username not exists - it is more safely

        return new CustomSecurityUser(user);      // user from DB
    }
}
