package br.com.fiap.nexus.repository;

import br.com.fiap.nexus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Object> findByUsername(String username);
}
