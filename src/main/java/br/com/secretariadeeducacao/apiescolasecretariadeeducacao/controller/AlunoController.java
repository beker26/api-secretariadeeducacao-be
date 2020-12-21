package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;



import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.AlunoDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.AlunoDto;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.AlunoForm;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.aluno.AlunoService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class AlunoController implements AlunoApi {

	private AlunoService alunoService;
	

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@Override
	public ResponseEntity<List<AlunoDto>> findAll() {
		log.info("Starting Method FindAll in Aluno Controller!");
		List<Aluno> listAluno = this.alunoService.findAll();
		List<AlunoDto> listALunoDto = listAluno.stream().map(a -> new AlunoDto(a)).collect(Collectors.toList());
		log.info("Finishing Method Findall in Aluno Controller!");
		return ResponseEntity.ok().body(listALunoDto);
	}

	@Override
	public ResponseEntity<AlunoDetailDto> findById(Integer alunoId) {
		log.info("Starting Method findById in Aluno Controller!");
		log.info("Parameter id = {}", alunoId);
		Aluno aluno = alunoService.findById(alunoId);
		log.info("Converting ALuno to AlunoDto");
		return ResponseEntity.ok().body(new AlunoDetailDto(aluno));
	}

	@Override
	public ResponseEntity<AlunoDto> insert(AlunoForm alunoForm, UriComponentsBuilder uriBuilder) {
		log.info("Starting Method insert in Aluno Controller!");
		log.info("Form: {}", alunoForm);
		Aluno aluno = alunoService.insert(alunoForm.toAluno());
		log.info("Finishing Method insert in Aluno Controller!");
		URI uri = uriBuilder.path("/aluno/{alunoId}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}

	@Override
	public ResponseEntity<AlunoDto> update(Integer alunoId, AlunoForm alunoForm) {
		log.info("Starting Method Update in Aluno Controller!");
		log.info("Form: {}", alunoForm);
		alunoService.update(alunoId,alunoForm.toAluno());
		log.info("Finishing Method Update in Aluno Controller!");
		return ResponseEntity.noContent().build();
	}

	
	@Override
	public ResponseEntity<Void> delete(Integer alunoId) {
		log.info("Starting Method Delete in Aluno Controller!");
		alunoService.delete(alunoId);
		log.info("Finishing Method Delete in Aluno Controller!");
		return ResponseEntity.noContent().build();
	}

}
