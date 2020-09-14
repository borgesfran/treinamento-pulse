package br.com.pulse.service;

import br.com.pulse.model.Produto;

import java.util.List;
import java.util.Optional;

public interface IProdutoService {

    Produto salvarProduto(Produto produto);

    Produto atualizarProduto(Produto produto);

    void deletarProduto(Long idProduto);

    List<Produto> listarProdutos();

    Optional<Produto> buscarProduto(Long idProduto);
}
