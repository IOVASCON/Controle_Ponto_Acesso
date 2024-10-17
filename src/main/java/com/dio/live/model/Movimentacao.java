package com.dio.live.model;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class MovimentacaoId implements Serializable {
        private long idMovimento;
        private long idUsuario;
    }

    @EmbeddedId
    private MovimentacaoId movimentacaoId;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;

    @ManyToOne
    @JoinColumn(name = "ocorrencia_id", nullable = false) // Define a chave estrangeira explicitamente
    private Ocorrencia ocorrencia;

    @ManyToOne
    @JoinColumn(name = "calendario_id", nullable = false) // Define a chave estrangeira explicitamente
    private Calendario calendario;
}
