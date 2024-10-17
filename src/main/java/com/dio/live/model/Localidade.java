package com.dio.live.model;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Localidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private long id;

    @ManyToOne
    @JoinColumn(name = "nivel_acesso_id") // Define a chave estrangeira explicitamente
    private NivelAcesso nivelAcesso;

    @NotNull(message = "Descrição não pode ser nula")
    @Size(max = 100, message = "Descrição não pode ter mais que 100 caracteres")
    private String descricao;

    @OneToMany(mappedBy = "localidade", cascade = CascadeType.ALL) // Relacionamento bidirecional
    private List<Usuario> usuarios; // Lista de usuários na Localidade
}
