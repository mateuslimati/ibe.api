package com.gileadenm.ibe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gileadenm.ibe.api.models.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long>{

	Modulo findModuloByProfessor(String Professor);

}
