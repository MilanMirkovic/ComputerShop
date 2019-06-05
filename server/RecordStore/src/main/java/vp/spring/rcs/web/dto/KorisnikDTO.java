package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.user.SecurityUser;

public class KorisnikDTO {

private Long id;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	
	public KorisnikDTO(SecurityUser korisnik) {
		this.id=korisnik.getId();
		this.username=korisnik.getUsername();
		this.password=korisnik.getPassword();
		this.firstName=korisnik.getFirstName();
		this.lastName=korisnik.getLastName();
	}
	
	public KorisnikDTO() {}

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


}
