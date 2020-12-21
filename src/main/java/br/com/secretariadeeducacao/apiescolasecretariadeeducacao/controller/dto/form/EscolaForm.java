package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public class EscolaForm {

	@NotNull @NotEmpty @Length(min = 6)
	private String nome;

	public EscolaForm() {
	}

	public EscolaForm(Escola escola) {
		this.nome = escola.getNome();
	}

	public String getNome() {
		return nome;
	}

	public Escola toEscola() {
		return new Escola(this.getNome());
	}
}
