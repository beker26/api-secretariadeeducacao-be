package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>  {
	
	

}
