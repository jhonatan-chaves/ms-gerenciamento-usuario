package com.jhonatan.services;

import com.jhonatan.models.Usuario;
import com.jhonatan.repository.UsuarioR;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioR usuarioR;

    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioR.save(usuario);
    }
}
