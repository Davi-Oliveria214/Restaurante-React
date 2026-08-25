package com.davi.restaurante.records.request;

import com.davi.restaurante.entity.PratoEntity;
import jakarta.validation.constraints.NotNull;

public record PratoRecord(@NotNull String nome, @NotNull String descricao, @NotNull Double preco) {
    public PratoRecord(PratoEntity prato) {
        this(prato.getNome(), prato.getDescricao(), prato.getPreco());
    }
}