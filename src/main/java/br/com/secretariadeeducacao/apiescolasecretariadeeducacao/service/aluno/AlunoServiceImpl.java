package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.aluno;

import java.util.List;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.AlunoRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;

public class AlunoServiceImpl implements AlunoService {

	private AlunoRepository alunoRepository;

	public AlunoServiceImpl(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<Aluno> FindAll() {

		return this.alunoRepository.findAll();
	}

}
