package com.vote.controller;

import com.vote.entity.Product;
import com.vote.entity.User;
import com.vote.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("/products")
    public String getProducts(ModelMap map){
        return "product";
    }

    @GetMapping("/products/{productId}")
    public String getProduct(@PathVariable Long productId){
        return "product";
    }

    @PostMapping("/products")                       // once we click CreateProduct is going to post and then is redirected to get
    public String createProduct(@AuthenticationPrincipal User user){        // Authentication is for Spring security otherwise all User attributes will be null
        Product product = new Product();

        product.setPublished(false);
        product.setUser(user);

        product = productRepo.save(product);          // return Product

        

        return "redirect:/products/" + product.getId();                // redirect always with product - go to specific product
    }
}
