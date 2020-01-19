package com.vote.repositories;


import com.vote.entity.Product;
import com.vote.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {

    // select * from product where user = :user
    List<Product> findByUser(User user);     // have to start by findBy... is spring feature for sql methods
                                                // we have access to Product --> user, name, features, published

    // select * from product where user = :user and name = :name
    List<Product> findByUserAndName(User user, String name);            // no need here

    @Query("select p from Product p join fetch p.user where p.id = :id")
    Optional<Product> findByIdWithUser(Long id);

}
