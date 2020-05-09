/*
package com.ukim.finki.wp.chessshop.web.controller;

import com.ukim.finki.wp.chessshop.model.Manufacturer;
import com.ukim.finki.wp.chessshop.model.Product;
import com.ukim.finki.wp.chessshop.service.ManufacturerService;
import com.ukim.finki.wp.chessshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ManufacturerService manufacturerService;

    public ProductController(ProductService productService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String listProducts(Model model){
        List<Product> products = this.productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/add-new")
    public String addNewProduct(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturers",manufacturers);
        return "add-product";
    }

    @PostMapping
    public String saveOrUpdateProduct(Model model, @Valid Product product, BindingResult bindingResult,
                                      @RequestParam MultipartFile image) throws IOException {     //ili site so @RequestParam
        if (bindingResult.hasErrors()){
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturers);
            return "add-product";
        }

        try {
            if (product.getId() == null)
                this.productService.saveProduct(product,null);
            else
                this.productService.update(product.getId(),product,image);
        } catch (RuntimeException e){
            return "redirect:/products/add-new?error=" + e.getMessage();
        }
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(@PathVariable Long id,Model model){
        try {
            Product product = this.productService.findById(id);
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("product",product);
            model.addAttribute("manufacturers", manufacturers);
        } catch (RuntimeException e){
            return "redirect:/products?error=" + e.getLocalizedMessage();
        }
        return "add-product";
    }

    // preku Thymeleaf ne moze deleteMapping
    */
/*@DeleteMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id){
        this.productService.deleteById(id);
        return "redirect:/products";
    }*//*


    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id){
        this.productService.deleteById(id);
        return "redirect:/products";
    }
}
*/
