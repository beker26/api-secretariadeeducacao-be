package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public class EscolaDetailDto {

	private Integer id;
	private String nome;
	private List<TurmasDto> turmas;

	public EscolaDetailDto(Escola escola) {

		this.id = escola.getId();
		this.nome = escola.getNome();
		this.turmas = new ArrayList<>();
		this.turmas.addAll(escola.getTurmas().stream().map(TurmasDto::new).collect(Collectors.toList()));
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<TurmasDto> getTurmas() {
		return turmas;
	}

}
