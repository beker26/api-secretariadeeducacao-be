package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.turma;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

public interface TurmaService {
	List<Turma> findAll(Integer escolaId);

	Turma findTurmaByEscolaIdAndTurmaId(Integer escolaId, Integer turmaId);

	Turma insert(Integer escolaId, Turma turmaByForm);

	Turma update(Integer escolaId, Integer turmaId, Turma turmaByForm);
	
	void delete(Integer escolaId,Integer turmaId );

	void matricula(Integer escolaId, Integer turmaId, Integer idAluno);
}
