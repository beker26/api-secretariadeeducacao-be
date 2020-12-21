package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public class AlunoForm {
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
