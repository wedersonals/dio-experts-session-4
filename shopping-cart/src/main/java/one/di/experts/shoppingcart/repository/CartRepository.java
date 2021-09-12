package one.di.experts.shoppingcart.repository;

import one.di.experts.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

    Cart findByCustomerId(Long customerId);
}
