package com.gileadenm.ibe.api.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gileadenm.ibe.api.DTO.AlunoDTO;
import com.gileadenm.ibe.api.DTO.ModuloDTO;
import com.gileadenm.ibe.api.models.Aluno;
import com.gileadenm.ibe.api.services.AlunoService;
import com.gileadenm.ibe.api.utils.PDFGenerator;
import com.itextpdf.text.DocumentException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "API REST Alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	@ApiOperation("Retorna uma lista de alunos")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<AlunoDTO>> getAlunos() {

		List<AlunoDTO> ResponseDTO = alunoService.getAlunosDTO();

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@RequestMapping(value = "/aluno/{matricula}", method = RequestMethod.GET)
	@ApiOperation("Retorna um aluno único")
	public ResponseEntity<AlunoDTO> getAlunosByMatricula(@PathVariable long matricula) {

		AlunoDTO ResponseDTO = alunoService.getAlunoDTOByMatricula(matricula);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	@ApiOperation("Salva/Edita um aluno")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<AlunoDTO> saveAluno(@RequestBody Aluno aluno) {
		
		AlunoDTO ResponseDTO = alunoService.saveAlunoDTO(aluno);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.DELETE)
	@ApiOperation("Deleta um aluno")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<AlunoDTO> deleteAluno(@RequestBody AlunoDTO RequestDTO) {

		AlunoDTO ResponseDTO = alunoService.deleteAlunoDTO(RequestDTO);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/aluno/{matricula}/modulos", method = RequestMethod.POST)
	@ApiOperation("Cadastra o aluno em n módulos")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<AlunoDTO> matriculaAluno(@PathVariable long matricula, @RequestBody List<Long> codigos) {

		AlunoDTO ResponseDTO = alunoService.insertModulosInAluno(matricula, codigos);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/aluno/{matricula}/modulos", method = RequestMethod.GET)
	@ApiOperation("Retorna os módulos em que o aluno está cadastrado")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<ModuloDTO>> retornaModulos(@PathVariable long matricula) {

		List<ModuloDTO> ResponseDTO = alunoService.getModulos(matricula);

		if (ResponseDTO != null) {
			return new ResponseEntity<>(ResponseDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/alunos/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<InputStreamResource> customersReport() throws IOException, DocumentException {
		List<Aluno> alunos = alunoService.getAlunos();

		if (alunos != null) {
			ByteArrayInputStream bis = PDFGenerator.alunosPDFReport(alunos);

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=ibe-alunos.pdf");

			return new ResponseEntity<>(new InputStreamResource(bis), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
