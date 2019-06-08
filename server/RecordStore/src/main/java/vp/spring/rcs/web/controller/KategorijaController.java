package vp.spring.rcs.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.model.Projekat;
import vp.spring.rcs.service.KategorijaService;
import vp.spring.rcs.web.dto.ProjekatDTO;

@RestController
//@RequestMapping(value = "/api/kategorije")

public class KategorijaController {

	@Autowired
	KategorijaService kategorijaService;

	@RequestMapping(value="api/kategorije" , method = RequestMethod.GET)
	public ResponseEntity<List<Kategorija>> getAllCategories() {
		List<Kategorija> kategorije;
		kategorije = kategorijaService.getAll();
		return new ResponseEntity<>(kategorije, HttpStatus.OK);
	}
//
//	@RequestMapping(value = "/api/kategorije/{naziv}", method = RequestMethod.GET)
//	public ResponseEntity<Kategorija> getByNaziv(@PathVariable String naziv) {
//		Kategorija kategorija = kategorijaService.findOne(naziv);
//		return new ResponseEntity<>(kategorija, HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Kategorija> create(@RequestBody Kategorija kategorija) {
//		Kategorija retVal = kategorijaService.save(kategorija);
//		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
//	}
//
//	@RequestMapping(value = "/api/kategorije/{naziv}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable String naziv) {
//		Kategorija kategorija = kategorijaService.findOne(naziv);
//		if (kategorija != null) {
//			kategorijaService.remove(naziv);
//			return new ResponseEntity<>(HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//	}

	@GetMapping(value = "api/kategorije/{id}")
	public ResponseEntity<List<ProjekatDTO>> getProjectsOfCategory(@PathVariable Long id) {
		Kategorija kategorija = kategorijaService.find(id);
		List<Projekat> projekti = new ArrayList<>();
		for (Projekat p : kategorija.getProjekti()) {
			projekti.add(p);
		}

		List<ProjekatDTO> dtos = projekti.stream().map(p -> new ProjekatDTO(p)).collect(Collectors.toList());

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

}
