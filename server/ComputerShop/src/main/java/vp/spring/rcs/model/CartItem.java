package vp.spring.rcs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int quantity;
	
	@ManyToOne
	private PcComponent component;

	@ManyToOne
	private ShoppingCart shoppingCart;

	 
	public CartItem(Long id, int quantity, PcComponent component, ShoppingCart shoppingCart) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.component = component;
		this.shoppingCart = shoppingCart;
	}

	
	public CartItem() {
		super();
	}


	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PcComponent getComponent() {
		return component;
	}

	public void setComponent(PcComponent component) {
		this.component = component;
	}
	
	
	
}
