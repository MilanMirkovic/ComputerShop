package vp.spring.rcs.web.dto;



import vp.spring.rcs.model.Projekat;
import vp.spring.rcs.model.user.SecurityUser;

public class ProjekatDTO {

	Long id;
	private String naziv;
	private String opis;
	private KategorijaDTO kategorija;
	private KorisnikDTO korisnik;
	
	public ProjekatDTO(Projekat projekat) {
		this.id=projekat.getId();
		this.naziv=projekat.getNaziv();
		this.opis=projekat.getOpis();
		this.kategorija=new KategorijaDTO(projekat.getKategorija());
		this.korisnik=new KorisnikDTO(projekat.getKorisnik());
		
	}
	

	public ProjekatDTO() {
	
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

	public KategorijaDTO getKategorija() {
		return kategorija;
	}

	public void setKategorija(KategorijaDTO kategorija) {
		this.kategorija = kategorija;
	}

	public KorisnikDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
}
