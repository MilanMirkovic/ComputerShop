package vp.spring.rcs.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import vp.spring.rcs.model.Donacija;
import vp.spring.rcs.model.Projekat;

@Entity
public class SecurityUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<SecurityUserAuthority> userAuthorities = new HashSet<SecurityUserAuthority>();
	
	@OneToMany(mappedBy = "korisnik")
	private Set<Donacija> donacije = new HashSet<>();

	@OneToMany(mappedBy="korisnik")
	private Set<Projekat> projekti=new HashSet<>();

	public Set<Donacija> getDonacije() {
		return donacije;
	}

	public void setDonacije(Set<Donacija> donacije) {
		this.donacije = donacije;
	}

	public Set<Projekat> getProjekti() {
		return projekti;
	}

	public void setProjekti(Set<Projekat> projekti) {
		this.projekti = projekti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<SecurityUserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(Set<SecurityUserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
}
