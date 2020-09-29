package vp.spring.rcs.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.CartItemRepository;
import vp.spring.rcs.model.CartItem;
import vp.spring.rcs.model.user.SecurityUser;

@Component
public class CartItemService {

	
	@Autowired
	CartItemRepository cartRepo;
	
	@Autowired
	UserService userService;
	public List<CartItem> findAll(){
		return cartRepo.findAll();
	}
 	
  public List<CartItem> findItemOfUser(Long id){
		return cartRepo.findOfUser(id);
	}
	
  
  public List<CartItem> findUserItems(Long id){
	  
	  List<CartItem> items=findAll();
	  
	  List<CartItem> userItems=items.stream().filter(c -> c.getShoppingCart().getUser().getId()==id).collect(Collectors.toList());
	  
	return userItems;
	  
	
  }
  public CartItem findOne(Long id) {
	 return cartRepo.getOne(id);
  }
  
  public void delete(CartItem item) {
	   cartRepo.delete(item);
  }
  
  public CartItem save(CartItem item){
	  return cartRepo.save(item);
  }

  public CartItem getOne(Long id) {
	  return cartRepo.findOne(id);
  }
  
  
//  public CartItem findByUserId(Long id) {
//	  SecurityUser user=userService.getOne(id);
//	  
//	 Set<CartItem> items=user.getShoppingCart().getCartItems();
//	 
// CartItem cartItem=items.stream().filter(c->c.getId()==)
//	  
//  }
}
