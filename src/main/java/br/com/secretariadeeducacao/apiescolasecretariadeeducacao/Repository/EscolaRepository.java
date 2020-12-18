package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {

}
