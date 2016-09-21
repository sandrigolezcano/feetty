package br.com.slapp.genda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
CREATE TABLE EMPRESAS(
	EMPRESA_ID 		INT(10) AUTO_INCREMENT PRIMARY KEY,
	EMPRESA_NM 		VARCHAR(50) NOT NULL,
	EMPRESA 	   	INT(10), -- Grupo de Empresas / Matriz
	INACTIVO	   	INT(1) UNSIGNED NOT NULL DEFAULT '0'
)
insert into EMPRESAS(EMPRESA_ID,EMPRESA_NM)
     VALUES(1000,'CLUB DEPORTIVO BLAH SRL')


*/
@Entity
@Table(name = "empresas")
public class Empresa {
	
	@Id
	@GeneratedValue
	@Column(name = "EMPRESA_ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "EMPRESA_NM", nullable = false, length = 50)
	private String nome;

	@Column(name = "EMPRESA",  nullable = true)
	private Integer empresa;

	@Column(name = "INACTIVO", columnDefinition = "INT(1)")
	private Boolean inativo;
	
	public Empresa(){
		
	}
	
	public Empresa(String nome, Integer empresa) {
		this.nome = nome;
		this.empresa = empresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}

	
}
