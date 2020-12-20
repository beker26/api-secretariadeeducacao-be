package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.turma;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.TurmaRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola.EscolaService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TurmaSpringDataJPAService implements TurmaService {
	private TurmaRepository turmaRepository;
	private EscolaService escolaService;

	public TurmaSpringDataJPAService(TurmaRepository turmaRepository, EscolaService escolaService) {
		this.turmaRepository = turmaRepository;
		this.escolaService = escolaService;
	}

	@Override
	public List<Turma> findAll(Integer escolaId) {
		log.info("Starting Method findAll in TurmaSpringDataJPAService");
		List<Turma> listTurma = turmaRepository.findByEscolaId(escolaId);
		log.info("finishing Method findAll in TurmaSpringDataJPAService");
		return listTurma;
	}

	@Override
	public Turma findTurmaByEscolaIdAndTurmaId(Integer escolaId, Integer turmaId) {
		log.info("Starting Method findById in TurmaSpringDataJPAService");
		log.info("Parameters:escolaId = {}, turmaId = {}", escolaId, turmaId);
		log.info("Finding turma by escolaId and turmaId on TurmaRepository");
		Turma turma = turmaRepository.findByTurma_escolaIdAndturmaId(escolaId, turmaId)
				.orElseThrow(() -> new RuntimeException("Objetos não encontrados"));
		log.info("Finishing Method findById in TurmaSpringDataJPAService");
		return turma;
	}

	@Override
	public Turma insert(Integer escolaId, Turma turmaByForm) {
		log.info("Starting Method save in EscolaSpringDataJPAService");
		Escola escolaById = escolaService.findById(escolaId);
		turmaByForm.setEscola(escolaById);
		turmaByForm = turmaRepository.save(turmaByForm);
		log.info("Finishing Method save in EscolaSpringDataJPAService");
		return turmaByForm;
	}
	
	@Override
	public Turma update(Integer escolaId,Integer turmaId, Turma turmaByForm) {
		log.info("Starting Method save in EscolaSpringDataJPAService");
		Turma turmaByEscolaIdAndTurmaId = findTurmaByEscolaIdAndTurmaId(escolaId, turmaId);
		turmaByEscolaIdAndTurmaId.update(turmaByForm);
		turmaByForm = turmaRepository.save(turmaByEscolaIdAndTurmaId);
		log.info("Finishing Method save in EscolaSpringDataJPAService");
		return turmaByForm;
	}
	
	public void delete(Integer escolaId,Integer turmaId ) {
		log.info("Starting Method Delete in EscolaSpringDataJPAService");
		log.info("Parameter:Escola Id = {}," , escolaId);
		Turma turmaByEscolaIdAndTurmaId = findTurmaByEscolaIdAndTurmaId(escolaId,turmaId);
		log.info("Deleting escola by id on escolaRepository");
		try {
//			turmaRepository.deleteByTurma_EscolaIdAndTurmaId(escolaId,turmaId);
			turmaRepository.delete(turmaByEscolaIdAndTurmaId);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir");
		}
		log.info("Finishing Method deleteById in EscolaSpringDataJPAService");
	}
}
