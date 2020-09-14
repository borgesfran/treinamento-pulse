package br.com.pulse.service.impl;

import br.com.pulse.exception.ServiceException;
import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;
import br.com.pulse.service.IProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoService implements IProdutoService {

    private final ProdutoMapper produtoMapper;

    @Override
    public Produto salvarProduto(Produto produto){
        produtoMapper.inserirProduto(produto);

        if(produto.getIdProduto() == null){
            log.error("Erro ao salvar produto");
            throw new ServiceException("Erro ao salvar produto");
        }

        return produto;
    }

    @Override
    public Produto atualizarProduto(Produto produto){

        if(buscarProduto(produto.getIdProduto()).isPresent()) {
            boolean produtoAlterado = produtoMapper.atualizarProduto(produto);

            if(!produtoAlterado){
                log.error("Erro ao alterar produto");
                throw new ServiceException("Erro ao alterar produto");
            }
        }

        return produto;
    }

    @Override
    public void deletarProduto(Long idProduto) {
        boolean deletado = produtoMapper.deletarProduto(idProduto);
        if(!deletado){
            log.error("Erro ao deletar produto");
            throw new ServiceException("Erro ao deletar produto");
        }
    }

    @Override
    public List<Produto> listarProdutos() {
        List<Produto> produtosCadastrados = produtoMapper.listarProdutos();
        if(produtosCadastrados.isEmpty()) throw new ServiceException("Sem produtos cadastrados ainda");
        return produtosCadastrados;
    }

    @Override
    public Optional<Produto> buscarProduto(Long idProduto) {
        Optional<Produto> produtoBuscado = produtoMapper.buscarProduto(idProduto);
        if(!produtoBuscado.isPresent()){
            log.error("Produto buscado não existe");
            throw new ServiceException("Produto com id "+ idProduto+ " inexistente");
        }
        return  produtoBuscado;
    }
}
