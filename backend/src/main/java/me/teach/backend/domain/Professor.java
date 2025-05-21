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
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Lob
    private String biografia;
    private Double valorHoraAula;
    private String formacaoAcademica;
    private Integer anosExperiencia;
    private Boolean disponivelOnline;
    private Boolean disponivelPresencial;

    @OneToMany(mappedBy = "professor")
    private List<ProfessorDisciplina> disciplinas;

    @OneToMany(mappedBy = "professor")
    private List<Aula> aulas;

}
