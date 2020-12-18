package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

public class TurmasDto {

	private Integer id;
	private String name;

	public TurmasDto(Turma turma) {

		this.id = turma.getId();
		this.name = turma.getNome();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	

}
