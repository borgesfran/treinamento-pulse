package br.com.pulse.service;

import br.com.pulse.exception.ServiceException;
import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;
import br.com.pulse.service.impl.ProdutoService;
import org.assertj.core.api.Assertions;
import org.jeasy.random.EasyRandom;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;

public class ProdutoServiceTest {

    private IProdutoService produtoService;
    private ProdutoMapper produtoMapper;
    private EasyRandom random;

    @Before
    public void iniciar(){
        produtoMapper = Mockito.mock(ProdutoMapper.class);
        produtoService = new ProdutoService(produtoMapper);
        random = new EasyRandom();
    }

    @Test
    public void deveTestarBuscarProdutoUnicoComSucesso(){
        Produto produto = random.nextObject(Produto.class);
        Mockito.when(produtoMapper.buscarProduto(ArgumentMatchers.anyLong())).thenReturn(Optional.of(produto));
        Optional <Produto> produtoBuscado = produtoService.buscarProduto(1L);
        Assertions.assertThat(produtoBuscado).hasValue(produto);
    }

    @Test
    public void deveTestarProdutoUnicoComExcecao(){
        Produto produto = random.nextObject(Produto.class);
        Mockito.when(produtoMapper.buscarProduto(3L)).thenReturn(Optional.of(produto));
        Assertions
                .assertThatThrownBy(()->produtoService.buscarProduto(1L))
                .isExactlyInstanceOf(ServiceException.class)
                .hasMessage("Produto com id 1 inexistente");
    }
}
