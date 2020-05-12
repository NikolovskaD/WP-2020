/*
package com.ukim.finki.wp.chessshop.service.impl;

import com.ukim.finki.wp.chessshop.model.Product;
import com.ukim.finki.wp.chessshop.model.ShoppingCart;
import com.ukim.finki.wp.chessshop.model.User;
import com.ukim.finki.wp.chessshop.model.enumeration.CartStatus;
import com.ukim.finki.wp.chessshop.model.exceptions.ActiveShoppingCartAlreadyExists;
import com.ukim.finki.wp.chessshop.model.exceptions.ProductOutOfStockException;
import com.ukim.finki.wp.chessshop.model.exceptions.ShoppingCartIsNotActiveException;
import com.ukim.finki.wp.chessshop.repository.ShoppingCartRepository;
import com.ukim.finki.wp.chessshop.service.ProductService;
import com.ukim.finki.wp.chessshop.service.ShoppingCartService;
import com.ukim.finki.wp.chessshop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserService userService;
    private final ProductService productService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserService userService, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public ShoppingCart createShoppingCart(String userId) {
        User user = this.userService.findById(userId);
        if (this.shoppingCartRepository.findByUserUsernameAndCartStatus(userId, CartStatus.CREATED ) != null){
            throw new ActiveShoppingCartAlreadyExists();
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Transactional
    @Override
    public ShoppingCart addProductToShoppingCart(String userId, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCartOrCreateNew(userId);
        Product product = this.productService.findById(productId);
        List<Product> products = shoppingCart.getProducts();
        for (Product p : products) {
            if (p.getId().equals(productId)){
                return shoppingCart;                     // ili mozda zgolemi kolku parcinja saka da kupi?
            }
        }
        products.add(product);

        shoppingCart.setProducts(products);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    private ShoppingCart getActiveShoppingCartOrCreateNew(String userId){
        ShoppingCart shoppingCart = this.shoppingCartRepository.findByUserUsernameAndCartStatus(userId,CartStatus.CREATED);
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart();
            shoppingCart.setUser(this.userService.findById(userId));
            shoppingCart = this.shoppingCartRepository.save(shoppingCart);
        }
        return shoppingCart;
    }

    @Transactional
    @Override
    public ShoppingCart removeProductFromShoppingCart(String userId, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCartOrCreateNew(userId);
        //za ova ni e potrebno equals() implementirano
        //shoppingCart.getProducts().remove(this.productService.findById(productId));
        shoppingCart.setProducts(
                shoppingCart.getProducts().stream()
                .filter(item -> !item.getId().equals(shoppingCart.getId()))
                .collect(Collectors.toList())
        );
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart cancelActiveShoppingCart(String userId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findByUserUsernameAndCartStatus(userId,CartStatus.CREATED);
        if (shoppingCart == null)
            throw new ShoppingCartIsNotActiveException();
        shoppingCart.setCartStatus(CartStatus.CANCELED);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional   // menuvame poveke raboti, sakame da se smeni vo bazata samo ako pomine se kako treba
                     // ako se desi bilo kade da padne, nema nikakva promena da bide socuvana
    public ShoppingCart checkoutShoppingCart(String userId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findByUserUsernameAndCartStatus(userId,CartStatus.CREATED);
        if (shoppingCart == null)
            throw new ShoppingCartIsNotActiveException();

        float price = 0;
        List<Product> products = shoppingCart.getProducts();

        for (Product product : products) {
            if (product.getQuantity() <= 0)
                throw new ProductOutOfStockException(product.getId());
            product.setQuantity(product.getQuantity() - 1);
            price += product.getPrice();
        }

        //paymentService.pay(price)

        shoppingCart.setProducts(products);
        shoppingCart.setCartStatus(CartStatus.FINISHED);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
*/
