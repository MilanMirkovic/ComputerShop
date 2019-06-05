package vp.spring.rcs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(catalog = "dbrecordstore")
public class Kategorija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	@JsonIgnore
	@OneToMany(mappedBy="kategorija")
	private Set<Projekat> projekti= new HashSet<>();
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

	public Set<Projekat> getProjekti() {
		return projekti;
	}

	public void setProjekti(Set<Projekat> projekti) {
		this.projekti = projekti;
	}
	
	
	
}
