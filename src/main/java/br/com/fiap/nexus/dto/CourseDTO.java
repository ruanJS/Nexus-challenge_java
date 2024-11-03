package br.com.fiap.nexus.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long id;

    @NotNull
    private String name;

    public CourseDTO(String name) {
        this.name = name;
    }
}
