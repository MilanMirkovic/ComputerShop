package vp.spring.rcs.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Faq;
import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.model.Projekat;
import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.service.FaqService;
import vp.spring.rcs.service.KategorijaService;
import vp.spring.rcs.service.KorisnikService;
import vp.spring.rcs.service.ProjekatService;
import vp.spring.rcs.web.dto.FaqDTO;
import vp.spring.rcs.web.dto.ProjekatDTO;

@RestController
public class ProjekatController {

	@Autowired
	ProjekatService projekatService;

	@Autowired
	KategorijaService kategorijaService;

	@Autowired
	KorisnikService korisnikService;

	@Autowired
	FaqService faqService;
	
	@GetMapping(value = "/api/projekti")
	public ResponseEntity<Page<ProjekatDTO>> getAllProjects(Pageable page) {

		Page<Projekat> projekti = projekatService.getAll(page);

		List<ProjekatDTO> dtos = projekti.getContent().stream().map(p -> new ProjekatDTO(p))
				.collect(Collectors.toList());

		Page<ProjekatDTO> retVal = new PageImpl<>(dtos, page, projekti.getTotalElements());

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/api/projekti")
	public ResponseEntity<ProjekatDTO> createProject(@RequestBody ProjekatDTO projekat) {

		Kategorija novaKategorija = kategorijaService.find(projekat.getKategorija().getId());

		SecurityUser user = korisnikService.getOne(projekat.getKorisnik().getId());
		Projekat novi = new Projekat();
		novi.setNaziv(projekat.getNaziv());
		novi.setKategorija(novaKategorija);
		novi.setOpis(projekat.getOpis());
		novi.setKorisnik(user);

		novi = projekatService.save(novi);

		ProjekatDTO dto = new ProjekatDTO(novi);

		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@GetMapping(value = "/api/projekti/{id}")
	public ResponseEntity<ProjekatDTO> getOne(@PathVariable Long id) {
		Projekat projekat = projekatService.findOne(id);
		ProjekatDTO dto = new ProjekatDTO(projekat);

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	private List<ProjekatDTO> convertToDTOs(List<Projekat> projekti){
	List<ProjekatDTO> retVal=new ArrayList<>();
		List<Projekat> projektiLista=projekatService.findAll();
	for(Projekat p : projektiLista) {
		ProjekatDTO dto=new ProjekatDTO(p);
			retVal.add(dto);
	}
	return retVal;
}
	

	@GetMapping(value="api/projekti/{id}/faq")
	public ResponseEntity<List<FaqDTO>> getFaqs(@PathVariable Long id){
		List<Faq> faqs=faqService.getAll();
		
		List<Faq> selected=faqs.stream().filter(f -> f.getProjekat().getId() == id).collect(Collectors.toList());
		
		List<FaqDTO> dtos=selected.stream().map(f -> new FaqDTO(f)).collect(Collectors.toList());
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	
	@GetMapping(value = "/api/projekti/random")
	public ResponseEntity<List<ProjekatDTO>> randomProjects() {
		List<Projekat> projekti = projekatService.findAll();

		List<Projekat> randomProjekti = projekatService.randomProjects(projekti);

		List<ProjekatDTO> dtos = randomProjekti.stream().map(p -> new ProjekatDTO(p)).collect(Collectors.toList());
		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value="/api/projekat/{naziv}")
	public ResponseEntity<List<ProjekatDTO>> findByName(@PathVariable String naziv){
		List<Projekat> projekti = projekatService.findAll();
		
		List<Projekat> match=new ArrayList<>();
		
		for(Projekat p : projekti) {
			if(p.getNaziv().toLowerCase().contains(naziv.toLowerCase())) {
				match.add(p);
			}
		}
		List<ProjekatDTO> dtos = match.stream().map(p -> new ProjekatDTO(p)).collect(Collectors.toList());
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

}
