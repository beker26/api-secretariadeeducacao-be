package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.EscolaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public interface EscolaService {

	List<Escola> findAll();

	Escola findById(Integer id);

	Escola insert(Escola EscolaObj);

	Escola fromDto(EscolaForm escolaForm);

	Escola update(Escola escolaObj);

	void delete(Integer id);

}
