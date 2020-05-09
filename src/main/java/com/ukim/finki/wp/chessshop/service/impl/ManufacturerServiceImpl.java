package com.ukim.finki.wp.chessshop.service.impl;

import com.ukim.finki.wp.chessshop.model.Manufacturer;
import com.ukim.finki.wp.chessshop.model.exceptions.ManufacturerNotFoundException;
import com.ukim.finki.wp.chessshop.model.exceptions.ThisManufacturerHasProductsException;
import com.ukim.finki.wp.chessshop.repository.ManufacturerRepository;
import com.ukim.finki.wp.chessshop.repository.ProductRepository;
import com.ukim.finki.wp.chessshop.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ProductRepository productRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Long id) {
        return this.manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return this.manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer update(Long id, Manufacturer manufacturer) {
        Manufacturer updatedManufacturer = this.findById(id);
        updatedManufacturer.setAddress(manufacturer.getAddress());
        updatedManufacturer.setName(manufacturer.getName());
        return this.manufacturerRepository.save(updatedManufacturer);
    }

    @Override
    public Integer deleteById(Long id) {
        Manufacturer manufacturer = this.findById(id);
        if (this.productRepository.existsByManufacturerId(id))
            throw new ThisManufacturerHasProductsException(id);
        // ili smeni da vraka void, vaka i u repo praves ja naveduvas f-jata
        return this.manufacturerRepository.removeById(id);
    }
}
