package com.joaogcm.api.spring.sistema.academico.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double nota;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Date data;
	
	@OneToMany(mappedBy = "id.avaliacao")
	private Set<Resultado> resultados = new HashSet<Resultado>();
	
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	public Avaliacao() {
		
	}
	
	public Avaliacao(Long id, Double nota, Date data, Turma turma) {
		this.id = id;
		this.nota = nota;
		this.data = data;
		this.turma = turma;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getNota() {
		return nota;
	}
	
	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Set<Resultado> getResultados() {
		return resultados;
	}
	
	public void setAvaliacoes(Set<Resultado> resultados) {
		this.resultados = resultados;
	}
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> alunos = new HashSet<Aluno>();
		for (Resultado x : resultados) {
			alunos.add(x.getAluno());
		}
		return alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}