package br.com.fiap.nexus.repository;

import br.com.fiap.nexus.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
