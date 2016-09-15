package br.com.slapp.genda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 	USUARIO_ID INT(10) AUTO_INCREMENT PRIMARY KEY,
	USUARIO_NM VARCHAR(50) NOT NULL,
	EMAIL 	   VARCHAR(50) NOT NULL,
  CONTRASENA VARCHAR(50) NOT NULL,
	INACTIVO	 INT(1) UNSIGNED NOT NULL DEFAULT '0'
 * */

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "USUARIO_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "USUARIO_NM",nullable=false,length=50)
	private String nome;
	
	@Column(name = "EMAIL",nullable=false,length=50)
	private String email;
	
	@Column(name = "CONTRASENA",nullable=false,length=50)
	private String senha;
	
	@Column(name = "INACTIVO", columnDefinition="INT(1)")
	private Boolean inativo;

	public Usuario() {
	
	}
	
	public Usuario(String nome, String senha, String email) {
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}

}
