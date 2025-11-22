package com.animalcare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animalcare.dto.CuidadoRequestDTO;
import com.animalcare.model.Cuidado;
import com.animalcare.repository.CuidadoRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/cuidados")
public class CuidadoController {
    private final CuidadoRepository repository;
    public CuidadoController(CuidadoRepository cuidado) {
        this.repository = cuidado;
    }

    @GetMapping
    public List<Cuidado> listarCuidados() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuidado> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
               .map(cuidado -> ResponseEntity.ok(cuidado))
               .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cuidado> cadastrar(@RequestBody @Valid CuidadoRequestDTO dados) {
        Cuidado novoCuidado = new Cuidado();
        novoCuidado.setNome(dados.nome());
        novoCuidado.setDuracao(dados.duracao());
        novoCuidado.setDescricao(dados.descricao());

        Cuidado cuidadoSalvo = repository.save(novoCuidado);
        return ResponseEntity.ok(cuidadoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuidado> atualizar(@PathVariable Long id,  @RequestBody @Valid CuidadoRequestDTO dados) {
        return repository.findById(id)
               .map(cuidado -> {
                cuidado.setNome(dados.nome());
                cuidado.setDescricao(dados.descricao());
                cuidado.setDuracao(dados.duracao());

                Cuidado cuidadoAtualizado = repository.save(cuidado);

                return ResponseEntity.ok(cuidadoAtualizado);
               })
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
