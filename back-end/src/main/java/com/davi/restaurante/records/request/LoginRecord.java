package com.davi.restaurante.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record LoginRecord(@NotNull String email, @NotNull String senha) {
}