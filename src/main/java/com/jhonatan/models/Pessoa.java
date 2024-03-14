package com.jhonatan.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public class Pessoa implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

    @Column(name = "name", length = 25)
    protected String name;

    @Column(name = "cpf", length = 15)
    protected String cpf;

    @Column(name = "data_nacimento", length = 15)
    protected String dataNascimento;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
