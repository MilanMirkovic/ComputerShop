package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.Kategorija;

public class KategorijaDTO {
	
	Long id;
	private String naziv;
	
	public KategorijaDTO(Kategorija dto) {
		this.id=dto.getId();
		this.naziv=dto.getNaziv();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public KategorijaDTO() {
	
	}
	
	
	
}
