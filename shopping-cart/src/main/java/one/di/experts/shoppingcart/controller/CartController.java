package one.di.experts.shoppingcart.controller;

import one.di.experts.shoppingcart.model.Cart;
import one.di.experts.shoppingcart.model.Item;
import one.di.experts.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable("id") Long id, @RequestBody Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.isPresent()) {
            cart = savedCart.get();
        } else {
            cart = new Cart();
            cart.setId(id);
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable("id") Long id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable("id") Long id) {
        cartRepository.deleteById(id);
    }
}
