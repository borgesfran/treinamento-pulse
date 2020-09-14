package br.com.pulse.controller;

import br.com.pulse.model.Produto;
import br.com.pulse.service.impl.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        return ok(produtoService.listarProdutos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Produto>> buscarProduto(@PathVariable("id") Long id){
        return ok(produtoService.buscarProduto(id)) ;
    }

    @PostMapping
    public ResponseEntity<Produto>salvarProduto(@Valid @RequestBody Produto produto){
        Produto produtoNovo = produtoService.salvarProduto(produto);
        return new ResponseEntity<>(produtoNovo, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto>atualizarProduto(@Valid @RequestBody Produto produto){
        Produto produtoAtualizado = produtoService.atualizarProduto(produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String>deletar(@PathVariable("id") Long id){
        produtoService.deletarProduto(id);
        return ok("Produto deletado com sucesso!");
    }
}
