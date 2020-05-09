package com.ukim.finki.wp.chessshop.repository;

import com.ukim.finki.wp.chessshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    boolean existsByManufacturerId(Long manufacturerId);
    List<Product> findAllByManufacturerId(@Param("id") Long id);
}
