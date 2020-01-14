package com.vote.repositories;

import com.vote.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { // long id
    // CRUD

    User findByUsername(String username);       // Username works because in User we have username field

}
