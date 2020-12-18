package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDto;

@RestController
@RequestMapping(value = "/v1/escola")
public interface EscolaApi {
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<EscolaDto>> findAll();
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<EscolaDetailDto> findById(Integer id);
}
