package com.animalcare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animalcare.dto.AnimalRequestDTO;
import com.animalcare.model.Animal;
import com.animalcare.repository.AnimalRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/animais")

public class AnimalController {

    private final AnimalRepository repository;
    public AnimalController(AnimalRepository animal) {
        this.repository = animal;
    }

    @GetMapping
    public List<Animal> listarAnimais() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
               .map(animal -> ResponseEntity.ok(animal))
               .orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody @Valid AnimalRequestDTO dados) {
        Animal novoAnimal = new Animal();
        novoAnimal.setNome(dados.nome());
        novoAnimal.setEspecie(dados.especie());
        novoAnimal.setDescricao(dados.descricao());
        novoAnimal.setHabitat(dados.habitat());
        novoAnimal.setOrigem(dados.origem());
        novoAnimal.setNascimento(dados.nascimento());

        Animal animalSalvo = repository.save(novoAnimal);

        return ResponseEntity.ok(animalSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(@PathVariable Long id, @RequestBody @Valid AnimalRequestDTO dados) {
        return repository.findById(id)
               .map(animal -> {
                animal.setNome(dados.nome());
                animal.setEspecie(dados.especie());
                animal.setDescricao(dados.descricao());
                animal.setHabitat(dados.habitat());
                animal.setOrigem(dados.origem());
                animal.setNascimento(dados.nascimento());
                Animal animalAtualizado = repository.save(animal);
                return ResponseEntity.ok(animalAtualizado);
               })
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
