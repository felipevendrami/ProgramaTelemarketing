/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Atendimento;
import Model.Divulgacao;
import Repositorio.AtendimentoRepositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.StyleConstants;

/**
 *
 * @author felip
 */
public class AtendimentoListDAO implements AtendimentoRepositorio{

    private static List<Atendimento> atendimentos = new ArrayList<>();
    
    @Override
    public void salvarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    @Override
    public List<Atendimento> recuperarTodosAtendimentos() {
        return this.atendimentos;
    }
    
    private static void createTableAtendimentoBD(){
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS atendimento"
                + " (id_atendimento     INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "  id_empresa         INTEGER,"
                + "  id_colaborador     INTEGER,"
                + "  data_abertura      TEXT,"
                + "  data_fechamento    TEXT,"
                + "  situacao           TEXT,"
                + "  tipo               TEXT)";
        
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
    public static boolean salvarAtendimentoBD(Atendimento atendimento){
        createTableAtendimentoBD();
        
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO atendimento (id_empresa, id_colaborador, data_abertura, situacao, tipo) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(atendimento.getEmpresa().getIdEntidade()));
            pstmt.setString(2, Integer.toString(atendimento.getResponsavel().getIdEntidade()));
            pstmt.setString(3, atendimento.getDataAbertura());
            pstmt.setString(4, atendimento.getSituacao());
            pstmt.setString(5, atendimento.getTipo());
            pstmt.execute();
            final ResultSet resultado = pstmt.getGeneratedKeys();
            if(resultado.next()){
                int id = resultado.getInt(1);
                atendimento.setIdAtendimento(id);
            }            
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static void atualizaSituacaoAtendimento(int idAtendimento, String dataFechamento){
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE atendimento SET situacao = ?, data_fechamento = ? WHERE id_atendimento = " + idAtendimento;
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "Finalizado");
            pstmt.setString(2, dataFechamento);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
