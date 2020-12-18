package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDto;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class EscolaController implements EscolaApi {
	@Override
	public Page<EscolaDto> findAll(Pageable pageable) {
		log.info("[start] EscolaController - findAll");
		return null;
	}

}
