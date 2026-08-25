package com.davi.restaurante.services;

import com.davi.restaurante.entity.PratoEntity;
import com.davi.restaurante.exceptions.PratoException;
import com.davi.restaurante.exceptions.RestauranteException;
import com.davi.restaurante.records.request.PratoRecord;
import com.davi.restaurante.records.response.PratoResponseRecord;
import com.davi.restaurante.repository.PratoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {
    @Autowired
    private PratoRepository repository;

    public PratoResponseRecord adicionarPrato(PratoRecord pratoRecord) {
        if (this.repository.findByNome(pratoRecord.nome()).isPresent())
            throw new RestauranteException("Esse prato já existe");

        PratoEntity prato = new PratoEntity();
        BeanUtils.copyProperties(pratoRecord, prato);

        this.repository.save(prato);
        return new PratoResponseRecord(prato);
    }

    public PratoResponseRecord apagar(Long id) {
        PratoEntity prato = this.repository.findById(id).orElseThrow(() -> new PratoException("Erro ao apagar o prato", HttpStatus.NOT_FOUND));

        this.repository.delete(prato);

        return new PratoResponseRecord(prato);
    }

    public PratoResponseRecord pratoId(Long id) {
        PratoEntity prato = this.repository.findById(id).orElseThrow(PratoException::new);
        return new PratoResponseRecord(prato);
    }

    public List<PratoResponseRecord> todosPratos() {
        List<PratoEntity> pratos = this.repository.findAll();

        if (pratos.isEmpty()) throw new PratoException();

        return pratos.stream().map(PratoResponseRecord::new).toList();
    }

    public PratoResponseRecord editarPrato(Long id, PratoRecord record) {
        PratoEntity prato = this.repository.findById(id).orElseThrow(() -> new PratoException("Erro ao editar as informações do prato", HttpStatus.NOT_FOUND));
        prato.setNome(record.nome());
        prato.setDescricao(record.descricao());
        prato.setPreco(record.preco());

        this.repository.save(prato);

        return new PratoResponseRecord(prato);
    }
}