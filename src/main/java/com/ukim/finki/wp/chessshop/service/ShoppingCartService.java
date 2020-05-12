package com.ukim.finki.wp.chessshop.service;

import com.ukim.finki.wp.chessshop.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart createShoppingCart(String userId);
    ShoppingCart addProductToShoppingCart(String userId, Long productId);
    ShoppingCart removeProductFromShoppingCart(String userId, Long productId);
    ShoppingCart cancelActiveShoppingCart(String userId);
    ShoppingCart checkoutShoppingCart(String userId);
}
