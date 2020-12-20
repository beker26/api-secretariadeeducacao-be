package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

public class TurmaForm {
	@NotBlank(message = "turmaNome Empty")
	@Size(min = 3, message = "turmaNome must be at least 3 char")
	private String nomeTurma;

	public TurmaForm() {
	}

	public TurmaForm(Turma turma) {
		this.nomeTurma = turma.getNome();
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public Turma toTurma() {
 		return new Turma(this.getNomeTurma());
	}
}
