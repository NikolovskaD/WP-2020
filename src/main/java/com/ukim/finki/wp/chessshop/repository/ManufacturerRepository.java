package com.ukim.finki.wp.chessshop.repository;

import com.ukim.finki.wp.chessshop.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {

    // sekogas da se importira od spring a ne od javax !!!
    @Transactional
    Integer removeById(Long id);
}
