package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

public class TurmaDetailDto {

	private Integer id;
	private String nome;
	private String escola;
	private List<AlunoDto> alunos;
	

	public TurmaDetailDto(Turma turma) {
		this.id = turma.getId();
		this.nome = turma.getNome();
		this.escola = turma.getNomeEscola();
		this.alunos = new ArrayList<>();
		this.alunos.addAll(turma.getAlunos().stream().map(AlunoDto::new).collect(Collectors.toList()));

	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEscola() {
		return escola;
	}

	public List<AlunoDto> getAlunos() {
		return alunos;
	}

}
