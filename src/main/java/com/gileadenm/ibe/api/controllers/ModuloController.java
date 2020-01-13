package com.gileadenm.ibe.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gileadenm.ibe.api.DTO.AlunoDTO;
import com.gileadenm.ibe.api.DTO.ModuloDTO;
import com.gileadenm.ibe.api.models.Modulo;
import com.gileadenm.ibe.api.services.ModuloService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "API REST Modulos")
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	@RequestMapping(value = "/modulos", method = RequestMethod.GET)
	@ApiOperation("Retorna uma lista de modulos")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<ModuloDTO>> getModulos() {

		List<ModuloDTO> ResponseDTO = moduloService.getModulosDTO();

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
	
	@RequestMapping(value = "/modulo", method = RequestMethod.POST)
	@ApiOperation("Salva/Edita um modulo")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ModuloDTO> saveModulo(@RequestBody Modulo modulo) {
		
		ModuloDTO ResponseDTO = moduloService.saveModuloDTO(modulo);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/modulo", method = RequestMethod.DELETE)
	@ApiOperation("Deleta um módulo")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ModuloDTO> deleteAluno(@RequestBody ModuloDTO RequestDTO) {

		ModuloDTO ResponseDTO = moduloService.deleteModuloDTO(RequestDTO);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/modulo/{codigo}/alunos", method = RequestMethod.POST)
	@ApiOperation("Cadastra n alunos em um módulo")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ModuloDTO> matriculaAluno(@PathVariable long codigo, @RequestBody List<Long> matriculas) {

		ModuloDTO ResponseDTO = moduloService.insertAlunosInModulo(codigo, matriculas);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/modulo/{codigo}/alunos", method = RequestMethod.GET)
	@ApiOperation("Retorna os alunos que estão cadastrados no módulo")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<AlunoDTO>> retornaAlunos(@PathVariable long codigo) {

		List<AlunoDTO> ResponseDTO = moduloService.getAlunos(codigo);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
