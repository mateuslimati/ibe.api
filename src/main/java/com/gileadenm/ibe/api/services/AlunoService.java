package com.gileadenm.ibe.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gileadenm.ibe.api.DTO.AlunoDTO;
import com.gileadenm.ibe.api.models.Aluno;
import com.gileadenm.ibe.api.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<AlunoDTO> getAlunosDTO() {

		List<Aluno> alunos = alunoRepository.findAll();

		if (alunos.isEmpty() != true) {
			List<AlunoDTO> alunosDTO = new ArrayList<>();

			for (Aluno aluno : alunos) {
				alunosDTO.add(new AlunoDTO(aluno));
			}

			return alunosDTO;
		}
		return null;
	}

	public List<Aluno> getAlunos() {

		List<Aluno> alunos = alunoRepository.findAll();

		if (alunos.isEmpty() != true) {
			return alunos;
		}
		return null;
	}

	public AlunoDTO getAlunoDTOByMatricula(long matricula) {

		Optional<Aluno> optionalAluno = alunoRepository.findById(matricula);

		if (optionalAluno.isPresent()) {
			return new AlunoDTO(optionalAluno.get());
		}
		return null;
	}

	public AlunoDTO saveAlunoDTO(Aluno aluno) {
		Aluno alunoR = alunoRepository.findAlunoByEmail(aluno.getEmail());
		if (alunoR != null) {
			aluno.setMatricula(alunoR.getMatricula());
			aluno.setPassword(alunoR.getPassword());
		}
		else {
			aluno.setPassword(aluno.getCpf());
		}
		try {
			aluno.setRole("ROLE_USER");
			return new AlunoDTO(alunoRepository.save(aluno));
		} catch (Exception e) {
			return null;
		}
	}

	public AlunoDTO deleteAlunoDTO(AlunoDTO alunoDTO) {

		alunoDTO = getAlunoDTOByMatricula(alunoDTO.getMatricula());

		if (alunoDTO != null) {
			alunoRepository.deleteById(alunoDTO.getMatricula());
		}

		return alunoDTO;
	}

}
