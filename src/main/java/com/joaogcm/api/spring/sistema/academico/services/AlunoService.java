package com.joaogcm.api.spring.sistema.academico.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joaogcm.api.spring.sistema.academico.entities.Aluno;
import com.joaogcm.api.spring.sistema.academico.repositories.AlunoRepository;
import com.joaogcm.api.spring.sistema.academico.services.exceptions.DatabaseException;
import com.joaogcm.api.spring.sistema.academico.services.exceptions.ResourceNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno insert(Aluno obj) {
		alunoRepository.save(obj);
		return obj;
	}
	
	public List<Aluno> findAll() {
		List<Aluno> obj = alunoRepository.findAll();
		return obj;
	}
	
	public Aluno findById(Long id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Aluno updateById(Long id, Aluno obj) {
		try {
			Aluno entidade = alunoRepository.getOne(id);
			updateData(entidade, obj);
			return obj;
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Aluno entidade, Aluno obj) {
		entidade.setNome(obj.getNome());
		entidade.setCpf(obj.getCpf());
		entidade.setNascimento(obj.getNascimento());
	}
	
	public void deleteById(Long id) {
		try {
			alunoRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}