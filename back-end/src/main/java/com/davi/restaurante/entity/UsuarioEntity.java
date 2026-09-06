package com.davi.restaurante.entity;

import jakarta.persistence.*;

import java.time.Instant;
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

    @Column(name = "criado_em", nullable = false, updatable = false)
    private Instant criado;

    @Column(name = "tentativas_login")
    private int tentativas = 0;

    @Column(name = "tempo_bloqueio")
    private Instant bloqueio;

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

    @PrePersist
    private void onCreate() {
        this.criado = Instant.now();
    }

    public Instant getCriado() {
        return criado;
    }

    public void setCriado(Instant criado) {
        this.criado = criado;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public Instant getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(Instant bloqueio) {
        this.bloqueio = bloqueio;
    }

    public Set<AgendamentoEntity> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<AgendamentoEntity> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
