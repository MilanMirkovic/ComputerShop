package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.web.dto.ProjekatDTO;


@Entity
@Table(catalog = "dbrecordstore")

public class Donacija {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private double iznos;
	private double zeljeniIznos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Projekat projekat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private SecurityUser korisnik;

	public Donacija(Long id,double zeljeniIznos, double iznos, double suma, Projekat projekat, SecurityUser korisnik) {
		super();
		this.id = id;
		this.iznos = iznos;
		this.zeljeniIznos=zeljeniIznos;
		this.projekat = projekat;
		this.korisnik = korisnik;
	}
	

	public double getZeljeniIznos() {
		return zeljeniIznos;
	}


	public void setZeljeniIznos(double zeljeniIznos) {
		this.zeljeniIznos = zeljeniIznos;
	}


	public Donacija() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	
	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}

	public  SecurityUser getKorisnik() {
		return korisnik;
	}

	public void setKorisnik( SecurityUser korisnik) {
		this.korisnik = korisnik;
	}

	
	


}
