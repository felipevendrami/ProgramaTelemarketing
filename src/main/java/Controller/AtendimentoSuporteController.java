/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AtendimentoListDAO;
import Exception.CadastroAtendimentoException;
import Model.Atendimento;
import Model.Colaborador;
import Model.Empresa;
import Model.Suporte;
import Model.Venda;
import Repositorio.AtendimentoRepositorio;
import View.AtendimentoSuporteView;
import View.CadastroAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felip
 */
public class AtendimentoSuporteController {
    
    //View
    private AtendimentoSuporteView atendimentoSuporte;
    private CadastroAtendimentoView cadastroAtendimento;

    public AtendimentoSuporteController(AtendimentoSuporteView atendimentoSuporte, CadastroAtendimentoView cadastroAtendimento) {
        this.atendimentoSuporte = atendimentoSuporte;
        this.cadastroAtendimento = cadastroAtendimento;
        inicializarBotoes();
    }
    
    public void exibirTelaAtendimentoSuporte(){
        atendimentoSuporte.exibirTelaAtendimentoSuporte();
    }
    
    public void inicializarBotoes(){
        atendimentoSuporte.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atendimentoSuporte.fecharTela();
            }
        });
        atendimentoSuporte.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    abrirAtendimentoSuporte();
                    cadastroAtendimento.limparTela();
                    atendimentoSuporte.fecharTela();
                } catch (CadastroAtendimentoException ex){
                    atendimentoSuporte.exibirMensagem(ex.getMessage());
                }
            }
        });
        atendimentoSuporte.adicionarAcaoBuscar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    //RECUPERADOS DA VIEW
    
    public void identificaExcecao() throws CadastroAtendimentoException{
        if(atendimentoSuporte.getVenda() == null){
            throw new CadastroAtendimentoException("É necessário selecionar uma venda.");
        } else if(atendimentoSuporte.getTramite().isBlank()){
            throw new CadastroAtendimentoException("Campo 'Trâmite' não pode ficar vazio.");
        }
    }
    
    public void abrirAtendimentoSuporte(){
        AtendimentoRepositorio atendimentoRepositorio = new AtendimentoListDAO();
        Atendimento atendimento = recuperarAtendimentoSuporte();
        atendimentoRepositorio.salvarAtendimento(atendimento);
        atendimentoSuporte.exibirMensagem("Atendimento aberto com sucesso");
    }
    
    public Atendimento recuperarAtendimentoSuporte(){
        //Recuperamos as informações da tela
        Venda venda =  atendimentoSuporte.getVenda();
        Empresa empresa = cadastroAtendimento.getEmpresa();
        Colaborador responsavel = cadastroAtendimento.getResponsavel();
        String tramite = atendimentoSuporte.getTramite();
        //Criamos o atendimento e retornamos
        Atendimento atendimentoSuporte = new Suporte(venda, responsavel, tramite, empresa);
        return atendimentoSuporte;
    }
}
