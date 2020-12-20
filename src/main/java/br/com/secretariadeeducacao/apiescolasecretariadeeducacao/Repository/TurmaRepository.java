package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
	@Query(name = "Turma.findByTurma_escolaIdAndturmaId", nativeQuery = true)
	Optional<Turma> findByTurma_escolaIdAndturmaId(Integer escolaId, Integer turmaId);

	@Query(name = "Turma.deleteByTurma_EscolaIdAndTurmaId", nativeQuery = true)
	void deleteByTurma_EscolaIdAndTurmaId(Integer escolaId, Integer turmaId);

	@Modifying
	@Query(name = "Turma.findByEscolaId", nativeQuery = true)
	List<Turma> findByEscolaId(Integer escolaId);
}
