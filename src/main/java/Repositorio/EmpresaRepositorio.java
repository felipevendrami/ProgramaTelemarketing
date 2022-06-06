/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;
import Model.Empresa;
import java.util.List;


/**
 *
 * @author julia
 */
public interface EmpresaRepositorio {
    public void salvarEmpresa(Empresa empresa);
    public List<Empresa> recuperarTodasEmpresas();
}
