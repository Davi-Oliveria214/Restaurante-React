package com.davi.restaurante.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mesa")
public class MesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "numero_mesa")
    private Integer numero;

    public MesaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
