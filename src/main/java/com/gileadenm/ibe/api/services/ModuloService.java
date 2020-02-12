package com.gileadenm.ibe.api.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gileadenm.ibe.api.DTO.AlunoDTO;
import com.gileadenm.ibe.api.DTO.ModuloDTO;
import com.gileadenm.ibe.api.models.Aluno;
import com.gileadenm.ibe.api.models.Modulo;
import com.gileadenm.ibe.api.repository.ModuloRepository;

@Service
public class ModuloService {

	@Autowired
	private ModuloRepository moduloRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	public List<ModuloDTO> getModulosDTO() {

		List<Modulo> modulos = moduloRepository.findAll();

		if (modulos.isEmpty() != true) {
			List<ModuloDTO> modulosDTO = new ArrayList<>();

			for (Modulo modulo : modulos) {
				modulosDTO.add(new ModuloDTO(modulo));
			}

			return modulosDTO;
		}
		return null;
	}
	
	public ModuloDTO getModuloDTOByCodigo(long codigo) {

		Optional<Modulo> optionalModulo = moduloRepository.findById(codigo);

		if (optionalModulo.isPresent()) {
			return new ModuloDTO(optionalModulo.get());
		}
		return null;
	}
	
	public List<Modulo> getModulos() {

		List<Modulo> modulos = moduloRepository.findAll();

		if (modulos.isEmpty() != true) {
			return modulos;
		}
		return null;
	}
	
	public ModuloDTO saveModuloDTO(Modulo modulo) {
		try {
			return new ModuloDTO(moduloRepository.save(modulo));
		} catch (Exception e) {
			return null;
		}
	}
	

	public Modulo getModuloByCodigo(long codigo) {

		Optional<Modulo> optionalModulo = moduloRepository.findById(codigo);

		if (optionalModulo.isPresent()) {
			return optionalModulo.get();
		}
		return null;
	}
	

	public ModuloDTO insertAlunosInModulo(long codigo, List<Long> matriculas) {

		Modulo modulo = getModuloByCodigo(codigo);

		if (modulo == null)
			return null;
		
		Set<Aluno> alunos = new HashSet<Aluno>();
				
		matriculas.stream().forEach(matricula -> {
			Aluno aluno = alunoService.getAlunoByMatricula(matricula);
			if (aluno != null)
				alunos.add(aluno);
		});
		
		try {
			modulo.setAlunos(alunos);
			return new ModuloDTO(moduloRepository.save(modulo));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<AlunoDTO> getAlunos(long codigo) {

		Modulo modulo = getModuloByCodigo(codigo);

		if (modulo == null)
			return null;
		
		Set<Aluno> alunos = modulo.getAlunos();
		List<AlunoDTO> alunosDTO = new ArrayList<AlunoDTO>();
		
		alunos.stream().forEach(aluno -> {
			alunosDTO.add(new AlunoDTO(aluno));
		});
		
		return alunosDTO;

	}
	
	public ModuloDTO deleteModuloDTO(ModuloDTO moduloDTO) {

		moduloDTO = getModuloDTOByCodigo(moduloDTO.getCodigo());
		
		if (moduloDTO != null) {
			moduloRepository.deleteById(moduloDTO.getCodigo());
		}

		return moduloDTO;
	}
	
}
