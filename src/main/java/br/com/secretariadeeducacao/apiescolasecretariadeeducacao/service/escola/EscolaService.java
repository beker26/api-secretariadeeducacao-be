package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.EscolaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public interface EscolaService {
	
	List<Escola> findAll();
    Escola findById(Integer id);
    Escola save(Escola escola, EscolaForm escolaForm);
    
}
