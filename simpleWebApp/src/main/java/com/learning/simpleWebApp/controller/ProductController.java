package com.learning.simpleWebApp.controller;

import com.learning.simpleWebApp.model.Product;
import com.learning.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    //here the {prodId} is used to fetch the Id of the product and it is passes to the method by using @PathVariable
    // @PathVariable annotation extracts values from the URI path and binds them to method parameters in a controller
    public Product getProductById(@PathVariable int prodId){
        return service.getProductById(prodId);
    }

    @PostMapping("/products")
//    @RequestBody = “Take the data sent in the request body (like JSON) and turn it into a Java object.”
//    Without @RequestBody, Spring looks for data in form fields or URL parameters.
//    If you send JSON without @RequestBody, Spring can’t read it, and you get errors like your typeMismatch.
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }


    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }

}
