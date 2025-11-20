package com.animalcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record AnimalRequestDTO(
    
    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 250, message = "O nome deve ter entre 2 e 250 caracteres")
    String nome,

    @NotBlank(message = "A espécie é obrigatória")
    String especie,

    @NotBlank(message = "A descrição é obrigatória")
    String descricao,

    @NotBlank(message = "O habitat é obrigatório")
    String habitat,

    @NotBlank(message = "A origem é obrigatória")
    String origem,

    @NotNull(message = "A data de nascimento é obrigatória")
    @PastOrPresent(message = "A data não pode ser no futuro")
    LocalDate nascimento
) {
}