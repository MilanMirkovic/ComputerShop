package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.Donacija;

public class DonacijaDTO {

	double iznos;
	double zeljeniIznos;
	ProjekatDTO projekat;
//	KorisnikDTO korisnik;
	
	public DonacijaDTO(Donacija donacija) {
		this.projekat=new ProjekatDTO(donacija.getProjekat());
//		this.korisnik=new KorisnikDTO(donacija.getKorisnik());
		this.iznos=donacija.getIznos();
		this.zeljeniIznos=donacija.getZeljeniIznos();
	}

	public ProjekatDTO getProjekat() {
		return projekat;
	}

	public void setProjekat(ProjekatDTO projekat) {
		this.projekat = projekat;
	}
	

//	public KorisnikDTO getKorisnik() {
//		return korisnik;
//	}
//
//	public void setKorisnik(KorisnikDTO korisnik) {
//		this.korisnik = korisnik;
//	}

	public double getZeljeniIznos() {
		return zeljeniIznos;
	}

	public void setZeljeniIznos(double zeljeniIznos) {
		this.zeljeniIznos = zeljeniIznos;
	}

	public DonacijaDTO() {
		super();
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	
	
	
}
