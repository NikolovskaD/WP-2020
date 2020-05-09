/*
package com.ukim.finki.wp.chessshop.web.rest;

import com.ukim.finki.wp.chessshop.model.ShoppingCart;
import com.ukim.finki.wp.chessshop.service.AuthService;
import com.ukim.finki.wp.chessshop.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping-carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final AuthService authService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, AuthService authService) {
        this.shoppingCartService = shoppingCartService;
        this.authService = authService;
    }

    @PostMapping
    public ShoppingCart createShoppingCart(){
        return this.shoppingCartService.createShoppingCart(this.authService.getCurrentUserId());
    }

    @PatchMapping("/{productId}/products")
    public ShoppingCart addProductToShoppingCart(@PathVariable Long productId){
        return this.shoppingCartService.addProductToShoppingCart(this.authService.getCurrentUserId(),productId);
    }

    @DeleteMapping("/{productId}/products")
    public ShoppingCart removeProductFromShoppingCart(@PathVariable Long productId){
        return this.shoppingCartService.removeProductFromShoppingCart(this.authService.getCurrentUserId(),productId);
    }

    @DeleteMapping
    public ShoppingCart cancelActiveShoppingCart(){
        return this.shoppingCartService.cancelActiveShoppingCart(this.authService.getCurrentUserId());
    }

    @PostMapping("/checkout")
    public ShoppingCart checkoutShoppingCart(){
        return this.shoppingCartService.checkoutShoppingCart(this.authService.getCurrentUserId());
    }
}
*/
