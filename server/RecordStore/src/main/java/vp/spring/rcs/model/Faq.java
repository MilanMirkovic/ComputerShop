package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "dbrecordstore")

public class Faq {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Projekat projekat;
	
	private String pitanje;
	private String odgovor;
	public Faq(Long id, Projekat projekat, String pitanje, String odgovor) {
		super();
		this.id = id;
		this.projekat = projekat;
		this.pitanje = pitanje;
		this.odgovor = odgovor;
	}
	public Faq() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Projekat getProjekat() {
		return projekat;
	}
	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}
	public String getPitanje() {
		return pitanje;
	}
	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}
	public String getOdgovor() {
		return odgovor;
	}
	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}
	
	
	

}
