package com.davi.restaurante.records.request;

import jakarta.validation.constraints.NotNull;

public record LoginRecord(@NotNull String email, @NotNull String senha) {
}