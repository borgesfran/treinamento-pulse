package br.com.pulse.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Produto {
    private Long idProduto;

    @NotNull(message = "A descrição do Produto deve ser informada")
    @NotBlank(message = "Deve ser informada uma descrição para o Produto")
    private String descricaoProduto;

}
