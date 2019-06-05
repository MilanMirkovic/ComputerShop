package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import vp.spring.rcs.model.user.SecurityUser;

@Entity
@Table(catalog = "dbrecordstore")

public class Komentar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private  SecurityUser korisnik;

	public Komentar(Long id,  SecurityUser korisnik) {
		super();
		this.id = id;
		this.korisnik = korisnik;
	}

	public Komentar() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SecurityUser getKorisnik() {
		return korisnik;
	}

	public void setKorisnik( SecurityUser korisnik) {
		this.korisnik = korisnik;
	}
	
	

}
