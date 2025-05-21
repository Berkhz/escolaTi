package me.teach.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String fotoPerfil;
    private LocalDateTime dataCadastro;
    private Boolean ativo;
    private LocalDateTime ultimoAcesso;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Professor professor;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Aluno aluno;
}
