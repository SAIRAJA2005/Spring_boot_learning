package com.learning.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController allows to handle all REST APIs such as GET, POST, Delete and PUT requests.
// The @RestController annotation is used for making restful web services.

/*
Using @RestController for RESTful Web Services
Annotation Overview:
@RestController automatically serializes the return values of methods into JSON or XML format.
It eliminates the need to use @ResponseBody on each method.

Request Handling:
@RestController maps HTTP requests to methods using HTTP method-specific annotations
    like @GetMapping, @PostMapping, @PutMapping, and @DeleteMapping.
* */


@RestController
public class HomeController {

    // the @RequestMapping("/") is used for the mapping to the particular page.
    @RequestMapping("/")
    public String display(){
        return "Hey i am display method";
    }

    @RequestMapping("/about")
    public String about(){
        return "Hello i am the method about!!!";
    }
}
