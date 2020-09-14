package br.com.pulse.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Filial {

    private Long idFilial;

    @NotNull(message = "A descrição da Filial não pode ser nula")
    @NotBlank(message = "Deve ser informada uma descrição para a Filial")
    private String descricaoFilial;
}
