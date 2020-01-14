package com.vote.security;

import com.vote.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public class CustomSecurityUser extends User implements UserDetails {

    // constructors
    public CustomSecurityUser() {
    }

    public CustomSecurityUser(User user) {    //to use in UserDetailsServiceImpl // user coming from DB
        this.setAuthorities(user.getAuthorities());
        this.setId(user.getId());
        this.setName(user.getName());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
    }

    // get / set
    // Set<Authority> authorities = new HashSet<>();   // authorities needs to be stored in database - move to User class

    @Override
    public Set<Authority> getAuthorities() {                          // Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getAuthorities();            // coming from the parent object
    }

    // password and username already exists in User class do not want to duplicate - extends User class
    @Override
    public String getPassword() {
        return super.getPassword();      // from User - has password
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }   // coming from the parent object

    // hardcode as true - no need at this now
    @Override
    public boolean isAccountNonExpired() {      // weather user is active or not
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {       //
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
