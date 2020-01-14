package com.vote.service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;


public class UserDetailsServiceTest {


    @Test
    public void generate_encrypted_password(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password123";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);
        // should not be equal
        assertThat(rawPassword, not(encodedPassword));
    }

}