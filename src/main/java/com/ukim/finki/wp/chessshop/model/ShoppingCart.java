/*
package com.ukim.finki.wp.chessshop.model;

import com.ukim.finki.wp.chessshop.model.enumeration.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated = LocalDateTime.now();

    @Enumerated(EnumType.STRING) // za da se socuva vo bazata kako String
    private CartStatus cartStatus = CartStatus.CREATED;

    @ManyToOne
    //@JoinColumn(name = "user_id") //go menuvame imeto na nadvoresniot kluc vo users tabelata
    private User user;

    @ManyToMany
    @JoinTable(name = "cart_products", joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))   //table posto e ManyToMany
    private List<Product> products = new ArrayList<>();

    //private List<CartItem> cartItems;
}
*/
