package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public interface EscolaService {

	List<Escola> findAll();

	Escola findById(Integer escolaId);

	Escola insert(Escola EscolaObj);

	Escola update(Integer escolaId, Escola escolaObj);

	void delete(Integer escolaId);

}
