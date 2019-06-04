package vp.spring.rcs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.ProjekatRepository;
import vp.spring.rcs.model.Projekat;

@Component
public class ProjekatService {

	@Autowired
	ProjekatRepository projekatRepo;
	
	public Page<Projekat> getAll(Pageable page){
		return projekatRepo.findAll(page);
	}
}
