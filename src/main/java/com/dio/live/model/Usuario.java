package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente (opcional)
    private Long id;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    private String nome;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;

    @ManyToOne
    @JoinColumn(name = "localidade_id")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED) // Ajuste correto
    private Localidade localidade;

    private BigDecimal tolerancia;

    private LocalDateTime inicioJornada;

    private LocalDateTime finalJornada;
}
