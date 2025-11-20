package com.animalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.animalcare.model.AgendaCuidado;

public interface AgendaCuidadoRepository extends JpaRepository<AgendaCuidado, Long> {
    
}
