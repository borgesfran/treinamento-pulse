package br.com.pulse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estoque {
    private Long idEstoque;

    private Filial filialEstoque;

    private Produto produtoEstoque;

    private int qtdEstoque;
}
