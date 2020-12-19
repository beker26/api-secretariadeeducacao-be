package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public class EscolaForm {

	private String nome;

	public EscolaForm() {
	}

	public EscolaForm(Escola escola) {
		this.nome = escola.getNome();
	}

	public String getNome() {
		return nome;
	}

	
}
