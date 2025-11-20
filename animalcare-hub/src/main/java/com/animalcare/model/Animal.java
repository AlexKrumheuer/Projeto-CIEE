package com.animalcare.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length=200)
    private String nome;

    @Column(nullable = false,length=200)
    private String especie;

    @Column(nullable = false, length=500)
    private String descricao;

    @Column(nullable = false, length=200)
    private String habitat;

    @Column(nullable = false, length=200)
    private String origem;

    @Column(nullable = false)
    private LocalDate nascimento;
    
}
