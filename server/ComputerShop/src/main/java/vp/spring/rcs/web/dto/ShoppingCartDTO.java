package vp.spring.rcs.web.dto;

import java.util.Set;

import vp.spring.rcs.model.ShoppingCart;

public class ShoppingCartDTO {

	Long id;
	SecurityUserDTO user;
	Set<CartItemDTO> cartItems;
	public ShoppingCartDTO(ShoppingCart shoppingCart) {
		this.id=shoppingCart.getId();
		this.user=new SecurityUserDTO(shoppingCart.getUser());
		
	}
	
	public ShoppingCartDTO() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SecurityUserDTO getUser() {
		return user;
	}
	public void setUser(SecurityUserDTO user) {
		this.user = user;
	}
	public Set<CartItemDTO> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}

	
}
