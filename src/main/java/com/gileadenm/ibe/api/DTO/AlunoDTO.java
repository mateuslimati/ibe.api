package com.gileadenm.ibe.api.DTO;

import java.util.Date;

import com.gileadenm.ibe.api.models.Aluno;

public class AlunoDTO {

	private long matricula;

	private String nome;
	
	private String email;
	
	private String cpf;
	
	private Date data_nasc;

	private String estado_civil;

	private String sexo;

	private String cor_etnia;

	private String situacao_ocupacional;

	private String nome_empresa;

	private String funcao;

	private String endereco;
	
	private int numero;

	private String bairro;

	private String cidade;

	private String uf;

	private String cep;

	private String rg;

	private Date emissao;

	private String nacionalidade;

	private String naturalidade;

	private String mae;

	private String pai;

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

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCor_etnia() {
		return cor_etnia;
	}

	public void setCor_etnia(String cor_etnia) {
		this.cor_etnia = cor_etnia;
	}

	public String getSituacao_ocupacional() {
		return situacao_ocupacional;
	}

	public void setSituacao_ocupacional(String situacao_ocupacional) {
		this.situacao_ocupacional = situacao_ocupacional;
	}

	public String getNome_empresa() {
		return nome_empresa;
	}

	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public AlunoDTO() {
		
	}
	
	public AlunoDTO(Aluno aluno) {
		this.matricula = aluno.getMatricula();
		this.nome = aluno.getNome();
		this.data_nasc = aluno.getData_nasc();
		this.estado_civil = aluno.getEstado_civil();
		this.sexo = aluno.getSexo();
		this.cor_etnia = aluno.getCor_etnia();
		this.situacao_ocupacional = aluno.getSituacao_ocupacional();
		this.nome_empresa = aluno.getNome_empresa();
		this.funcao = aluno.getFuncao();
		this.endereco = aluno.getEndereco();
		this.bairro = aluno.getBairro();
		this.cidade = aluno.getCidade();
		this.uf = aluno.getUf();
		this.cep = aluno.getCep();
		this.numero = aluno.getNumero();
		this.cpf = aluno.getCpf();
		this.rg = aluno.getRg();
		this.emissao = aluno.getEmissao();
		this.naturalidade = aluno.getNaturalidade();
		this.nacionalidade = aluno.getNacionalidade();
		this.email = aluno.getEmail();
		this.pai = aluno.getPai();
		this.mae = aluno.getMae();	
	}
}
