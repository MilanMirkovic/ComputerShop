package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kategorija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	private String naziv;

	public Kategorija(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public Kategorija() {
		super();
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
	
	
	
}
