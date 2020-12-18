package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

	List<Turma> findByNome(String nomeTurma);

}
