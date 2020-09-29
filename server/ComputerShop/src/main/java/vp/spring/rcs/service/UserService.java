package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.AuthorityRepository;
import vp.spring.rcs.data.UserRepository;
import vp.spring.rcs.model.user.SecurityAuthority;
import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.model.user.SecurityUserAuthority;

@Component
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	  @Autowired
	  private AuthorityRepository authorityRepository;
	  

	  @Autowired
	  PasswordEncoder passwordEncoder;

	public List<SecurityUser> getAll() {
		return userRepository.findAll();
	}

	public SecurityUser getOne(Long id) {
		return userRepository.findOne(id);
	}
	
	public SecurityUser save (SecurityUser user) {
		return userRepository.save(user);
	}

	 public SecurityUser findByUserName(String username) {
			return  userRepository.findByUsername(username);
		  }
	  public SecurityUser register(SecurityUser securityUser, List<String> roles) {
			if (userRepository.findByUsername(securityUser.getUsername()) != null) {
				return null; // ako vec postoji korisnik sa tim korisnickim imenom
			} else {
				// objekat korisnik vezemo sa ulogama

				// uloge su predstavljene objektom SecurityAuthority
				// za svaku ulogu, nadjemo odgovarajuci SecurityAuthority objekat
				for (String role : roles) {
					SecurityAuthority authority = authorityRepository
							.findByName(role);

					// povezemo authority sa korisnikom preko objekta
					// SecurityUserAUthority
					SecurityUserAuthority sua = new SecurityUserAuthority();
					sua.setAuthority(authority);
					sua.setUser(securityUser);
					// dodamo vezni objekat u korisnikovu listu koju ce biti
					// kaskadno perzistirana
					// zajedno sa korisnikom
					securityUser.getUserAuthorities().add(sua);
				}
				// enkodujemo sifru pre snimanja u bazu
				securityUser.setPassword(passwordEncoder.encode(securityUser.getPassword()));
				
				return userRepository.save(securityUser); // perzistira se korisnik
			}
	}
	
}
