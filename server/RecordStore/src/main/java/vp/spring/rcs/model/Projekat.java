package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(catalog="dbrecordstore")
public class Projekat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String naziv;
	private String opis;
	private Katergorija kategorija;
	private Faq faq;
	private Vest vest;
	private Korisnik korisnik;
	public Projekat(Long id, String naziv, String opis, Katergorija kategorija, Faq faq, Vest vest, Korisnik korisnik) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.kategorija = kategorija;
		this.faq = faq;
		this.vest = vest;
		this.korisnik = korisnik;
	}
	public Projekat() {
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
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Katergorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Katergorija kategorija) {
		this.kategorija = kategorija;
	}
	public Faq getFaq() {
		return faq;
	}
	public void setFaq(Faq faq) {
		this.faq = faq;
	}
	public Vest getVest() {
		return vest;
	}
	public void setVest(Vest vest) {
		this.vest = vest;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
}
