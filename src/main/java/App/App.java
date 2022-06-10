/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import DAO.ClienteListDAO;
import DAO.ColaboradorListDAO;
import DAO.EmpresaListDAO;
import Model.Cliente;
import Model.Empresa;
import Model.Colaborador;
import Model.Endereco;
import Repositorio.ClienteRepositorio;
import Repositorio.ColaboradorRepositorio;
import Repositorio.EmpresaRepositorio;
import View.MenuInicialView;

/**
 *
 * @author felip
 */
public class App {
    public static void main(String[] args) {
        
        ClienteRepositorio clienteRepositorio = new ClienteListDAO();
        ColaboradorRepositorio colaboradorRepositorio = new ColaboradorListDAO();
        EmpresaRepositorio empresaRepositorio = new EmpresaListDAO();
        
        Endereco endereco = new Endereco("Rua do Teste", "Testinho", "Ibirama", "SC");
        
        Cliente cliente = new Cliente("Paulo", endereco, null, "123.456");
        clienteRepositorio.salvarCliente(cliente);
        
        Colaborador colaborador = new Colaborador("Felipe", endereco, null, "SAC", "Divugação");
        colaboradorRepositorio.salvarColaborador(colaborador);
        
        Empresa empresa = new Empresa("Empresa 1", endereco, null, "445.669");
        empresaRepositorio.salvarEmpresa(empresa);
        
        MenuInicialView menuInicial = new MenuInicialView();
        menuInicial.setVisible(true);
    }
}
