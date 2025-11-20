package com.animalcare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="agenda_cuidado")
@AllArgsConstructor
@NoArgsConstructor
public class AgendaCuidado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    
    @ManyToOne
    @JoinColumn(name = "cuidado_idm", nullable = false)
    private Cuidado cuidado;

    @Column(nullable = false)
    private String frequencia;

}
