package com.learning.springSecEx.controller;


import com.learning.springSecEx.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "raja" , 20),
            new Student(2, "Madhu",30),
            new Student(3,"Lallu",40),
            new Student(4, "Byreddy",50)
    ));

    @GetMapping("/students")
    public List<Student>getStudents(){
        return students;
    }

    @GetMapping("/csrf-token")
    public Map<String, String> getCsrfToken(HttpServletRequest request) {
        Object csrfAttr = request.getAttribute("_csrf");
        CsrfToken csrfToken = null;

        if (csrfAttr instanceof CsrfToken) {
            csrfToken = (CsrfToken) csrfAttr; // old behavior
        } else if (csrfAttr instanceof Supplier<?> supplier) {
            csrfToken = (CsrfToken) supplier.get(); // unwrap new SupplierCsrfToken
        }

        if (csrfToken == null) {
            throw new RuntimeException("CSRF token not available");
        }

        // Return token info as JSON
        return Map.of(
                "headerName", csrfToken.getHeaderName(),
                "parameterName", csrfToken.getParameterName(),
                "token", csrfToken.getToken()
        );
    }


    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
