package com.animalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.animalcare.model.Cuidado;

public interface CuidadoRepository extends JpaRepository<Cuidado, Long> {
    
}
