package vp.spring.rcs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.service.KategorijaService;

@RestController
@RequestMapping(value = "/api/kategorija")

public class KategorijaController {
	
	@Autowired
	KategorijaService kategorijaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Kategorija>> getAllCategories(){
		List<Kategorija> kategorije;
		kategorije = kategorijaService.getAll();
		return new ResponseEntity<>(kategorije, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{naziv}", method = RequestMethod.GET)
	public ResponseEntity<Kategorija> getByNaziv(@PathVariable String naziv){
		Kategorija kategorija = kategorijaService.findOne(naziv);
		return new ResponseEntity<>(kategorija, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Kategorija> create (@RequestBody Kategorija kategorija){
		Kategorija retVal = kategorijaService.save(kategorija);
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{naziv}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String naziv){
		Kategorija kategorija = kategorijaService.findOne(naziv);
		if (kategorija != null) {
			kategorijaService.remove(naziv);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
