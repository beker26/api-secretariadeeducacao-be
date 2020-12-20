package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

public class TurmaDto {

	private Integer id;
	private String nome;

	public TurmaDto() {
	}

	public TurmaDto(Turma turma) {
		this.id = turma.getId();
		this.nome = turma.getNome();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
