package com.br.citacao.model;

import java.io.Serializable;

/**
 *
 * @author 1147106
 */
public class Usuario implements Serializable {
    private int id_usuario;
    private String nome, senha, nomeCompleto, email;

    public Usuario() {
        this.id_usuario = -1;
        this.nome = "anonimo";
        this.senha = "1234567";
        this.nomeCompleto = "Anonimo da Silva";
        this.email = "anonimo@email.com";
    }

    public Usuario(int id_usuario, String nome, String senha, String nomeCompleto, String email) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public Usuario(String nome, String senha) {
        this.id_usuario = -1;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nome=" + nome + ", senha=" + senha + ", nomeCompleto=" + nomeCompleto + ", email=" + email + '}';
    }
}
