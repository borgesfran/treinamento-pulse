package br.com.pulse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedidoEstoque {

    private Long idItemPedido;

    private  PedidoEstoque pedidoEstoque;

    @NotNull(message = "O produto a ser pedido deve ser informado")
    private Produto produtoItemPedido;

    @NotNull(message = "A quantidade de itens pedidos deve ser informada")
    private double qtdItemPedido;
}
