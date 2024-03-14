package com.jhonatan.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class Usuario extends Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;


    @Column(name = "user_name", length = 25)
    private String userName;

    @Column(name = "password", length = 100)
    private String password;

    public Usuario(){}

    public Usuario (UUID id, String name, String cpf, String dataNascimento, String userName, String password){
        super.id = id;
        super.name = name;
        super.cpf = cpf;
        super.dataNascimento = dataNascimento;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
