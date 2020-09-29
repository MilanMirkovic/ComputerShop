package vp.spring.rcs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.ShoppingCartRepository;
import vp.spring.rcs.model.ShoppingCart;
import vp.spring.rcs.model.user.SecurityUser;

@Component
public class ShoppingCartService {

	
	@Autowired
	ShoppingCartRepository cartRepo;
	UserService userService;
	
	public ShoppingCart findById(Long id) {
		return cartRepo.findOne(id);
	}
	
	public List<ShoppingCart> getAll(){
		return cartRepo.findAll();
	}
	
	
	public ShoppingCart findByUser(String username) {
	List<ShoppingCart> carts=getAll();
	ShoppingCart retVal=carts.stream().filter(c->c.getUser().getUsername().equals(username)).findFirst().get();
	if(retVal!=null) {
	return retVal;
	}else {
		return null;
	}
	
	}
}
