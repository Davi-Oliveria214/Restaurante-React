package com.davi.restaurante.services;

import com.davi.restaurante.entity.UsuarioEntity;
import com.davi.restaurante.exceptions.UsuarioException;
import com.davi.restaurante.records.request.CadastroRecord;
import com.davi.restaurante.records.request.LoginRecord;
import com.davi.restaurante.records.response.AuthRecord;
import com.davi.restaurante.records.response.UsuarioResponseRecord;
import com.davi.restaurante.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioService() {
    }

    public AuthRecord cadastrar(CadastroRecord record) {
        UsuarioEntity user = new UsuarioEntity();

        if (this.repository.existsByEmail(record.email()))
            throw new UsuarioException("Esse email já está cadastrado", HttpStatus.CONFLICT);

        BeanUtils.copyProperties(record, user);

        user.setSenha(this.hashPassWord(record.senha()));

        return new AuthRecord(this.repository.save(user));
    }

    public AuthRecord login(LoginRecord record) {
        UsuarioEntity user = this.repository.findByEmail(record.email()).orElseThrow(() -> new UsuarioException("Nenhum usuário encontrado", HttpStatus.UNAUTHORIZED));

        String pass = hashPassWord(record.senha());
        if (!user.getSenha().equals(pass))
            throw new UsuarioException("Email ou senha inválidos", HttpStatus.UNAUTHORIZED);

        return new AuthRecord(user);
    }

    public UsuarioResponseRecord usuario(Long id) {
        UsuarioEntity user = this.repository.findById(id).orElseThrow(() -> new UsuarioException("Erro ao verificar usuário", HttpStatus.NOT_FOUND));

        return new UsuarioResponseRecord(user);
    }

    private String hashPassWord(String senha) {
        MessageDigest passHash;

        try {
            passHash = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new UsuarioException("Erro ao criptografar senha", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return HexFormat.of().formatHex(passHash.digest(senha.getBytes(StandardCharsets.UTF_8)));
    }
}
