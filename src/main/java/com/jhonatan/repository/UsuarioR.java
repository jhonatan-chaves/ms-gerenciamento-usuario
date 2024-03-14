package com.jhonatan.repository;

import com.jhonatan.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioR extends JpaRepository<Usuario, UUID> {
}
