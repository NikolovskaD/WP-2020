/*
package com.ukim.finki.wp.chessshop.repository;

import com.ukim.finki.wp.chessshop.model.ShoppingCart;
import com.ukim.finki.wp.chessshop.model.enumeration.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    //nema potreba od transakcii posto ne menuvame nisto vo bazata

    ShoppingCart findByUserUsernameAndCartStatus(String username, CartStatus cartStatus);
    //moze istoto i so
    //boolean existsByUserAndUsernameAndStatus(String username, CartStatus cartStatus);
}
*/
