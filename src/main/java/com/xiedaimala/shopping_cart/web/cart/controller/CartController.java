package com.xiedaimala.shopping_cart.web.cart.controller;

import com.xiedaimala.shopping_cart.web.cart.model.CartItem;
import com.xiedaimala.shopping_cart.web.cart.model.CartItemDao;
import com.xiedaimala.shopping_cart.web.product.model.Product;
import com.xiedaimala.shopping_cart.web.product.model.ProductDao;
import com.xiedaimala.shopping_cart.web.user.model.User;
import com.xiedaimala.shopping_cart.web.user.model.UserDao;
import com.xiedaimala.shopping_cart.web.cart.view.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private UserDao userDao;
    private ProductDao productDao;
    private CartItemDao cartItemDao;

    public CartController(UserDao userDao, ProductDao productDao, CartItemDao cartItemDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.cartItemDao = cartItemDao;
    }

    /**
     * List cart items
     */
    @GetMapping("/cartItems")
    public ResponseEntity<ListCartItemsResponse> listCartItems() {
        List<CartItem> items = cartItemDao.findAll();
        return new ResponseEntity<>(new ListCartItemsResponse(items), HttpStatus.OK);
    }

    /**
     * Get cart item
     */
    @GetMapping("/cartItems/{cartItemId")
    public ResponseEntity<GetCartItemResponse> getCartItem(@PathVariable long cartItemId) {
        CartItem item = cartItemDao.getById(cartItemId);

        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetCartItemResponse(item), HttpStatus.OK);
        }
    }

    /**
     * Create (Add) product to an item
     */
    @PostMapping("/cartItems")
    public ResponseEntity<CreateCartItemResponse> createCartItem(@RequestBody CreateCartItemRequest createCartItemRequest) {
        User user = userDao.getById(createCartItemRequest.getUserId());
        Product product = productDao.getById(createCartItemRequest.getProductId());
        CartItem cartItem = cartItemDao.save(new CartItem(user, product, createCartItemRequest.getQuantity()));

        return new ResponseEntity<>(new CreateCartItemResponse(cartItem), HttpStatus.CREATED);
    }

    /**
     * Update cart item
     */
    @PutMapping("/cartItems/{cartItemId}")
    public ResponseEntity<UpdateCartItemResponse> updateCartItem(@PathVariable long cartItemId, @RequestBody UpdateCartItemRequest updateCartItemRequest) {
        CartItem cartItem = cartItemDao.getById(cartItemId);

        if (cartItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cartItem.setQuantity(updateCartItemRequest.getQuantity());
        cartItem = cartItemDao.save(cartItem);

        return new ResponseEntity<>(new UpdateCartItemResponse(cartItem), HttpStatus.OK);
    }

    /**
     * Remove cart item
     */
    @DeleteMapping("/cartItems/{cartItemId}")
    public ResponseEntity deleteCartItem(@PathVariable long cartItemId) {
        CartItem cartItem = cartItemDao.getById(cartItemId);

        if (cartItem == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        cartItemDao.delete(cartItem);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
