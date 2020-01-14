package com.vote.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration              // will be treated as xml file
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Qualifier("userDetailsServiceImpl")
    @Autowired          // take the object that manage by spring
    private UserDetailsService userDetailsService;

    //for login - need password encoder
    @Bean
    // return Java object  - or we can create separate class instead of @Bean (@Bean - we can use in other class - @Autowired)
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();         // new instance
    }

    @Override           // who are you proved --> who are you prove it
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());

        /*       auth.inMemoryAuthentication()        // where the user name and password is stored
                .passwordEncoder(getPasswordEncoder())          // use BCrypt for authentication
                .withUser("mike@mike.com")
                .password(getPasswordEncoder().encode("mike1"))
                .roles("USER");*/
    }

    @Override           // Authorization - which access should I give you
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable()               // csrf - cross site request forgery - can secure PATCH, POST, PUT, DELETE
        http                        // enable csrf protection
                .authorizeRequests()    // what access do you have
                .antMatchers("/").permitAll()   // everyone can see homepage
                .antMatchers("/admin/**").hasRole("ADMIN")  // ** - has a role ADMIN
                .anyRequest().hasRole("USER")
                .and().formLogin()
                .loginPage("/login")    //everyone can see login page
                .defaultSuccessUrl("/dashboard")
                .permitAll()
                .and()
                .logout()                   // only POST <form action="/logout" method="post">
                .logoutUrl("/logout")
                .permitAll();
    }
}
