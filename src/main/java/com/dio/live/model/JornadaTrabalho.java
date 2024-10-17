package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class JornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração de ID com estratégia definida
    @Column(name = "ID") // Garante que a coluna seja chamada de "ID"
    private Long id; // Trocar de `long` para `Long` para lidar com possíveis valores nulos

    @Column(name = "DESCRICAO_JORNADA") // Garante que a descrição tenha o nome correto da coluna
    private String descricao;
}
