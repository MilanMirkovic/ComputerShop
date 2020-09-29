package vp.spring.rcs.web.dto;

import java.util.ArrayList;
import java.util.List;

import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.model.user.SecurityUserAuthority;

public class SecurityUserDTO {

	private Long id;

	private String username;

	private String password;

	private String firstName;

	private String lastName;

	private List<String> roles = new ArrayList<>();

	public SecurityUserDTO(SecurityUser user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		for (SecurityUserAuthority ua : user.getUserAuthorities()) {
			this.roles.add(ua.getAuthority().getName());
		}
	}

	public SecurityUserDTO() {
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	

}
