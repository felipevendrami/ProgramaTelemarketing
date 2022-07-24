/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Divulgacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author felip
 */
public class AtendimentoDivulgacaoListDAO {
    
    private static void createTableAtendimentoDivulgacaoBD(){
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS atendimento_divulgacao"
                +  " (id_ate_divulgacao     INTEGER PRIMARY KEY AUTOINCREMENT,"
                +  "  id_atendimento        INTEGER,"
                +  "  id_venda              INTEGER,"
                +  "  tipo_contato          TEXT,"
                +  "  contato               TEXT,"
                +  "  conversao             INTEGER,"
                +  "  FOREIGN KEY (id_atendimento) REFERENCES atendimento (id_atendimento))";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarAtendimentoDivulgacaoBD(Divulgacao atendimentoDivulgacao){
        createTableAtendimentoDivulgacaoBD();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO atendimento_divulgacao (id_atendimento, id_venda, tipo_contato, contato, conversao) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(atendimentoDivulgacao.getIdAtendimento()));
            pstmt.setString(2, null);
            pstmt.setString(3, atendimentoDivulgacao.getTipoContato());
            pstmt.setString(4, atendimentoDivulgacao.getContato());
            String conversao = "0";
            if(atendimentoDivulgacao.isConversao() == true){
                conversao = "1";
            }
            pstmt.setString(5, conversao);
            pstmt.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
}
