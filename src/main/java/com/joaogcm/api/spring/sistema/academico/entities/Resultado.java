package com.joaogcm.api.spring.sistema.academico.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaogcm.api.spring.sistema.academico.entities.pk.ResultadoPK;

@Entity
@Table(name = "tb_resultado")
public class Resultado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ResultadoPK id = new ResultadoPK();
	
	private Double notaObtida1;
	private Double notaObtida2;
	
	public Resultado() {
		
	}
	
	public Resultado(Aluno aluno, Avaliacao avaliacao, Double notaObtida1, Double notaObtida2) {
		id.setAluno(aluno);
		id.setAvaliacao(avaliacao);
		this.notaObtida1 = notaObtida1;
		this.notaObtida2 = notaObtida2;
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	@JsonIgnore
	public Avaliacao getAvaliacao() {
		return id.getAvaliacao();
	}
	
	public void setAvaliacao(Avaliacao avaliacao) {
		id.setAvaliacao(avaliacao);
	}
	
	public Double getNotaObtida1() {
		return notaObtida1;
	}
	
	public void setNotaObtida(Double notaObtida1) {
		this.notaObtida1 = notaObtida1;
	}
	
	public Double getNotaObtida2() {
		return notaObtida2;
	}
	
	public void setNotaObtida2(Double notaObtida2) {
		this.notaObtida2 = notaObtida2;
	}
	
	public Double getNotaFinal() {
		return (notaObtida1 + notaObtida2) / 2;
	}
	
	public String getSituacaoFinal() {
		StringBuilder sb = new StringBuilder();
		if (getNotaFinal() < 6.0) {
			sb.append("Aluno Reprovado!");
		} else {
			sb.append("Aluno Aprovado!");
		}
		return sb.toString();
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
		Resultado other = (Resultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}