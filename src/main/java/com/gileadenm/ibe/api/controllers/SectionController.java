package com.gileadenm.ibe.api.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "Detalhes da sessão")
public class SectionController {

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ApiOperation("Retorna o nome do usuário logado")
	public String currentUserName(Authentication authentication) {

		return authentication.getName();

	}
	
	@RequestMapping(value = "/authorities", method = RequestMethod.GET)
	@ApiOperation("Retorna as regras do usuário")
	public Collection<? extends GrantedAuthority> currentAuthorities(Authentication authentication) {

		return authentication.getAuthorities();

	}

	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	@ApiOperation("Retorna o status de logado")
	public HttpStatus basicLogin() {

		return HttpStatus.OK;

	}
	
}
