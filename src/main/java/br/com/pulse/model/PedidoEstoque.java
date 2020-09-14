package br.com.pulse.model;

import br.com.pulse.model.enums.TipoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoEstoque {

    private Long idPedidoEstoque;

    private int qtdTotalPedido;

    private double valorTotalPedido;

    @NotNull(message = "O tipo de pedido deve ser informado")
    private TipoPedido tipoPedido;
}
