package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.CartItem;

public class CartItemDTO {

	private Long id;
	private int quantity;
	private PcComponentDTO component;
	private SecurityUserDTO korisnik;
	private ShoppingCartDTO shoppingCart;
	private Long shoppingCartId;
	public CartItemDTO(CartItem c) {
		this.id=c.getId();
		this.quantity=c.getQuantity();
		this.component=new PcComponentDTO(c.getComponent());
		this.korisnik=new SecurityUserDTO(c.getShoppingCart().getUser());
		this.shoppingCart=new ShoppingCartDTO(c.getShoppingCart());
		this.shoppingCartId=c.getShoppingCart().getId();
	}

	
	public CartItemDTO(Long id, int quantity, PcComponentDTO component, ShoppingCartDTO shoppingCart) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.component = component;
		this.shoppingCart = shoppingCart;
	}


	public Long getId() {
		return id;
	}
	

	public Long getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
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

	public PcComponentDTO getComponent() {
		return component;
	}

	public void setComponent(PcComponentDTO component) {
		this.component = component;
	}

	public SecurityUserDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(SecurityUserDTO korisnik) {
		this.korisnik = korisnik;
	}

	public ShoppingCartDTO getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartDTO shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	
	

}
