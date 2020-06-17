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

import com.joaogcm.api.spring.sistema.academico.entities.Curso;
import com.joaogcm.api.spring.sistema.academico.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;
	
	/* Inserir */
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Curso obj) {
		obj = cursoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/* Encontrar todos */
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Curso> cursos = cursoService.findAll();
		return ResponseEntity.ok().body(cursos);
	}
	
	/* Encontrar pelo Id */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Curso obj = cursoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/* Atualizar pelo Id */
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Curso obj) {
		findById(id);
		obj = cursoService.updateById(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	/* Remover */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		cursoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}