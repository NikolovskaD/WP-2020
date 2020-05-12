package com.ukim.finki.wp.chessshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    private String description;

    private Float price;

    private Integer quantity;

    /*@Lob //large obj, vo baza e kako varchar(255)
    @Column(name = "image")
    private String base64Image;*/

    private String imgUrl;

    @ManyToOne
    @NonNull
    //@JoinColumn(name = "man_id")  za menuvanje na imeto na kolonata
    private Manufacturer manufacturer;

    /*@JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<ShoppingCart> shoppingCarts;*/

}
