package com.joaogcm.api.spring.sistema.academico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.spring.sistema.academico.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}