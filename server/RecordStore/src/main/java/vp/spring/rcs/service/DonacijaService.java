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
	
	private List<Donacija> getAll() {
		return donacijaRepository.findAll();
	}

////	private Double getSuma() {
////		double Suma; //
//	}

}
