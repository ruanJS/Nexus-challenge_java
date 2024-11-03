package br.com.fiap.nexus.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class InterestController {

    @NotNull
    private Long id; // Adicione o ID se necessário

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    // Construtor sem argumentos
    public InterestController() {
    }

    // Construtor com argumentos
    public InterestController(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
