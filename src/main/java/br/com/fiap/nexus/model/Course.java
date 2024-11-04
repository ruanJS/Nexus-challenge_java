package br.com.fiap.nexus.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "t_courses")
public class Course {

    // Getters e Setters
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private int duration;  // Duração do curso em horas, dias, etc. (conforme necessário)

    @Column(length = 1000)
    private String description;  // Descrição detalhada do curso

    @ManyToMany
    @JoinTable(
            name = "course_name",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

}
