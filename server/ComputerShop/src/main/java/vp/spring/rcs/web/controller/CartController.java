package vp.spring.rcs.web.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.CartItem;
import vp.spring.rcs.model.PcComponent;
import vp.spring.rcs.model.ShoppingCart;
import vp.spring.rcs.service.BrandService;
import vp.spring.rcs.service.CartItemService;
import vp.spring.rcs.service.PcComponentService;
import vp.spring.rcs.service.ShoppingCartService;
import vp.spring.rcs.web.dto.AddToCartDTO;
import vp.spring.rcs.web.dto.CartItemDTO;
import vp.spring.rcs.web.dto.ShoppingCartDTO;

@RestController
public class CartController {

	@Autowired
	PcComponentService componentService;

	@Autowired
	BrandService brandService;

	@Autowired
	CartItemService cartItemService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@GetMapping(value = "api/cartItem/user/{id}")
	public ResponseEntity<List<CartItemDTO>> findCartItemsOfUser(@PathVariable Long id) {
		List<CartItem> items = cartItemService.findUserItems(id);
		List<CartItemDTO> dto = items.stream().map(c -> new CartItemDTO(c)).collect(Collectors.toList());

		// Page<PcComponentDTO> retVal=new
		// PageImpl<>(dto,page,components.getTotalElements());

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping(value = "api/addToCart")
	public ResponseEntity<CartItemDTO> save(@RequestBody AddToCartDTO addProduct) {
		// proverava da li vec u korpi postoji taj item;
		List<CartItem> items = cartItemService.findAll();
		// ako je nasao taj item zapamti taj cartItem
		
	Optional<CartItem> exist=items.stream().filter(c -> c.getComponent().getId() == addProduct.getComponentId()).findAny();

		if (exist.isPresent()) {
			
			addProduct.setQuantity(exist.get().getQuantity() + 1);
			updateCart(exist.get().getId(), addProduct);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
	
			
			PcComponent component = componentService.getOne(addProduct.getComponentId());
			ShoppingCart shoppingCart = shoppingCartService.findById(addProduct.getShoppingCartId());

			CartItem cartItem = new CartItem();
			cartItem.setComponent(component);
			cartItem.setQuantity(addProduct.getQuantity());
			cartItem.setShoppingCart(shoppingCart);

			cartItemService.save(cartItem);

			CartItemDTO dto = new CartItemDTO(cartItem);

			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "api/addToCart/{cartId}")
	public ResponseEntity<CartItemDTO> updateCart(@PathVariable Long cartId, @RequestBody AddToCartDTO addProduct) {
		CartItem cartItem = cartItemService.getOne(cartId);

		PcComponent component = componentService.getOne(addProduct.getComponentId());
		ShoppingCart shoppingCart = shoppingCartService.findById(addProduct.getShoppingCartId());
		cartItem.setId(cartItem.getId());
		cartItem.setComponent(component);
		cartItem.setQuantity(addProduct.getQuantity());
		cartItem.setShoppingCart(shoppingCart);

		cartItemService.save(cartItem);

		

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "api/deleteCartItem/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
		CartItem item = cartItemService.getOne(id);

		if (item != null) {
			cartItemService.delete(item);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "api/shoppingCart/{userName}")
	public ResponseEntity<ShoppingCartDTO> getByUserId(@PathVariable String userName) {
		ShoppingCart cart = shoppingCartService.findByUser(userName);
		ShoppingCartDTO dto = new ShoppingCartDTO(cart);
		if(cart == null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
