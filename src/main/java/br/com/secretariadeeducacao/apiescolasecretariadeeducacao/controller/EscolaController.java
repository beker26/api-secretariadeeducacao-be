package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDetailDto;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.EscolaDto;
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
	public ResponseEntity<EscolaDetailDto> findById(@PathVariable Integer id) {
		log.info("Starting Method findById in Escola Controller!");
		log.info("Parameter id = {}", id);
		Escola escola =  escolaService.findById(id);
		log.info("Converting Escola to EscolaDto");
		return ResponseEntity.ok().body(new EscolaDetailDto(escola));
	}

}
