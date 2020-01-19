package com.vote.controller;

import com.vote.entity.Product;
import com.vote.entity.User;
import com.vote.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    // moved to Dashboard View
    /*@GetMapping("/products")
    public String getProducts(@AuthenticationPrincipal User user, ModelMap model) {
        List<Product> products = productRepo.findByUser(user);       // all products from specific user - logged in

        model.put("products", products);

        return "products";          // products
    }*/

    @GetMapping("/products/{productId}")
    public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse response) throws Exception {
        Optional<Product> productOpt = productRepo.findByIdWithUser(productId);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            model.put("product", product);
        } else {
            Product product = new Product();
            response.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + productId + " was not found");
            return "product";
        }

        return "product";
    }

    @PostMapping("/products/{productId}")                       // @PathVariable productId has to map with {productId}
    public String saveProduct(@PathVariable Long productId, Product product) {  // Binding data from product.html - save product <form action="" method="post>
        // saving - product sa have to pass product to method {product.html --> product}
        System.out.println(product);

        product = productRepo.save(product);

        return "redirect:/products/" + product.getId();                     // posting has to be redirect
    }

    @PostMapping("/products")
    // once we click CreateProduct is going to post and then is redirected to get
    public String createProduct(@AuthenticationPrincipal User user) {        // Authentication is for Spring security otherwise all User attributes will be null
        Product product = new Product();

        product.setPublished(false);
        product.setUser(user);

        product = productRepo.save(product);          // return Product


        return "redirect:/products/" + product.getId();                // redirect always with product - go to specific product
    }
}
