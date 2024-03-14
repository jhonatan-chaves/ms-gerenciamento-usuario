package com.jhonatan.controller;

import com.jhonatan.dto.UsuarioDto;
import com.jhonatan.models.Usuario;
import com.jhonatan.repository.UsuarioR;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioC {

    @Autowired
    private UsuarioR usuarioR;

    @PostMapping("/criar")
    public ResponseEntity<Usuario> criar(@RequestBody UsuarioDto usuarioDto){
        var user = new Usuario();
        BeanUtils.copyProperties(usuarioDto, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioR.save(user));
    }
}
