package com.ukim.finki.wp.chessshop.service;

import com.ukim.finki.wp.chessshop.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

//@Service
public interface ProductService {
    List<Product> findAll();
    List<Product> findAllByManufacturerId(Long manufacturerId);
    Product findById(Long id);
    Product saveProduct(Product product, MultipartFile image) throws IOException;
    //Product saveProduct(String name, Float price,Integer quantity);        //vtor nacin
    Product update(Long id, Product product, MultipartFile image) throws IOException;
    void deleteById(Long id);
}
