package com.animalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.animalcare.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    
}
