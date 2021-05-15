/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reinaldo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author naldo
 */
public class PilotoUtil {
    
    private static Connection conexao = null;
    
    public static Connection getConexao(){
        try
        {
               /*
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/usuario";
                String user = "root";
                String password = "";
                */
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/FORMULA_UM";
                String user = "postgres";
                String password = "admin";
                  
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, user, password);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return conexao;
        
    }
}

