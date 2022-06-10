/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;
import Model.Empresa;
import java.util.Set;


/**
 *
 * @author julia
 */
public interface EmpresaRepositorio {
    public boolean salvarEmpresa(Empresa empresa);
    public Set<Empresa> recuperarTodasEmpresas();
}
