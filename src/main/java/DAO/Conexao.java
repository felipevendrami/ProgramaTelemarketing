/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author felip
 */
public class Conexao {
    
    private static Connection connection = null;
    static final String DB_URL = "jdbc:sqlite:prog_telemarketing.sqlite3";
    
    static final String USER = "a";
    static final String PASS = "a";
    
    public static Connection conectar(){
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Conexão realizada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public static void desconectar(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static Connection getConnection(){
        if(connection == null){
            conectar();
        }
        return connection;
    }
}
