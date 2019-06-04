package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.KategorijaRepository;
import vp.spring.rcs.model.Kategorija;

@Component
public class KategorijaService {

	@Autowired
	KategorijaRepository kategorijaRepo;
	
	public List<Kategorija> getAll(){
		return kategorijaRepo.findAll();

	}
	
	public Kategorija findOne(Long id) {
		return kategorijaRepo.findOne(id);
	}
	
}
