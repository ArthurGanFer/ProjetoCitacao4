package com.br.citacao.controller;


import com.br.citacao.model.Usuario;
import com.br.citacao.model.dao.UsuarioDAO;

import java.util.List;


/**
 *
 * @author 1147106
 */
public class Controller {

    public Controller() {
        
        UsuarioDAO usuariodao = new UsuarioDAO();
        
        
        //Usuario usuario1 = new Usuario("admin", "admin");
        //usuariodao.insert(usuario1);
        
        
        List<Usuario> lista = usuariodao.read();
        System.out.println("--- LEITURA --");
        for (Usuario u : lista) {
            System.out.println(u);
        }
        
        
        
        
    }
  
}
