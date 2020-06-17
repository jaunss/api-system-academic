package com.joaogcm.api.spring.sistema.academico.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaogcm.api.spring.sistema.academico.entities.pk.MatriculaPK;

@Entity
@Table(name = "tb_matricula")
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MatriculaPK id = new MatriculaPK();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Date dataMatricula;
	
	private Integer prestacoes;
	
	public Matricula() {
		
	}
	
	public Matricula(Turma turma, Aluno aluno, Date dataMatricula, Integer prestacoes) {
		id.setTurma(turma);
		id.setAluno(aluno);
		this.dataMatricula = dataMatricula;
		this.prestacoes = prestacoes;
	}
	
	@JsonIgnore
	public Turma getTurma() {
		return id.getTurma();
	}
	
	public void setTurma(Turma turma) {
		id.setTurma(turma);
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public Date getDataMatricula() {
		return dataMatricula;
	}
	
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	public Integer getPrestacoes() {
		return prestacoes;
	}
	
	public void setPrestacoes(Integer prestacoes) {
		this.prestacoes = prestacoes;
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
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}