package com.joaogcm.api.spring.sistema.academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.spring.sistema.academico.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
}