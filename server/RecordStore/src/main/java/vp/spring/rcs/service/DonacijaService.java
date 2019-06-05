package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.DonacijaRepository;
import vp.spring.rcs.model.Donacija;

@Service
public class DonacijaService {
	
	@Autowired
	DonacijaRepository donacijaRepository;
	
	public List<Donacija> getAll() {
		return donacijaRepository.findAll();
	}

	public Double getDonacije() {
		List<Donacija> donacije = donacijaRepository.findAll();
		double suma = donacije
		.stream()
		.mapToDouble(d -> d.getIznos())
		.sum();
		return suma;
		
	}
	
	public Donacija save(Donacija donacija){
		return donacijaRepository.save(donacija);
	}
	
//	public Double getDonacijeFromUser() {
//		
//	}

}
