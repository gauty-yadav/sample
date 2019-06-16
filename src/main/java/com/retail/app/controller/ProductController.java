package com.retail.app.controller;

import com.retail.app.model.Product;
import com.retail.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/"})
    public Iterable<Product> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){
        return new ResponseEntity<Product>(productService.getProduct(id),HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.save(product),HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product){
        return new ResponseEntity<Product>(productService.update(id,product),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.delete(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
