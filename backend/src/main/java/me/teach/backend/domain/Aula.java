package me.teach.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private Double valor;
    private String modalidade; // enum pode ser melhor
    private String status;     // enum pode ser melhor
    private String linkVirtual;
    private String enderecoLocal;

    @OneToMany(mappedBy = "aula")
    private List<Avaliacao> avaliacoes;


}

