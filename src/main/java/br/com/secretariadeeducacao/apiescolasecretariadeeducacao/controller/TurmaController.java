package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.TurmaDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.TurmaDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.TurmaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.turma.TurmaService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class TurmaController implements TurmaApi {
	private TurmaService turmaService;

	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}

	@Override
	public ResponseEntity<List<TurmaDto>> findAll(Integer escolaId) {
		log.info("Starting Method FindAll in Turma Controller!");
		List<Turma> listTurma = this.turmaService.findAll(escolaId);
		List<TurmaDto> listTurmaDto = listTurma.stream().map(t -> new TurmaDto(t)).collect(Collectors.toList());
		log.info("Finishing Method Findall in Turma Controller!");
		return ResponseEntity.ok().body(listTurmaDto);
	}

	@Override
	public TurmaDetailDto findTurmaDetailEscolaidAndTurmaId(Integer escolaId, Integer turmaId) {
		log.info("Starting Method findByiD in Turma Controller!");
		log.info("Parameter escolaId = {}, turmaId = {}",escolaId, turmaId);
		Turma turma = turmaService.findTurmaByEscolaIdAndTurmaId(escolaId, turmaId);
		log.info("Converting Turma to TurmaDto");
		return new TurmaDetailDto(turma);
	}

	@Override
	public ResponseEntity<TurmaDetailDto> insert(Integer escolaId, TurmaForm form, UriComponentsBuilder uriBuilder) {
		log.info("Starting Method insert in Escola Controller!");
		log.info("Form: {}", form);
		Turma turma = turmaService.insert(escolaId, form.toTurma());
		log.info("Finishing Method insert in Escola Controller!");
		URI uri = uriBuilder.path("/escola/{escolaId}").buildAndExpand(turma.getEscolaId(), turma.getId()).toUri();
		return ResponseEntity.created(uri).body(new TurmaDetailDto(turma));
	}
	


	@Override
	public ResponseEntity<TurmaDto> update(Integer escolaId, Integer turmaId, TurmaForm turmaForm) {

		log.info("Starting Method Update in Turma Controller!");
		log.info("Form: {}", turmaForm);
		turmaService.update(escolaId,turmaId,turmaForm.toTurma());
		log.info("Finishing Method Update in Turma Controller!");
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Void> delete(Integer escolaId, Integer turmaId) {

		log.info("Starting Method Delete in Turma Controller!");
		turmaService.delete(escolaId,turmaId);
		log.info("Finishing Method Delete in Turma Controller!");
		return ResponseEntity.noContent().build();
	}

}
