package vp.spring.rcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Donacija;
import vp.spring.rcs.service.DonacijaService;

@RestController
@RequestMapping(value = "/api/donacija")
public class DonacijaController {
	
	@Autowired
	DonacijaService donacijaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Double> getAllDonations(){
		Double donacijeSuma = donacijaService.getDonacije();
		return new ResponseEntity<>(donacijeSuma, HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Donacija> create (@RequestBody Donacija donacija){
		Donacija retVal = donacijaService.save(donacija);
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Double> getAllDonationsFromUser(){
//		Double donacijeSuma = donacijaService.getDonacijeFromUser();
//		return new ResponseEntity<>(donacijeSuma, HttpStatus.OK);
//	}
	

}
