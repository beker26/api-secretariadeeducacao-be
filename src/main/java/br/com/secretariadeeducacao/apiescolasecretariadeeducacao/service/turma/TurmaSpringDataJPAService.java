package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.turma;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.TurmaRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.aluno.AlunoService;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola.EscolaService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TurmaSpringDataJPAService implements TurmaService {
	private TurmaRepository turmaRepository;
	private EscolaService escolaService;
	private AlunoService alunoService;

	public TurmaSpringDataJPAService(TurmaRepository turmaRepository, EscolaService escolaService,
			AlunoService alunoService) {
		this.turmaRepository = turmaRepository;
		this.escolaService = escolaService;
		this.alunoService = alunoService;
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
		log.info("Starting Method save in TurmaSpringDataJPAService");
		Escola escolaById = escolaService.findById(escolaId);
		turmaByForm.setEscola(escolaById);
		turmaByForm = turmaRepository.save(turmaByForm);
		log.info("Finishing Method save in TurmaSpringDataJPAService");
		return turmaByForm;
	}

	@Override
	public Turma update(Integer escolaId, Integer turmaId, Turma turmaByForm) {
		log.info("Starting Method save in TurmaSpringDataJPAService");
		Turma turmaByEscolaIdAndTurmaId = findTurmaByEscolaIdAndTurmaId(escolaId, turmaId);
		turmaByEscolaIdAndTurmaId.update(turmaByForm);
		turmaByForm = turmaRepository.save(turmaByEscolaIdAndTurmaId);
		log.info("Finishing Method save in TurmaSpringDataJPAService");
		return turmaByForm;
	}

	public void delete(Integer escolaId, Integer turmaId) {
		log.info("Starting Method Delete in TurmaSpringDataJPAService");
		log.info("Parameter:Escola Id = {},", escolaId);
		Turma turmaByEscolaIdAndTurmaId = findTurmaByEscolaIdAndTurmaId(escolaId, turmaId);
		log.info("Deleting escola by id on escolaRepository");
		try {
			turmaRepository.delete(turmaByEscolaIdAndTurmaId);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir");
		}
		log.info("Finishing Method deleteById in TurmaSpringDataJPAService");
	}

	@Override
	public void matricula(Integer escolaId, Integer turmaId, Integer idAluno) {
		log.info("Starting Method matricula in TurmaSpringDataJPAService");
		Turma turmaByEscolaIdAndTurmaId = findTurmaByEscolaIdAndTurmaId(escolaId, turmaId);
		Aluno alunoById = alunoService.findById(idAluno);
		turmaByEscolaIdAndTurmaId.matriculaAluno(alunoById);
		turmaRepository.save(turmaByEscolaIdAndTurmaId);
		log.info("Finishing Method matricula in TurmaSpringDataJPAService");
	}
}
