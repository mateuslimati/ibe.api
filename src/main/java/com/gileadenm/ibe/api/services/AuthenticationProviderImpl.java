package com.gileadenm.ibe.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.gileadenm.ibe.api.models.Aluno;
import com.gileadenm.ibe.api.repository.AlunoRepository;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	AlunoRepository alunoRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String email = authentication.getName();
		String password = authentication.getCredentials().toString();

		Aluno aluno = alunoRepository.findAlunoByEmail(email);

		if (aluno != null && aluno.getPassword().equals(password)) {

			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(aluno.getRole()));

			return new UsernamePasswordAuthenticationToken(aluno.getEmail(), password, authorities);

		} else {
			throw new BadCredentialsException("Authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}