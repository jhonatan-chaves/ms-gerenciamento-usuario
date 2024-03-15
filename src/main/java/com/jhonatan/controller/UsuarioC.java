package com.jhonatan.controller;

import com.jhonatan.dto.UsuarioDto;
import com.jhonatan.models.Usuario;
import com.jhonatan.repository.UsuarioR;
import com.jhonatan.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class UsuarioC {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioR usuarioR;


    @PostMapping("/criar")
    public ResponseEntity<Usuario> criar(@RequestBody UsuarioDto usuarioDto){
        var user = new Usuario();
        BeanUtils.copyProperties(usuarioDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(user));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>>  getUserAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioR.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable(value = "id") UUID id){
        return usuarioR.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Usuario> updateUser(@PathVariable(value = "id") UUID id,@RequestBody UsuarioDto usuarioDto){
       Optional<Usuario> userUpdate = usuarioR.findById(id);
       var user = userUpdate.get();
       BeanUtils.copyProperties(usuarioDto, user);
       return  ResponseEntity.status(HttpStatus.OK).body(usuarioR.save(user));
    }
}
