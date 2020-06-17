package com.joaogcm.api.spring.sistema.academico.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogcm.api.spring.sistema.academico.entities.Curso;
import com.joaogcm.api.spring.sistema.academico.repositories.CursoRepository;
import com.joaogcm.api.spring.sistema.academico.services.exceptions.ResourceNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso insert(Curso obj) {
		cursoRepository.save(obj);
		return obj;
	}
	
	public List<Curso> findAll() {
		List<Curso> obj = cursoRepository.findAll();
		return obj;
	}
	
	public Curso findById(Long id) {
		Optional<Curso> obj = cursoRepository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Nenhum curso encontrado!"));
	}
	
	public Curso updateById(Long id, Curso obj) {
		try {
			Curso entidade = cursoRepository.getOne(id);
			updateData(entidade, obj);
			return entidade;
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Curso entidade, Curso obj) {
		entidade.setNome(obj.getNome());
		entidade.setCargaHoraria(obj.getCargaHoraria());
		entidade.setValor(obj.getValor());
		entidade.setNotaMinima(obj.getNotaMinima());
	}
	
	public void deleteById(Long id) {
		cursoRepository.deleteById(id);
	}
}