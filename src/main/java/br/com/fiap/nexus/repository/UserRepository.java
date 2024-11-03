package br.com.fiap.nexus.repository;

import br.com.fiap.nexus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
