package com.gileadenm.ibe.api.DTO;

import com.gileadenm.ibe.api.models.Modulo;

public class ModuloDTO {
	
	private long codigo;
	
	private String nome;
	
	private String professor;
	
	private int creditos;

	public long getCodigo() {
		return codigo;
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
	
	public ModuloDTO() {
	}
	
	public ModuloDTO(Modulo modulo) {
		this.codigo = modulo.getCodigo();
		this.nome = modulo.getNome();
		this.professor = modulo.getProfessor();
		this.creditos = modulo.getCreditos();
	}
	
}
