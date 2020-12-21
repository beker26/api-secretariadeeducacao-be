package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;

public class AlunoForm {
	
	@NotNull @NotEmpty @Length(min = 8)
	private String nome;

	public AlunoForm() {
	}

	public AlunoForm(Aluno aluno) {
		this.nome = aluno.getNome();
	}

	public String getNome() {
		return nome;
	}


	public Aluno toAluno() {
		return new Aluno(this.getNome());
	}

}
