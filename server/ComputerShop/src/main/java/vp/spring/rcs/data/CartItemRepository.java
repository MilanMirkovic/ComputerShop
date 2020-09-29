package vp.spring.rcs.data;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.data.repository.query.Param;
import vp.spring.rcs.model.CartItem;
import vp.spring.rcs.model.PcComponent;

@Component
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	@Query("Select cart from CartItem cart left join cart.component  c left join cart.shoppingCart shp left join shp.user user where user.id =:id")
	public List<CartItem> findOfUser(@Param("id")Long id );
}
