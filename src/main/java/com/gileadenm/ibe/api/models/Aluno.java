package com.gileadenm.ibe.api.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_ALUNOS")
public class Aluno{
	
	public Aluno()
	{	
	}
	
	public Aluno(long matricula)
	{
		this.matricula = matricula;
	}

	public Aluno(long matricula, @NotNull String nome, @NotNull String password, Date data_nasc, String estado_civil,
			String sexo, String cor_etnia, String situacao_ocupacional, String nome_empresa, String funcao,
			String endereco, String bairro, String cidade, String uf, String cep, String telefone_1, String telefone_2,
			@NotNull String email, @NotNull String cpf, String rg, Date emissao, String nacionalidade,
			String naturalidade, String mae, String pai, String necessidades_especiais, String escola_ensino_medio,
			int ano_conclusao, String curso_superior, String denominacao, String localidade, String pastor,
			String atividades) {

		this.matricula = matricula;
		this.nome = nome;
		this.password = password;
		this.data_nasc = data_nasc;
		this.estado_civil = estado_civil;
		this.sexo = sexo;
		this.cor_etnia = cor_etnia;
		this.situacao_ocupacional = situacao_ocupacional;
		this.nome_empresa = nome_empresa;
		this.funcao = funcao;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone_1 = telefone_1;
		this.telefone_2 = telefone_2;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
		this.emissao = emissao;
		this.nacionalidade = nacionalidade;
		this.naturalidade = naturalidade;
		this.mae = mae;
		this.pai = pai;
		this.necessidades_especiais = necessidades_especiais;
		this.escola_ensino_medio = escola_ensino_medio;
		this.ano_conclusao = ano_conclusao;
		this.curso_superior = curso_superior;
		this.denominacao = denominacao;
		this.localidade = localidade;
		this.pastor = pastor;
		this.atividades = atividades;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long matricula;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String password;
	
	private Date data_nasc;
	
	private String estado_civil;
	
	private String sexo;
	
	private String cor_etnia;
	
	private String situacao_ocupacional;
	
	private String nome_empresa;
	
	private String funcao;
	
	private String endereco;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
	private String cep;
	
	private String telefone_1;

	private String telefone_2;

	@NotNull
	private String email;
	
	@NotNull
	private String cpf;

	private String rg;
	
	private Date emissao;
	
	private String nacionalidade;
	
	private String naturalidade;
	
	private String mae;
	
	private String pai;
	
	private String necessidades_especiais;
	
	private String escola_ensino_medio;
	
	private int ano_conclusao;
	
	private String curso_superior;
	
	private String denominacao;

	private String localidade;

	private String pastor;
	
	private String atividades;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTelefone_1() {
		return telefone_1;
	}

	public void setTelefone_1(String telefone_1) {
		this.telefone_1 = telefone_1;
	}

	public String getTelefone_2() {
		return telefone_2;
	}

	public void setTelefone_2(String telefone_2) {
		this.telefone_2 = telefone_2;
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

	public String getNecessidades_especiais() {
		return necessidades_especiais;
	}

	public void setNecessidades_especiais(String necessidades_especiais) {
		this.necessidades_especiais = necessidades_especiais;
	}

	public String getEscola_ensino_medio() {
		return escola_ensino_medio;
	}

	public void setEscola_ensino_medio(String escola_ensino_medio) {
		this.escola_ensino_medio = escola_ensino_medio;
	}

	public int getAno_conclusao() {
		return ano_conclusao;
	}

	public void setAno_conclusao(int ano_conclusao) {
		this.ano_conclusao = ano_conclusao;
	}

	public String getCurso_superior() {
		return curso_superior;
	}

	public void setCurso_superior(String curso_superior) {
		this.curso_superior = curso_superior;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getPastor() {
		return pastor;
	}

	public void setPastor(String pastor) {
		this.pastor = pastor;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}	
}