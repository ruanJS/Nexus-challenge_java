package br.com.fiap.nexus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Importar a anotação Table
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "users") // Mapeando a tabela como "users"
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera um ID automaticamente
    private Long id;

    private String username;
    private String password;
    private boolean active;
    private String name;
    private String email;

    // Construtor com todos os parâmetros
    public User(Long id, String username, String password, boolean active, String name, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.name = name;
        this.email = email;
    }

    // Construtor vazio para o JPA
    public User() {
    }

    // Implementação dos métodos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Aqui você pode implementar as permissões
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
