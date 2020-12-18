package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public interface EscolaService {
	
	List<Escola> findAll();
    Escola findById(Integer id);
}
