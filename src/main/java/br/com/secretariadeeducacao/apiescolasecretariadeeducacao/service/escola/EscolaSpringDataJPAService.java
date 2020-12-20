package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.EscolaRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EscolaSpringDataJPAService implements EscolaService {

	private EscolaRepository escolaRepository;

	public EscolaSpringDataJPAService(EscolaRepository escolaRepository) {
		this.escolaRepository = escolaRepository;

	}

	@Override
	public List<Escola> findAll() {
		log.info("Starting Method findAll in EscolaSpringDataJPAService");
		List<Escola> listEscola = this.escolaRepository.findAll();
		log.info("finishing Method findAll in EscolaSpringDataJPAService");
		return listEscola;

	}

	@Override
	public Escola findById(Integer escolaId) {
		log.info("Starting Method findById in EscolaSpringDataJPAService");
		log.info("Parameter:{}", escolaId);
		log.info("Finding Escola by id on EscolaRepository");
		Escola escola = escolaRepository.findById(escolaId).orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
		log.info("Finishing Method findById in EscolaSpringDataJPAService");
		return escola;
	}

	@Override
	public Escola insert(Escola escolaObj) {
		log.info("Starting Method save in EscolaSpringDataJPAService");
		escolaObj = escolaRepository.save(escolaObj);
		log.info("Finishing Method save in EscolaSpringDataJPAService");
		return escolaObj;
	}

	@Override
	public Escola update(Integer escolaId,Escola escolaByForm) {
		log.info("Starting Method update in EscolaSpringDataJPAService");
		Escola escolaById = findById(escolaId);
		escolaById.update(escolaByForm);
		log.info("Save in EscolaRepository");
		escolaRepository.save(escolaById);
		log.info("Finishing Method save in EscolaSpringDataJPAService");
		return escolaById;
	}
	
	public void delete(Integer escolaId) {
		log.info("Starting Method Delete in EscolaSpringDataJPAService");
		log.info("Parameter:Escola Id = {}," , escolaId);
		findById(escolaId);
		log.info("Deleting escola by id on escolaRepository");
		try {
			escolaRepository.deleteById(escolaId);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir");
		}
		log.info("Finishing Method deleteById in EscolaSpringDataJPAService");
	}
}
