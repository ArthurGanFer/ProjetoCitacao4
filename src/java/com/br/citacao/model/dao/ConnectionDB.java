/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacao.model.dao;

import com.br.citacao.controller.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1147106
 */
public class ConnectionDB {
    private static String driver = "org.apache.derby.jdbc.ClientDriver";
    private static String protocolo = "jdbc:derby:";
    private static String db = "Citacaodb";
    private static String dominio = "//localhost:1527/";
    private static String user = "arthur";
    private static String pwd = "arthur123";
    private static Connection conn = null;
    
    public static Connection getInstance()
    {
        if(conn==null){
            try {
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(protocolo + dominio + db , user, pwd);
            } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
}