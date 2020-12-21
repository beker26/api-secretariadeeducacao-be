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

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.AlunoDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.AlunoDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.AlunoForm;


@RestController
@RequestMapping(value = "/v1/escola/{escolaId}/turma/{turmaId}/aluno")
public interface AlunoApi {
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<List<AlunoDto>> findAll();
	@GetMapping(value = "/{alunoId}")
	@ResponseStatus(value = HttpStatus.OK)
	ResponseEntity<AlunoDetailDto> findById(Integer alunoId);
	@PostMapping
	@Transactional
	ResponseEntity<AlunoDto> insert(@Validated @RequestBody AlunoForm alunoForm,UriComponentsBuilder  uriBuilder);
	@PutMapping("/{alunoId}")
	@Transactional
	ResponseEntity<AlunoDto> update(@PathVariable Integer alunoId, @RequestBody @Validated AlunoForm alunoForm);
	@DeleteMapping("/{alunoId}")
	@Transactional
	ResponseEntity<Void> delete(@PathVariable Integer alunoId);
}


