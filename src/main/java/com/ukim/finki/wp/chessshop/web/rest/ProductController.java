package com.ukim.finki.wp.chessshop.web.rest;


import com.ukim.finki.wp.chessshop.model.Product;
import com.ukim.finki.wp.chessshop.service.ManufacturerService;
import com.ukim.finki.wp.chessshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins="http://localhost:3000")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService, ManufacturerService manufacturerService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll(Model model){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @GetMapping("/by-manufacturer/{manufacturerId}")
    public List<Product> findAllByManufacturerId(@PathVariable Long manufacturerId) {
        return this.productService.findAllByManufacturerId(manufacturerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody @Valid Product product) {
        return this.productService.saveProduct(product);
    }

    @PatchMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody @Valid Product product) {
        return this.productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.productService.deleteById(id);
    }
}
