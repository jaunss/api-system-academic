package com.joaogcm.api.spring.sistema.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogcm.api.spring.sistema.academico.entities.Turma;
import com.joaogcm.api.spring.sistema.academico.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public Turma insert(Turma obj) {
		obj = turmaRepository.save(obj);
		return obj;
	}
	
	public List<Turma> findAll() {
		List<Turma> obj = turmaRepository.findAll();
		return obj;
	}
	
	public Turma findById(Long id) {
		Optional<Turma> obj = turmaRepository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Nenhuma turma encontrada!"));
	}
	
	public Turma updateById(Long id, Turma obj) {
		Turma entidade = turmaRepository.getOne(id);
		updateData(entidade, obj);
		return entidade;
	}

	private void updateData(Turma entidade, Turma obj) {
		entidade.setNumero(obj.getNumero());
		entidade.setDataInicio(obj.getDataInicio());
		entidade.setNumeroVagas(obj.getNumeroVagas());
		entidade.setCurso(obj.getCurso());
	}
	
	public void deleteById(Long id) {
		turmaRepository.deleteById(id);
	}
}