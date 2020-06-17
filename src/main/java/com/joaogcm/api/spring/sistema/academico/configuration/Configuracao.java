package com.joaogcm.api.spring.sistema.academico.configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaogcm.api.spring.sistema.academico.entities.Aluno;
import com.joaogcm.api.spring.sistema.academico.entities.Avaliacao;
import com.joaogcm.api.spring.sistema.academico.entities.Curso;
import com.joaogcm.api.spring.sistema.academico.entities.Matricula;
import com.joaogcm.api.spring.sistema.academico.entities.Resultado;
import com.joaogcm.api.spring.sistema.academico.entities.Turma;
import com.joaogcm.api.spring.sistema.academico.repositories.AlunoRepository;
import com.joaogcm.api.spring.sistema.academico.repositories.AvaliacaoRepository;
import com.joaogcm.api.spring.sistema.academico.repositories.CursoRepository;
import com.joaogcm.api.spring.sistema.academico.repositories.MatriculaRepository;
import com.joaogcm.api.spring.sistema.academico.repositories.ResultadoRepository;
import com.joaogcm.api.spring.sistema.academico.repositories.TurmaRepository;

@Configuration
@Profile("test")
public class Configuracao implements CommandLineRunner {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private ResultadoRepository resultadoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Curso c1 = new Curso(null, "Desenvolvimento Java Web", 40, 780.00, 6.00);
		
		Turma t1 = new Turma(null, 23, sdf.parse("11/06/2020"), 40, c1);
		
		c1.getTurmas().addAll(Arrays.asList(t1));
		
		cursoRepository.saveAll(Arrays.asList(c1));
		turmaRepository.saveAll(Arrays.asList(t1));
		
		Aluno a1 = new Aluno(null, "João", "44474484423", sdf.parse("09/07/1996"));
		Aluno a2 = new Aluno(null, "Maria", "12256555578", sdf.parse("04/05/1970"));
		
		Matricula mat1 = new Matricula(t1, a1, sdf.parse("29/05/2020"), null);
		Matricula mat2 = new Matricula(t1, a2, sdf.parse("23/05/2020"), 12);
		
		a1.getAlunos().addAll(Arrays.asList(mat1));
		a2.getAlunos().addAll(Arrays.asList(mat2));
		
		alunoRepository.saveAll(Arrays.asList(a1, a2));
		matriculaRepository.saveAll(Arrays.asList(mat1, mat2));
		
		Avaliacao av1 = new Avaliacao(null, 4.00, sdf.parse("29/06/2020"), t1);
		Avaliacao av2 = new Avaliacao(null, 6.00, sdf.parse("25/07/2020"), t1);
		
		Resultado r1 = new Resultado(a1, av1, 6.50, 5.50);
		Resultado r2 = new Resultado(a2, av1, 4.60, 6.80);
		
		av1.getResultados().addAll(Arrays.asList(r1, r2));
		
		avaliacaoRepository.saveAll(Arrays.asList(av1, av2));
		resultadoRepository.saveAll(Arrays.asList(r1, r2));
	}
}