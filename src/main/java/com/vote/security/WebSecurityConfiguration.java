package com.vote.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration              // will be treated as xml file
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override           // who are you proved --> who are you prove it
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()        // where the user name and password is stored
                .withUser("mike@mike.com")
                .password("mike1")
                .roles("USER");
    }

    @Override           // Authorization - which access should I give you
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()    // what access do you have
                .antMatchers("/").permitAll()   // anyone can see homepage
                .antMatchers("/index").permitAll()
                .anyRequest().hasRole("USER")
                .and().formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();
    }
}
