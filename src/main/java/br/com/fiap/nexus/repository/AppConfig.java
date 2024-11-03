package br.com.fiap.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
