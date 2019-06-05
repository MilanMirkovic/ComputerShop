package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.KorisnikRepository;
import vp.spring.rcs.model.user.SecurityUser;

@Component
public class KorisnikService {

	@Autowired
	KorisnikRepository korisnikRepo;

	public List<SecurityUser> getAll() {
		return korisnikRepo.findAll();
	}

	public SecurityUser getOne(Long id) {
		return korisnikRepo.findOne(id);
	}
}
