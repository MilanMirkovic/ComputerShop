package vp.spring.rcs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vp.spring.rcs.model.user.SecurityUser;
@Entity
@Table(catalog="dbrecordstore")
public class Projekat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	private String naziv;
	private String opis;
	
	@ManyToOne
	private Kategorija kategorija;
	@JsonIgnore
	@OneToMany(mappedBy="projekat")
	private Set<Faq> faq=new HashSet<>();

	private String imageUlr;
	@JsonIgnore
	@OneToMany(mappedBy="projekat")
	private Set<Vest> vesti=new HashSet<>();
	@ManyToOne
	private SecurityUser korisnik;
	public Projekat(String imageUrl, Long id, String naziv, String opis, Kategorija kategorija,  SecurityUser korisnik) {
		super();
		this.imageUlr=imageUrl;
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.kategorija = kategorija;
	
		this.korisnik = korisnik;
	}
	
	public String getImageUlr() {
		return imageUlr;
	}

	public void setImageUlr(String imageUlr) {
		this.imageUlr = imageUlr;
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
	public Kategorija getKategorija() {
		return kategorija;
	}
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	
	public Set<Faq> getFaq() {
		return faq;
	}
	public void setFaq(Set<Faq> faq) {
		this.faq = faq;
	}
	public Set<Vest> getVesti() {
		return vesti;
	}
	public void setVesti(Set<Vest> vesti) {
		this.vesti = vesti;
	}
	public SecurityUser getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(SecurityUser korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
}
