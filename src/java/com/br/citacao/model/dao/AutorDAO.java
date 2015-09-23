/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacao.model.dao;

import com.br.citacao.controller.Controller;
import com.br.citacao.model.Autor;
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
public class AutorDAO implements GenericDAO<Autor>{

    private Connection conn;

    public AutorDAO() {
        conn = ConnectionDB.getInstance();
    }
    
    @Override
    public boolean insert(Autor autor) {
        boolean resp = false;    
        String sql = "INSERT INTO autor(nome) VALUES(?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, autor.getNome());
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Erro na inserção do autor!");
            } else {
                System.out.println("Autor inserido com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public List<Autor> read() {
        List<Autor> autores = new ArrayList<>();
        //2. Criar o preparedStatement
        String sql = "SELECT * FROM autor";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //3. Executa a query
            ResultSet rs = ps.executeQuery();
            
            //4. Mostrar os resultados
            while(rs.next()){
                int id = rs.getInt("id_autor");
                String nome = rs.getString("nome");
                Autor a = new Autor(id, nome);
                autores.add(a);
            }
            
            //5. Fechar tudo
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autores;
    }

    @Override
    public boolean update(Autor autor) {
        boolean resp = false;
        String sql = "UPDATE autor SET nome=? WHERE id_autor=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, autor.getNome());
            ps.setInt(2, autor.getId_autor());
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Erro na atualização do Autor");
            } else {
                System.out.println("Autor atualizado com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public boolean delete(Autor autor) {
        boolean resp = false;
        String sql = "DELETE FROM autor WHERE id_autor=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, autor.getId_autor());
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Erro ao remover o autor");
            } else {
                System.out.println("Autor removido com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
}
