package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.aluno;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.AlunoRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AlunoSpringDataJPAServiceImpl implements AlunoService {

	private AlunoRepository alunoRepository;

	public AlunoSpringDataJPAServiceImpl(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<Aluno> findAll() {
		log.info("Starting Method findAll in ALunoSpringDataJPAService");
		List<Aluno> listAluno = this.alunoRepository.findAll();
		log.info("finishing Method findAll in  ALunoSpringDataJPAService");
		return listAluno;
	}

	@Override
	public Aluno findById(Integer alunoId) {
		log.info("Starting Method findById in ALunoSpringDataJPAService");
		log.info("Parameter:{}", alunoId);
		log.info("Finding Escola by id on ALunoRepository");
		Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
		log.info("Finishing Method findById in ALunoSpringDataJPAService");
		return aluno;
	}

	@Override
	public Aluno insert(Aluno alunoObj) {
		log.info("Starting Method save in ALunoSpringDataJPAService");
		alunoObj = alunoRepository.save(alunoObj);
		log.info("Finishing Method save in ALunoSpringDataJPAService");
		return alunoObj;
	}

	@Override
	public Aluno update(Integer alunoId, Aluno alunoByForm) {
		log.info("Starting Method update in ALunoSpringDataJPAService");
		Aluno alunoById = findById(alunoId);
		alunoById.update(alunoByForm);
		log.info("Save in AlunoRepository");
		alunoRepository.save(alunoById);
		log.info("Finishing Method save in ALunoSpringDataJPAService");
		return alunoById;
	}

	@Override
	public void delete(Integer alunoId) {
		log.info("Starting Method Delete in ALunoSpringDataJPAService");
		log.info("Parameter:Aluno Id = {}," , alunoId);
		findById(alunoId);
		log.info("Deleting escola by id on AlunoRepository");
		try {
			alunoRepository.deleteById(alunoId);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir");
		}
		log.info("Finishing Method deleteById in ALunoSpringDataJPAService");
		
	}

	

}
