package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "RecordStore", name = "Vest")


public class Vest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String tekst;
	@ManyToOne(fetch = FetchType.EAGER)
	private Projekat projekat;
	
	
	public Vest(Long id, String tekst, Projekat projekat) {
		super();
		this.id = id;
		this.tekst = tekst;
		this.projekat = projekat;
	}


	public Vest() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTekst() {
		return tekst;
	}


	public void setTekst(String tekst) {
		this.tekst = tekst;
	}


	public Projekat getProjekat() {
		return projekat;
	}


	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	} 
	

	
}
