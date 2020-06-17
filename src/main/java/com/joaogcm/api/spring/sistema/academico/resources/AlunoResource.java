package com.joaogcm.api.spring.sistema.academico.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.api.spring.sistema.academico.entities.Aluno;
import com.joaogcm.api.spring.sistema.academico.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService alunoService;
	
	/* Inserir */
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Aluno obj) {
		obj = alunoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	/* Encontrar todos */
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Aluno> obj = alunoService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	/* Encontrar pelo Id */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Aluno obj = alunoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/* Atualizar pelo Id */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Aluno obj) {
		findById(id);
		obj = alunoService.updateById(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	/* Remover */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		findById(id);
		alunoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}