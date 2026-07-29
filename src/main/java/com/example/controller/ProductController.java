// package com.example.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.model.Product;
// import com.example.service.ProductService;

// @RestController
// @RequestMapping("/products")
// public class ProductController {

//     private ProductService service;

//     public ProductController(ProductService service){
//         this.service=service;
//     }

//     @PostMapping
//     public String save(@RequestBody Product product){

//         service.save(product);

//         return "Product Saved";
//     }

//     @GetMapping
//     public List<Product> getProducts(){

//         return service.findAll();
//     }

//     @GetMapping("/{id}")
//     public Product getProduct(@PathVariable int id){

//         return service.findById(id);
//     }

//     @PutMapping
//     public String update(@RequestBody Product product){

//         service.update(product);

//         return "Updated Successfully";
//     }

//     @DeleteMapping("/{id}")
//     public String delete(@PathVariable int id){

//         service.delete(id);

//         return "Deleted Successfully";
//     }

// }
package com.example.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.dto.ProductDTO;
import com.example.model.Product;
import com.example.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public String save(@Valid @RequestBody ProductDTO dto) {

        service.save(dto);

        return "Product Saved";
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping
    public String update(@RequestBody Product product) {

        service.update(product);

        return "Updated Successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {

        service.delete(id);

        return "Deleted Successfully";
    }
}