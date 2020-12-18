package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.EscolaRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.TurmaRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.EscolaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EscolaSpringDataJPAService implements EscolaService {

	private EscolaRepository escolaRepository;
	private TurmaRepository turmaRepository;

	public EscolaSpringDataJPAService(EscolaRepository escolaRepository, TurmaRepository turmaRepository) {
		this.escolaRepository = escolaRepository;
		this.turmaRepository = turmaRepository;
	}

	@Override
	public List<Escola> findAll() {
		log.info("Starting Method findAll in EscolaSpringDataJPAService");
		log.info("finishing Method findAll in EscolaSpringDataJPAService");
		return this.escolaRepository.findAll();
		
	}

	@Override
	public Escola findById(Integer id) {
		log.info("Starting Method findById in EscolaSpringDataJPAService");
		log.info("Parameter:{}", id);
		log.info("Finding Escola by id on EscolaRepository");
		Escola escola = escolaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
		log.info("Finishing Method findById in EscolaSpringDataJPAService");
		return escola;
	}

	@Override
	public Escola save(Escola escola, EscolaForm escolaForm) {
		escola = escolaForm.convert(turmaRepository);
		escola = escolaRepository.save(escola);
		return escola;
	}

}
