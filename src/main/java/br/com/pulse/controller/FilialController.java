package br.com.pulse.controller;

import br.com.pulse.model.Filial;
import br.com.pulse.service.impl.FilialService;
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
@RequestMapping(value = "/filiais")
public class FilialController {

    private final FilialService filialService;

    @GetMapping
    public ResponseEntity<List<Filial>> listar(){
        return ok(filialService.listarFiliais());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Filial>> buscarFilial(@PathVariable("id") Long id){
        return ok(filialService.buscarFilial(id));
    }

    @PostMapping
    public ResponseEntity<Filial>salvarFilial(@Valid @RequestBody Filial filial){
        Filial filialNova = filialService.salvarFilial(filial);
        return new ResponseEntity<>(filialNova, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Filial>atualizarFilial(@Valid @RequestBody Filial filial){
        Filial filialAtualizada = filialService.atualizarFilial(filial);
        return new ResponseEntity<>(filialAtualizada, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String>deletar(@PathVariable("id") Long id){
        filialService.deletarFilial(id);
        return ok("Filial deletada com sucesso!");
    }
}
