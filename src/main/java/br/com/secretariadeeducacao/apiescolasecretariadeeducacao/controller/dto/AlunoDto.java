package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;

public class AlunoDto {

	private String nome;

	public AlunoDto(Aluno aluno) {

		this.nome = aluno.getNome();
	}

	public String getNome() {
		return nome;
	}

}
