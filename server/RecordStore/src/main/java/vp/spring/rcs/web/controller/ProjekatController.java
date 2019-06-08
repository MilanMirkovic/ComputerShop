package vp.spring.rcs.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.model.Projekat;
import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.service.KategorijaService;
import vp.spring.rcs.service.KorisnikService;
import vp.spring.rcs.service.ProjekatService;
import vp.spring.rcs.web.dto.ProjekatDTO;


@RestController
public class ProjekatController {

	@Autowired
	ProjekatService projekatService;
	
	@Autowired
	KategorijaService kategorijaService;
	
	@Autowired
	KorisnikService korisnikService;
	
	@GetMapping(value="/api/projekti")
	public ResponseEntity<Page<ProjekatDTO>> getAllProjects(Pageable page){
	
		Page<Projekat> projekti= projekatService.getAll(page);
		
		List<ProjekatDTO> dtos=projekti.getContent().stream().map(p->new ProjekatDTO(p)).collect(Collectors.toList());
	
		Page<ProjekatDTO> retVal=new PageImpl<>(dtos,page,projekti.getTotalElements());
		
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/api/projekti")
	public ResponseEntity<ProjekatDTO> createProject(@RequestBody ProjekatDTO projekat){
		
		Kategorija novaKategorija=kategorijaService.find(projekat.getKategorija().getId());
		
		SecurityUser user= korisnikService.getOne(projekat.getKorisnik().getId());
		Projekat novi=new Projekat();
		novi.setNaziv(projekat.getNaziv());
		novi.setKategorija(novaKategorija);
		novi.setOpis(projekat.getOpis());
		novi.setKorisnik(user);
		
		novi=projekatService.save(novi);
		
		ProjekatDTO dto=new ProjekatDTO(novi);
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);		
	}
	
	
	@GetMapping(value="/api/projekti/{id}")
	public ResponseEntity<ProjekatDTO> getOne(@PathVariable Long id){
		Projekat projekat=projekatService.findOne(id);
		ProjekatDTO dto=new ProjekatDTO(projekat);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
//	private List<ProjekatDTO> convertToDTOs(List<Projekat> projekti){
//		List<ProjekatDTO> retVal=new ArrayList<>();
//		List<Projekat> projektiLista=projekatService.findAll();
//		for(Projekat p : projektiLista) {
//			ProjekatDTO dto=new ProjekatDTO(p);
//			retVal.add(dto);
//		}
//		return retVal;
//	}
//	

}
