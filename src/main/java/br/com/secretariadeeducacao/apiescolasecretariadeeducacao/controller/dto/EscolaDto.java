package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public class EscolaDto {

	private Integer id;
	private String nome;

	public EscolaDto() {
	}

	public EscolaDto(Escola escola) {
		this.id = escola.getId();
		this.nome = escola.getNome();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
