/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Empresa;
import Repositorio.EmpresaRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class EmpresaListDAO implements EmpresaRepositorio{

    private static List<Empresa> empresas = new ArrayList<>();
    
    @Override
    public void salvarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    @Override
    public List<Empresa> recuperarTodasEmpresas() {
        return this.empresas;
    }
    
    
}
