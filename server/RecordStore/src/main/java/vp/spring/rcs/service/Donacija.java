package vp.spring.rcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.DonacijaRepository;

@Service
public class Donacija {
	
	@Autowired
	DonacijaRepository donacijaRepository;
	

}
