package vp.spring.rcs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import vp.spring.rcs.model.user.SecurityUser;

@Entity
public class ShoppingCart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long  id;
	
	
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	SecurityUser user;

	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.REMOVE)
	private Set<CartItem> cartItems;


	public ShoppingCart(Long id, SecurityUser user) {
		super();
		this.id = id;

		this.user = user;
	}

	
	public ShoppingCart() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public SecurityUser getUser() {
		return user;
	}


	public void setUser(SecurityUser user) {
		this.user = user;
	}


	public Set<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}



	
	
	
}
