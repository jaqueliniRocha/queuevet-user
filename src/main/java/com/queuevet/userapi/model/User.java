package com.queuevet.userapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nameProp;
	private String namePet;
	private String email;
	private String cpf;
	private String password;

	public void setId(Long id) {
		this.id = id;
	}
	public String getNameProp() {
		return nameProp;
	}
	public void setNameProp(String nameProp) {
		this.nameProp = nameProp;
	}

	public String getNamePet(){
		return namePet;
	}
	public void setNamePet(String namePet){
		this.namePet = namePet;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
