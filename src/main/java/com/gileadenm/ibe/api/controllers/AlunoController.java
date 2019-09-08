package com.gileadenm.ibe.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gileadenm.ibe.api.DTO.AlunoDTO;
import com.gileadenm.ibe.api.models.Aluno;
import com.gileadenm.ibe.api.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(value="API REST Alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(value = "alunos",
			method = RequestMethod.GET)
	@ApiOperation("Retorna uma lista de alunos")
	public ResponseEntity<List<AlunoDTO>> getAlunos() {
		
		List<AlunoDTO> ResponseDTO = alunoService.getAlunos();
				
		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@RequestMapping(value = "aluno/{matricula}",
			method = RequestMethod.GET)
	@ApiOperation("Retorna um aluno único")
	public ResponseEntity<AlunoDTO> getAlunosByMatricula(
			@PathVariable long matricula) {
		
		AlunoDTO ResponseDTO = alunoService.getAlunoByMatricula(matricula);
				
		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "aluno",
			method = RequestMethod.POST)
	@ApiOperation("Salva/Edita um aluno")
	public ResponseEntity<AlunoDTO> saveAluno(
			@RequestBody Aluno aluno) {
		
		AlunoDTO ResponseDTO = alunoService.saveAluno(aluno);
				
		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "aluno",
			method = RequestMethod.DELETE)
	@ApiOperation("Deleta um aluno")
	public ResponseEntity<AlunoDTO> deleteAluno(
			@RequestBody AlunoDTO RequestDTO) {
			
		AlunoDTO ResponseDTO = alunoService.deleteAluno(RequestDTO);
				
		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
