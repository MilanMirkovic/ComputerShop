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
	
	public Kategorija findOne(String naziv) {
		return kategorijaRepo.findByNaziv(naziv);
	}
	
	public Kategorija findById(Long id) {
		return kategorijaRepo.findOne(id);
	}
	
	public Kategorija save(Kategorija kategorija) {
		return kategorijaRepo.save(kategorija);
	}
	
	public void remove (String naziv) {
		Kategorija kategorija = findOne(naziv);
		kategorijaRepo.delete(kategorija.getId());
	}
	
}
