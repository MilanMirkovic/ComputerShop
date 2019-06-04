package vp.spring.rcs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "dbrecordstore")
public class Korisnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private String ime;
	private String prezime;
	private String password;
	private String username;
	private String uloga;

	@OneToMany(mappedBy = "korisnik")
	private Set<Donacija> donacije = new HashSet<>();

	@OneToMany(mappedBy="korisnik")
	private Set<Projekat> projekti=new HashSet<>();
	public Korisnik(Long id, String ime, String prezime, String password, String username, String ulog) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.password = password;
		this.username = username;
		this.uloga = uloga;

	}
	
	

	public Set<Projekat> getProjekti() {
		return projekti;
	}



	public void setProjekti(Set<Projekat> projekti) {
		this.projekti = projekti;
	}



	public Set<Donacija> getDonacije() {
		return donacije;
	}


	public void setDonacije(Set<Donacija> donacije) {
		this.donacije = donacije;
	}


	public Korisnik() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	

}
