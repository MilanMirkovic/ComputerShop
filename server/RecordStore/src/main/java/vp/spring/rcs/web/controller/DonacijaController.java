package vp.spring.rcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.service.DonacijaService;

@RestController
@RequestMapping(value = "/api/donacija")
public class DonacijaController {
	
	@Autowired
	DonacijaService donacijaService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Double> getAllDonations(){
//		Double donacijeSuma = donacijaService.getSuma();
//	}
//	

}