package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.rcs.model.ShoppingCart;
@Component
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
