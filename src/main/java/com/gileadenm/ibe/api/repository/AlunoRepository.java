package com.gileadenm.ibe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gileadenm.ibe.api.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	Aluno findAlunoByEmail(String email);
}
