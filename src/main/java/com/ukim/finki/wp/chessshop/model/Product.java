package com.ukim.finki.wp.chessshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private Float price;

    private Integer quantity;

    @Lob //large obj, vo baza e kako varchar(255)
    @Column(name = "image")
    private String base64Image;

    @ManyToOne
    @NonNull
    //@JoinColumn(name = "man_id")  za menuvanje na imeto na kolonata
    private Manufacturer manufacturer;
}
