/*
package com.ukim.finki.wp.chessshop.web.rest;

import com.ukim.finki.wp.chessshop.model.ShoppingCart;
import com.ukim.finki.wp.chessshop.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @PostMapping
    public ShoppingCart createShoppingCart(@RequestParam String userId){
        return this.shoppingCartService.createShoppingCart(userId);
    }

    @PatchMapping("/{productId}/products")
    public ShoppingCart addProductToShoppingCart(@PathVariable Long productId, @RequestParam String userId){
        return this.shoppingCartService.addProductToShoppingCart(userId, productId);
    }

    @DeleteMapping("/{productId}/products")
    public ShoppingCart removeProductFromShoppingCart(@PathVariable Long productId, @RequestParam String userId){
        return this.shoppingCartService.removeProductFromShoppingCart(userId,productId);
    }

    @DeleteMapping
    public ShoppingCart cancelActiveShoppingCart(@RequestParam String userId){
        return this.shoppingCartService.cancelActiveShoppingCart(userId);
    }

    @PostMapping("/checkout")
    public ShoppingCart checkoutShoppingCart(@RequestParam String userId){
        return this.shoppingCartService.checkoutShoppingCart(userId);
    }
}
*/
