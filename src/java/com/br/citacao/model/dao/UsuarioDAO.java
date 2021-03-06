/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacao.model.dao;

import com.br.citacao.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1147106
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    private Connection conn;

    public UsuarioDAO() {
        //1. Realizar a conexão
        conn = ConnectionDB.getInstance();
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> usuarios = new ArrayList<>();
        //2. Criar o preparedStatement
        String sql = "SELECT * FROM usuario INNER JOIN usuario_info ON usuario.id_usuario = usuario_info.id_usuario";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. Executa a query
            ResultSet rs = ps.executeQuery();

            //4. Mostrar os resultados
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nome = rs.getString("username");
                String senha = rs.getString("senha");
                String nomeCompleto = rs.getString("nome");
                String email = rs.getString("email");
                Usuario u = new Usuario(id, nome, senha, nomeCompleto, email);
                usuarios.add(u);
            }

            //5. Fechar tudo
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public boolean insert(Usuario usuario) {
        boolean resp = false;
        String sql = "INSERT INTO usuario(username,senha) VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro ao inserir o Usuário");
            } else {
                System.out.println("Usuário inserido com sucesso!");
                resp = true;
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean update(Usuario usuario) {
        boolean resp = false;
        String sql = "UPDATE usuario SET username=?,senha=? WHERE id_usuario=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getId_usuario());
            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro ao atualizar o usuário");
            } else {
                System.out.println("Usuário atualizado com sucesso!");
                resp = true;
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(Usuario usuario) {
        boolean resp = false;
        String sql = "DELETE FROM usuario WHERE id_usuario=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, usuario.getId_usuario());
            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro ao remover o Usuário");
            } else {
                System.out.println("Usuário removido com sucesso!");
                resp = true;
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}
