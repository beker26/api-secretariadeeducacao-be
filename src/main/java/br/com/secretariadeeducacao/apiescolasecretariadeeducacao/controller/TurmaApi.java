package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.TurmaDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.TurmaDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.MatriculaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.TurmaForm;


@RestController
@RequestMapping(value = "/v1/escola/{escolaId}/turma")
public interface TurmaApi {
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<TurmaDto>> findAll(@PathVariable Integer escolaId);
	@GetMapping(value = "/{turmaId}")
	@ResponseStatus(value = HttpStatus.OK)
	TurmaDetailDto findTurmaDetailEscolaidAndTurmaId(@PathVariable Integer escolaId, @PathVariable Integer turmaId );
	@PostMapping
	@Transactional
	ResponseEntity<TurmaDetailDto> insert(@PathVariable Integer escolaId, @RequestBody @Validated TurmaForm form, UriComponentsBuilder uri);
	@PutMapping("/{turmaId}")
	@Transactional
	ResponseEntity<TurmaDto> update(@PathVariable Integer escolaId, @PathVariable Integer turmaId, @RequestBody @Validated TurmaForm escolaForm);

	@PostMapping("/{turmaId}/matricula")
	@Transactional
	ResponseEntity<TurmaDto> matricula(@PathVariable Integer escolaId, @PathVariable Integer turmaId, @RequestBody @Validated MatriculaForm matriculaForm);
	
	@DeleteMapping("/{turmaId}")
	@Transactional
	ResponseEntity<Void> delete(@PathVariable Integer escolaId, @PathVariable Integer turmaId);
}
