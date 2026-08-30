package com.davi.restaurante.records.request;

import jakarta.validation.constraints.NotNull;

public record PratoRecord(@NotNull String nome, @NotNull String descricao, @NotNull Double preco) {
}