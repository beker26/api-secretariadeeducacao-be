package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.aluno;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;

public interface AlunoService {

	List<Aluno> findAll();

	Aluno findById(Integer alunoId);

	Aluno insert(Aluno alunoObj);

	Aluno update(Integer alunoId, Aluno alunoObj);

	void delete(Integer alunoId);

}
