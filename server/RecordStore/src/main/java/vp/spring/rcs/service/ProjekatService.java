package vp.spring.rcs.service;


import java.util.List;

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
	public List<Projekat> findAll(){
		return projekatRepo.findAll();
	}
	
	public Projekat save(Projekat projekat) {
		return projekatRepo.save(projekat);
	}
	
	public Projekat findOne(Long id) {
		return projekatRepo.findOne(id);
	}
}
