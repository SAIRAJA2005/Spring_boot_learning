package com.learning.simpleWebApp.service;

import com.learning.simpleWebApp.model.Product;
import com.learning.simpleWebApp.repository.ProductRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Service
public class ProductService {

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101, "Iphone", 50000),
//            new Product(102, "samsung" , 25000),
//            new Product(103, "Vivo", 10000)
//    ));

    @Autowired
    ProductRepo repo;

    // instead of the below getProducts() method, we can directly use the @Getter
    // It will automatically creates the getProducts() method
//    public List<Product> getProducts(){
//        return products;
//    }

    public List<Product>getProducts(){

        // using JPA
        return repo.findAll();
    }


    public Product getProductById(int prodId) {
//        return products.stream()
//                .filter(p -> p.getProdId() == prodId)
//                .findFirst().orElse(new Product(404, "Hey not found" , 0));
        
        // using JPA
        return repo.findById(prodId).orElse(new Product());
    }


    public void addProduct(Product prod) {
//        products.add(prod);

        // using JPA
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
//        int ind = 0;
//        for(int i = 0 ; i < products.size() ; i++){
//            if(products.get(i).getProdId() == prod.getProdId()){
//                ind = i;
//                products.set(ind , prod);
//                break;
//            }
//        }

        // using JPA, save  helps to update , if the prod is not there to update, then it creates the new product
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
//        int ind = 0;
//        for(int i = 0 ; i < products.size() ; i++){
//            if(products.get(i).getProdId() == prodId){
//                ind = i;
//                products.remove(ind);
//                break;
//            }
//        }

        repo.deleteById(prodId);
    }

}
