package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.EscolaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola.EscolaService;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class EscolaController implements EscolaApi {

	private EscolaService escolaService;

	public EscolaController(EscolaService escolaService) {
		this.escolaService = escolaService;
	}

	@Override
	public ResponseEntity<List<EscolaDto>> findAll() {
		log.info("Starting Method FindAll in Escola Controller!");
		List<Escola> listEscola = this.escolaService.findAll();
		List<EscolaDto> listEscolaDto = listEscola.stream().map(e -> new EscolaDto(e)).collect(Collectors.toList());
		log.info("Finishing Method Findall in Escola Controller!");
		return ResponseEntity.ok().body(listEscolaDto);
	}

	@Override
	public ResponseEntity<EscolaDetailDto> findById(Integer id) {
		log.info("Starting Method findById in Escola Controller!");
		log.info("Parameter id = {}", id);
		Escola escola = escolaService.findById(id);
		log.info("Converting Escola to EscolaDto");
		return ResponseEntity.ok().body(new EscolaDetailDto(escola));
	}

	public ResponseEntity<EscolaDto> insert(@Validated @RequestBody EscolaForm escolaForm,UriComponentsBuilder  uriBuilder) {
        Escola escolaObj = escolaService.fromDto(escolaForm);
		escolaObj = escolaService.insert(escolaObj);
		URI uri = uriBuilder.path("/escola/{id}").buildAndExpand(escolaObj.getId()).toUri();
		return ResponseEntity.created(uri).body(new EscolaDto(escolaObj));
	}

	@Override
	public ResponseEntity<EscolaDto> update(@PathVariable Integer id, @RequestBody @Validated EscolaForm escolaForm) {
		
		Escola escolaObj = escolaService.fromDto(escolaForm);
		escolaObj.setId(id);
		escolaObj = escolaService.update(escolaObj);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Void> delete(Integer id) {
		escolaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
