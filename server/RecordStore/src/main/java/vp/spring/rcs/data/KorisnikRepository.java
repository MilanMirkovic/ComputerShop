package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	
}
