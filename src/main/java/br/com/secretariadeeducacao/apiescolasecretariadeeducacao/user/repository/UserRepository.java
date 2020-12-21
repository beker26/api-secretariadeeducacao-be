package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
