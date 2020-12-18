package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.aluno;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;

@Service
public interface AlunoService {

	public List<Aluno> FindAll();
	
	
}
