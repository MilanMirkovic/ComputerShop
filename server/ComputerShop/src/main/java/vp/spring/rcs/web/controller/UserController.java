package vp.spring.rcs.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.security.TokenUtils;
import vp.spring.rcs.service.UserService;
import vp.spring.rcs.web.dto.SecurityUserDTO;
import vp.spring.rcs.web.dto.LoginDTO;
import vp.spring.rcs.web.dto.SecurityUserDTO;
import vp.spring.rcs.web.dto.TokenDTO;

@RestController
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	TokenUtils tokenUtils;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            String genToken = tokenUtils.generateToken(details);
            return new ResponseEntity<TokenDTO>(new TokenDTO(genToken), 
            		HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<TokenDTO>(new TokenDTO(""), HttpStatus.BAD_REQUEST);
        }
	}
	
	
	
	@GetMapping(value="/api/user/{username}")
	public ResponseEntity<SecurityUserDTO> findByUserName(@PathVariable String username){
		SecurityUser korisnik=userService.findByUserName(username);
		
		SecurityUserDTO dto=new SecurityUserDTO(korisnik);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/api/userId/{id}")
	public ResponseEntity<SecurityUserDTO> findByUserId(@PathVariable Long id){
		SecurityUser korisnik=userService.getOne(id);
		
		SecurityUserDTO dto=new SecurityUserDTO(korisnik);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@GetMapping(value="api/users")
	public ResponseEntity<List<SecurityUserDTO>> getAll(){
		List<SecurityUser> users=userService.getAll();
		List<SecurityUserDTO> dto=users.stream().map(u -> new SecurityUserDTO(u)).collect(Collectors.toList());
		
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	public ResponseEntity<SecurityUserDTO> register(@RequestBody SecurityUserDTO userDTO) {
        SecurityUser user = new SecurityUser();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        
        user = userService.register(user, userDTO.getRoles());
        
        if (user != null) {
        	return new ResponseEntity<>(new SecurityUserDTO(user), HttpStatus.CREATED); 
        } else { // ako vec postoji korisnik sa tim korisnickim imenom
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }        
	}
}
