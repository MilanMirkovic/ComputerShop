package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.KorisnikRepository;
import vp.spring.rcs.model.Korisnik;

@Component
public class KorisnikService {

	@Autowired
	KorisnikRepository korisnikRepo;

	public List<Korisnik> getAll() {
		return korisnikRepo.findAll();
	}

	public Korisnik getOne(Long id) {
		return korisnikRepo.findOne(id);
	}
}
