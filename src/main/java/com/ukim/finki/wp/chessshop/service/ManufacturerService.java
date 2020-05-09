package com.ukim.finki.wp.chessshop.service;

import com.ukim.finki.wp.chessshop.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    Manufacturer findById(Long id);
    Manufacturer save(Manufacturer manufacturer);
    Manufacturer update(Long id, Manufacturer manufacturer);
    Integer deleteById(Long id);
}
