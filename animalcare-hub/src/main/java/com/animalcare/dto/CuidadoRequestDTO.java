package com.animalcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CuidadoRequestDTO(
    @NotBlank(message = "O nome do cuidado não pode estar em branco")
    @Size(min = 2, max = 250, message = "O nome deve ter entre 2 e 250 caracteres")
    String nome,
    @NotNull
    int duracao,
    @NotBlank(message = "A descrição do cuidado não pode estar em branco")
    String descricao
) {
}
