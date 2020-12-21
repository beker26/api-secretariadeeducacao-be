package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;

public class AlunoDetailDto {

	private Integer id;
	private String nome;

	public AlunoDetailDto(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
