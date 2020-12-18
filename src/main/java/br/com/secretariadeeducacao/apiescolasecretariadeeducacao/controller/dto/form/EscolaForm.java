package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.TurmaRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

public class EscolaForm {

	private String nome;
	private String nomeTurma;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String turma) {
		this.nomeTurma = turma;
	}

	public Escola convert(TurmaRepository turmaRepository) {
		List<Turma> turma = turmaRepository.findByNome(nomeTurma);
		return new Escola(nome,turma);
	}

}
