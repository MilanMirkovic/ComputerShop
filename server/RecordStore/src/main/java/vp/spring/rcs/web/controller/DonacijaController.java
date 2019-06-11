package vp.spring.rcs.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Donacija;
import vp.spring.rcs.model.Projekat;
import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.service.DonacijaService;
import vp.spring.rcs.service.KorisnikService;
import vp.spring.rcs.service.ProjekatService;
import vp.spring.rcs.web.dto.DonacijaDTO;
import vp.spring.rcs.web.dto.ProjekatDTO;

@RestController

public class DonacijaController {
	
	@Autowired
	DonacijaService donacijaService;
	@Autowired 
	ProjekatService projekatService;
	
	@Autowired 
	KorisnikService korisnikService;
	
	
@RequestMapping(value = "/api/donacija", method = RequestMethod.GET)
public ResponseEntity<Double> getAllDonations(){
		Double donacijeSuma = donacijaService.getDonacije();
return new ResponseEntity<>(donacijeSuma, HttpStatus.OK);
		
	}
	
	@RequestMapping( value="/api/donacije", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DonacijaDTO> create (@RequestBody DonacijaDTO dto){
		Projekat projekat=projekatService.findOne(dto.getProjekat().getId());
		SecurityUser user=korisnikService.getOne(1L);
		
		Donacija donacija=new Donacija();
		donacija.setIznos(dto.getIznos());
		
		donacija.setProjekat(projekat);
		
		donacija.setKorisnik(user);
		
		donacija=donacijaService.save(donacija);
		
		DonacijaDTO retVal=new DonacijaDTO(donacija);
		return new ResponseEntity<>( retVal, HttpStatus.CREATED);
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<Double> getAllDonationsFromUser(){
//		Double donacijeSuma = donacijaService.getDonacijeFromUser();
//		return new ResponseEntity<>(donacijeSuma, HttpStatus.OK);
//	}
	
	
	@GetMapping(value="/api/donacije/{projectId}")
	public ResponseEntity<List<DonacijaDTO>> getDonationForOneProject(@PathVariable Long projectId){
		Projekat projekat=projekatService.findOne(projectId);
		List<Donacija> donacije = donacijaService.getAll();
		
		List<Donacija> retVal=new ArrayList<>();
		
		for(Donacija d : donacije) {
			if(d.getProjekat().getId() == projekat.getId()) {
				retVal.add(d);
			}
		}
		
		List<DonacijaDTO> dtos=retVal.stream().map(d->new DonacijaDTO(d)).collect(Collectors.toList());
		return new ResponseEntity<>(dtos, HttpStatus.CREATED);
		
	}

}
