/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import Controller.MenuInicialController;
import DAO.ClienteListDAO;
import DAO.ColaboradorListDAO;
import DAO.EmpresaListDAO;
import Model.Cliente;
import Model.Colaborador;
import Model.Empresa;
import Model.Endereco;
import Repositorio.ClienteRepositorio;
import Repositorio.ColaboradorRepositorio;
import Repositorio.EmpresaRepositorio;
import View.MenuInicialView;

/**
 *
 * @author felip
 */
public class AppComController {
    
    public static void main(String[] args) {
        
        ClienteRepositorio clienteRepositorio = new ClienteListDAO();
        ColaboradorRepositorio colaboradorRepositorio = new ColaboradorListDAO();
        EmpresaRepositorio empresaRepositorio = new EmpresaListDAO();
        
        Endereco endereco = new Endereco("Rua do Teste", "Testinho", "Ibirama", "SC");
        Endereco endereco2 = new Endereco("Rua do Seu Chico", "Centro", "Rio do Sul", "SC");
        Endereco endereco3 = new Endereco("Rua Testinho", "Bela Vista", "Blumenau", "SC");
        
        Cliente cliente = new Cliente("Paulo Assis", endereco, null, "123.456.120-66");
        Cliente cliente2 = new Cliente("João Silva", endereco2, null, "774.669.889-99");
        Cliente cliente3 = new Cliente("Jonas Santos", endereco3, null, "123.456.741-95");
        clienteRepositorio.salvarCliente(cliente);
        clienteRepositorio.salvarCliente(cliente2);
        clienteRepositorio.salvarCliente(cliente3);
        
        Colaborador colaborador = new Colaborador("Felipe Diniz", endereco, null, "SAC", "Divugação");
        Colaborador colaborador2 = new Colaborador("Julia Sales", endereco2, null, "SAC", "Suporte");
        Colaborador colaborador3 = new Colaborador("Nicoly Cuch", endereco3, null, "SAC", "Pesquisa");
        colaboradorRepositorio.salvarColaborador(colaborador);
        colaboradorRepositorio.salvarColaborador(colaborador2);
        colaboradorRepositorio.salvarColaborador(colaborador3);
        
        Empresa empresa = new Empresa("SuperLoja LTDA", endereco, null, "09.979.940/0001-49");
        Empresa empresa2 = new Empresa("Eletro Marques LTDA", endereco2, null, "76.629.591/0001-22");
        Empresa empresa3 = new Empresa("Celulares Alves", endereco3, null, "08.855.496/0001-97");
        empresaRepositorio.salvarEmpresa(empresa);
        empresaRepositorio.salvarEmpresa(empresa2);
        empresaRepositorio.salvarEmpresa(empresa3);
        
        MenuInicialController menuInicial = new MenuInicialController(new MenuInicialView());
        menuInicial.exibirTelaMenuInicial();
    }
}
