package br.com.pulse.model.enums;

/**
 * Enum para indicar os tipos de pedidos que podem haver no estoque: ENTRADA (1) e SAIDA (2) *
 * @author Francinette Borges
 * **/
public enum TipoPedido {
    ENTRADA(1),
    SAIDA(2);

    private Integer codigo;

    TipoPedido(Integer codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

}
