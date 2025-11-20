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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody @Valid AnimalRequestDTO dados) {
        // Convertendo DTO para Entidade
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
    
}
