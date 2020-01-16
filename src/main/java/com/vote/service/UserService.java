package com.vote.service;

import com.vote.entity.User;
import com.vote.repositories.UserRepository;
import com.vote.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // method that will save User Object into DB
    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUser(user);
        user.getAuthorities().add(authority);
                                                // no need to set the ID cause is AutoIncremented @ID
        return userRepo.save(user);             // want the entity user -> User class is defining as an Entity
    }
}
