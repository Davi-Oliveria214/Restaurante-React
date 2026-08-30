package com.davi.restaurante.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "passWord")
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private Set<AgendamentoEntity> agendamentos = new HashSet<>();

    public UsuarioEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<AgendamentoEntity> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<AgendamentoEntity> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
