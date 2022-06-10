/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Empresa;
import Repositorio.EmpresaRepositorio;
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
    
    
}
