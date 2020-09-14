package br.com.pulse.service;


import br.com.pulse.model.Estoque;

import java.util.List;


public interface IEstoqueService {

    Estoque salvarEstoque(Estoque estoque);

    Estoque atualizarEstoque(Estoque estoque);

    void deletarEstoque(Long idEstoque);

    List<Estoque> listarEstoques();

    List<Estoque> listarEstqouePorFilial(Long idProduto);

    List<Estoque> listarEstoquePorProduto(Long idFilial);
}
