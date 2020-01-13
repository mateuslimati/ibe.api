package com.gileadenm.ibe.api.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_MODULOS")
@SequenceGenerator(name="MODULOS_SEQ", sequenceName="modulos_seq", allocationSize = 1)
public class Modulo {
	
	public Modulo() {
		
	}
	
	public Modulo(long codigo) {
		this.codigo = codigo;
	}

	public Modulo(long codigo, @NotNull String nome, @NotNull int creditos) {
		this.codigo = codigo;
		this.nome = nome;
		this.creditos = creditos;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MODULOS_SEQ")
	private long codigo;
	
	@NotNull
	private String nome;
	
	private String professor;
	
	@ManyToMany(mappedBy = "modulos")
	private Set<Aluno> alunos;
	
	@NotNull
	private int creditos;

	public long getCodigo() {
		return codigo;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
		
}
