package br.com.pulse.mapper;

import br.com.pulse.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProdutoMapper {

    void inserirProduto(@Param("produto") Produto produto);

    boolean atualizarProduto(@Param("produto") Produto produto);

    boolean deletarProduto(@Param("idProduto") Long idProduto);

    List<Produto> listarProdutos();

    Optional<Produto> buscarProduto(@Param("idProduto") Long idProduto);

}
