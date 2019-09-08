package com.gileadenm.ibe.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gileadenm.ibe.api.DTO.AlunoDTO;
import com.gileadenm.ibe.api.models.Aluno;
import com.gileadenm.ibe.api.repository.AlunoRepository;
import com.gileadenm.ibe.api.utils.HashMD5;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<AlunoDTO> getAlunos() {
		
		List<Aluno> alunos = alunoRepository.findAll();
		
		if (alunos.isEmpty() != true)
		{
			List<AlunoDTO> alunosDTO = new ArrayList<>();

			for (Aluno aluno : alunos) {
				alunosDTO.add(new AlunoDTO(aluno));
			}
			
			return alunosDTO;
		}	
		return null;	
	}
	
	public AlunoDTO getAlunoByMatricula(long matricula) {
		
		Optional<Aluno> optionalAluno = alunoRepository.findById(matricula);
		
		if (optionalAluno.isPresent()) {
			return new AlunoDTO(optionalAluno.get());
		}
		return null;
	}
	
	public AlunoDTO saveAluno(Aluno aluno) {
		try {
			aluno.setPassword(HashMD5.getCriptografado(aluno.getCpf()));
			return new AlunoDTO(alunoRepository.save(aluno));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}	
	
	public AlunoDTO deleteAluno(AlunoDTO alunoDTO) {
		
		alunoDTO = getAlunoByMatricula(alunoDTO.getMatricula());
		
		if (alunoDTO != null)
		{
			alunoRepository.deleteById(alunoDTO.getMatricula());
		}
		
		return alunoDTO;
	}
	
}
