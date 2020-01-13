package com.gileadenm.ibe.api.DTO;

import com.gileadenm.ibe.api.models.Aluno;

public class AlunoDTO {

	private long matricula;

	private String nome;
	
	private String email;
	
	private String cpf;
	
	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public AlunoDTO() {
		
	}
	
	public AlunoDTO(Aluno aluno) {
		this.matricula = aluno.getMatricula();
		this.nome = aluno.getNome();
		this.email = aluno.getEmail();
		this.cpf = aluno.getCpf();
	}
}
