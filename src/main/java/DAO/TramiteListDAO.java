/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Tramite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author felip
 */
public class TramiteListDAO {
    
    private static void createTableTramite(){
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS tramite"
                + " (id_tramite     INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "  id_atendimento INTEGER,"
                + "  data_tramite   TEXT,"
                + "  descricao      TEXT,"
                + "  tipo_tramite   TEXT,"
                + "  FOREIGN KEY (id_atendimento) REFERENCES atendimento (id_atendimento))";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarTramite(Tramite tramite, int idAtendimento){
        createTableTramite();
        
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO tramite (id_atendimento, data_tramite, descricao, tipo_tramite) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(idAtendimento));
            pstmt.setString(2, tramite.getDataTramite());
            pstmt.setString(3, tramite.getDescricao());
            pstmt.setString(4, tramite.getTipoTramite());
            pstmt.execute();
            final ResultSet resultado = pstmt.getGeneratedKeys();
            if(resultado.next()){
                int id = resultado.getInt(1);
                tramite.setIdTramite(id);
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
