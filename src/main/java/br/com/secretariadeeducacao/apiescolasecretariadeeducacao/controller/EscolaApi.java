package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDto;

@RestController
@RequestMapping(value = "/v1/escola")
public interface EscolaApi {
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	Page<EscolaDto> findAll(Pageable pageable);
}
