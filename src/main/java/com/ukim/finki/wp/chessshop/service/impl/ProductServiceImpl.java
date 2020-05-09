package com.ukim.finki.wp.chessshop.service.impl;

import com.ukim.finki.wp.chessshop.model.Manufacturer;
import com.ukim.finki.wp.chessshop.model.Product;
import com.ukim.finki.wp.chessshop.model.exceptions.ProductNotFoundException;
import com.ukim.finki.wp.chessshop.repository.ProductRepository;
import com.ukim.finki.wp.chessshop.service.ManufacturerService;
import com.ukim.finki.wp.chessshop.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerService manufacturerService;

    public ProductServiceImpl(ProductRepository productRepository, ManufacturerService manufacturerService) {
        this.productRepository = productRepository;
        this.manufacturerService = manufacturerService;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> findAllByManufacturerId(Long manufacturerId) {
        return this.productRepository.findAllByManufacturerId(manufacturerId);
    }

//    @Override
//    public Optional<Product> findById(Long id) {
//        return this.productRepository.findById(id);
//    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product saveProduct(Product product, MultipartFile image) throws IOException {
        Manufacturer manufacturer = this.manufacturerService.findById(product.getManufacturer().getId());
        product.setManufacturer(manufacturer);

        if (image != null){
            byte[] imageBytes = image.getBytes();
            String base64Img = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(imageBytes));
            product.setBase64Image(base64Img);
        }

        return this.productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product, MultipartFile image) throws IOException {
        Product updatedProduct = this.findById(id);
        Manufacturer manufacturer = this.manufacturerService.findById(product.getManufacturer().getId());
        updatedProduct.setManufacturer(manufacturer);
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());

        if (image != null){
            byte[] imageBytes = image.getBytes();
            String base64Img = String.format("data:%s;base64,%s", image.getContentType(), Base64.getEncoder().encodeToString(imageBytes));
            updatedProduct.setBase64Image(base64Img);
        }

        return this.productRepository.save(updatedProduct);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
