package com.davi.restaurante.records.response;

import com.davi.restaurante.entity.UsuarioEntity;

public record AuthRecord(Long id, String nome, String email) {
    public AuthRecord(UsuarioEntity user) {
        this(user.getId(), user.getNome(), user.getEmail());
    }
}