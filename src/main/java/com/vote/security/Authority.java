package com.vote.security;

import com.vote.entity.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity                 // should be stored in DB
public class Authority implements GrantedAuthority {

    private Long id;
    private String authority;
    private User user;

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @ManyToOne      // -> User
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
