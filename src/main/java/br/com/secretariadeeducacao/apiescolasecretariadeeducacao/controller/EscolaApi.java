package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.EscolaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

@RestController
@RequestMapping(value = "/v1/escola")
public interface EscolaApi {
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<EscolaDto>> findAll();
	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<EscolaDetailDto> findById(Integer id);
	@PostMapping
	@Transactional
	ResponseEntity<EscolaDto> insert(@Validated @RequestBody EscolaForm escolaForm, UriComponentsBuilder uriBuilder);
}
