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
    
    private static void createTableAtendimento(){
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS atendimento"
                + " (id_atendimento     INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "  id_empresa         INTEGER,"
                + "  id_colaborador     INTEGER,"
                + "  data_abertura      TEXT,"
                + "  data_fechamento    TEXT,"
                + "  situacao           TEXT,";
        
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void createTableAtendimentoDivulgacao(){
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS atendimento_divulgacao"
                +  " (id_ate_divulgacao     INTEGER PRIMARY KEY AUTOINCREMENT,"
                +  "  id_atendimento        INTEGER,"
                +  "  id_venda              INTEGER,"
                +  "  tipo_contato          TEXT,"
                +  "  contato               TEXT,"
                +  "  conversao             INTEGER,"
                +  "  FOREIGN KEY (id_atendimento) REFERENCES atendimento (id_atendimento)";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarAtendimentoo(Divulgacao atendimento){
        createTableAtendimento();
        
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO atendimento (id_empresa, id_colaborador, data_abertura, situacao) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(atendimento.getEmpresa().getIdEntidade()));
            pstmt.setString(2, Integer.toString(atendimento.getResponsavel().getIdEntidade()));
            pstmt.setString(3, atendimento.getDataAbertura());
            pstmt.setString(4, atendimento.getSituacao());
            pstmt.execute();
            System.out.println("Atendimento Gravado!");
            final ResultSet resultado = pstmt.getGeneratedKeys();
            if(resultado.next()){
                int id = resultado.getInt(1);
                atendimento.setIdAtendimento(id);
            }
            
            salvarAtendimentoDivulgacao(atendimento);
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean salvarAtendimentoDivulgacao(Divulgacao atendimentoDivulgacao){
        createTableAtendimentoDivulgacao();
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
            System.out.println("Divulgação gravada!");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
