/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Empresa;
import Repositorio.EmpresaRepositorio;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author julia
 */
public class EmpresaListDAO implements EmpresaRepositorio{

    private static Set<Empresa> empresas = new HashSet<>();
    
    @Override
    public boolean salvarEmpresa(Empresa empresa) {
        return empresas.add(empresa);
    }

    @Override
    public Set<Empresa> recuperarTodasEmpresas() {
        return this.empresas;
    }
        
// Criação da Tabela no Banco de Dados    
//    private static void createTableEmpresaBD(){
//        Connection connection = Conexao.getConnection();
//        String sqlCreate = "CREATE TABLE IF NOT EXISTS empresa"
//                + " (id_entidade INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + "  nome               TEXT,"
//                + "  cnpj               TEXT,"
//                + "  id_endereco        INTEGER)";
//        
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            stmt.execute(sqlCreate);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
}
