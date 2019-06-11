package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.user.SecurityUser;

public interface KorisnikRepository extends JpaRepository<SecurityUser, Long>{
	public SecurityUser findByUsername(String username);
	
}
