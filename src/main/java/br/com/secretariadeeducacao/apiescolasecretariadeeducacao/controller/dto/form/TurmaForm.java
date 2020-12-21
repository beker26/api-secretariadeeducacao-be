package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.Length;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

public class TurmaForm {
	
	@NotNull @NotEmpty @Length(min = 8)
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
