package com.davi.restaurante.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos", uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_data_mesa",
                columnNames = {"data_agendada", "mesa"}
        )
})
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_agendada", nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private int duracao;

    @ManyToOne
    @JoinColumn(name = "mesa", nullable = false, referencedColumnName = "numero_mesa")
    private MesaEntity mesa;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    public AgendamentoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public MesaEntity getMesa() {
        return mesa;
    }

    public void setMesa(MesaEntity mesa) {
        this.mesa = mesa;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
