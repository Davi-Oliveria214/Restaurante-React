package com.davi.restaurante.records.request;

import com.davi.restaurante.entity.UsuarioEntity;
import jakarta.validation.constraints.NotNull;

public record CadastroRecord(@NotNull String nome, @NotNull String email,
                             @NotNull String senha) {
    public CadastroRecord(UsuarioEntity user) {
        this(user.getNome(), user.getEmail(), user.getSenha());
    }
}