package com.gileadenm.ibe.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gileadenm.ibe.api.DTO.AlunoDTO;
import com.gileadenm.ibe.api.DTO.ModuloDTO;
import com.gileadenm.ibe.api.models.Aluno;
import com.gileadenm.ibe.api.models.Modulo;
import com.gileadenm.ibe.api.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private ModuloService moduloService;

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

	public Aluno getAlunoByMatricula(long matricula) {

		Optional<Aluno> optionalAluno = alunoRepository.findById(matricula);

		if (optionalAluno.isPresent()) {
			return optionalAluno.get();
		}
		return null;
	}

	public AlunoDTO insertModulosInAluno(long matricula, List<Long> codigos) {

		Aluno aluno = getAlunoByMatricula(matricula);

		if (aluno == null)
			return null;
				
		codigos.stream().forEach(codigo -> {
			Modulo modulo = moduloService.getModuloByCodigo(codigo);
			if (modulo != null)
				aluno.getModulos().add(modulo);
		});
		
		return saveAlunoDTO(aluno);

	}

	public List<ModuloDTO> getModulos(long matricula) {

		Aluno aluno = getAlunoByMatricula(matricula);

		if (aluno == null)
			return null;
		
		Set<Modulo> modulos = aluno.getModulos();
		List<ModuloDTO> modulosDTO = new ArrayList<ModuloDTO>();
		
		modulos.stream().forEach(modulo -> {
			modulosDTO.add(new ModuloDTO(modulo));
		});
		
		return modulosDTO;

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
		} else {
			aluno.setRole("ROLE_USER");
			aluno.setPassword(aluno.getCpf());
		}
		try {
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
