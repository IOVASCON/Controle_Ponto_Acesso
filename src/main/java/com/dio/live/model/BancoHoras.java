package com.dio.live.model;

import lombok.*;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
public class BancoHoras {

    @EqualsAndHashCode
    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor // Adicionando um construtor completo
    @NoArgsConstructor  // Adicionando um construtor sem argumentos
    public static class BancoHorasId implements Serializable {
        private Long idBancoHoras;  // Trocar de `long` para `Long`
        private Long idMovimentacao;  // Trocar de `long` para `Long`
        private Long idUsuario;  // Trocar de `long` para `Long`

    }

    @EmbeddedId
    private BancoHorasId bancoHorasId;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
