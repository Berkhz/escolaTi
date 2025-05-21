package me.teach.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String categoria;

    @OneToMany(mappedBy = "disciplina")
    private List<ProfessorDisciplina> professores;

    @OneToMany(mappedBy = "disciplina")
    private List<Aula> aulas;
}
