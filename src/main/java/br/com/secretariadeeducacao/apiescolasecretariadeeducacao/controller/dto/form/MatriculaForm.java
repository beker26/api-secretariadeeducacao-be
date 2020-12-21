package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;

import javax.validation.constraints.NotNull;

public class MatriculaForm {
	@NotNull
	private Integer idAluno;

	public MatriculaForm() {
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
}
