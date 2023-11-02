package com.manik.apis.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private Integer id;
	
	@NotEmpty
	@Size(min = 4,message = "name should be atleast 4 characters long")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=3,max = 10,message = "password length should be in the range of 3 to 10")
	private String password;
	
	@NotEmpty
	@Size(min = 5, message = "about section should be atleast 5 chars long")
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	

}
