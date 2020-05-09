package com.ukim.finki.wp.chessshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "manufacturers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, message = "Name should not be empty!")
    private String name;

    private String address;

    // ne e preporaclivo OneToMany rel. da se pisuvaat
/*    @OneToMany(mappedBy = "manufacturer")
    List<Product> products;*/
}
