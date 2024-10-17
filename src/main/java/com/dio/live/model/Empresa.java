package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @NotNull(message = "Descrição não pode ser nula")
    @Size(max = 100, message = "Descrição não pode ter mais que 100 caracteres")
    private String descricao;

    @NotNull(message = "CNPJ não pode ser nulo")
    @Size(min = 14, max = 14, message = "CNPJ deve ter exatamente 14 caracteres")
    private String cnpj;

    @NotNull(message = "Endereço não pode ser nulo")
    private String endereco;

    private String bairro;

    @NotNull(message = "Cidade não pode ser nula")
    private String cidade;

    @NotNull(message = "Estado não pode ser nulo")
    private String estado;

    @NotNull(message = "Telefone não pode ser nulo")
    @Size(min = 10, max = 15, message = "Telefone deve ter entre 10 e 15 caracteres")
    private String telefone;
}
