package br.com.pulse.service.impl;

import br.com.pulse.exception.ServiceException;
import br.com.pulse.mapper.EstoqueMapper;
import br.com.pulse.model.Estoque;
import br.com.pulse.service.IEstoqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstoqueService implements IEstoqueService {

    private final EstoqueMapper estoqueMapper;

    @Override
    public Estoque salvarEstoque(Estoque estoque) {
        estoqueMapper.inserirEstoque(estoque);

        if(estoque.getIdEstoque()==null){
            log.error("Erro ao salvar estoque");
            throw new ServiceException("Erro ao salvar estoque");
        }

        return  estoque;
    }

    @Override
    public Estoque atualizarEstoque(Estoque estoque) {
        Optional <Estoque> estoqueBuscado = estoqueMapper.buscarEstoquePorProdutoEFilial(estoque.getProdutoEstoque().getIdProduto(), estoque.getFilialEstoque().getIdFilial());
        if(estoqueBuscado.isPresent()){
           boolean estoqueAlterado = estoqueMapper.atualizarEstoque(estoque);
           if(!estoqueAlterado){
               log.error("Erro ao atualizar Estoque");
               throw new ServiceException("Erro ao atualizar Estoque");
           }
        }else{
            log.error("Estoque buscado para alteração não existe");
            throw new ServiceException("Estoque buscado para alteração não existe");
        }

        return estoque;
    }

    @Override
    public void deletarEstoque(Long idEstoque) {
        boolean deletado = estoqueMapper.deletarEstoque(idEstoque);
        if(!deletado){
            log.error("Erro ao deletar estoque");
            throw new ServiceException("Erro ao deletar estoque");
        }
    }

    @Override
    public List<Estoque> listarEstoques() {
        List<Estoque> estoquesCadastrados = estoqueMapper.listarEstoques();
        if(estoquesCadastrados.isEmpty()) throw new ServiceException("Sem estoques cadastrados ainda");
        return estoquesCadastrados;
    }

    @Override
    public List<Estoque> listarEstqouePorFilial(Long idFilial) {
        List<Estoque> estoquesPorFilial = estoqueMapper.listarEstoquePorFilial(idFilial);
        if(estoquesPorFilial.isEmpty()) throw new ServiceException("Sem estoque cadastrado para essa filial");
        return estoquesPorFilial;
    }

    @Override
    public List<Estoque> listarEstoquePorProduto(Long idProduto) {
        List<Estoque> estoquesPorProduto = estoqueMapper.listarEstoquePorProduto(idProduto);
        if(estoquesPorProduto.isEmpty()) throw new ServiceException("Sem estoque cadastrado para esse produto");
        return estoquesPorProduto;
    }
}
