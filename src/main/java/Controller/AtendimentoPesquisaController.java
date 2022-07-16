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
import Model.ISelecaoVendaView;
import Model.Pesquisa;
import Model.Venda;
import Repositorio.AtendimentoRepositorio;
import View.AtendimentoPesquisaView;
import View.CadastroAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felip
 */
public class AtendimentoPesquisaController implements ISelecaoVendaView{
    
    //View
    private AtendimentoPesquisaView atendimentoPesquisa;
    private CadastroAtendimentoView cadastroAtendimento;

    public AtendimentoPesquisaController(AtendimentoPesquisaView atendimentoPesquisa, CadastroAtendimentoView cadastroAtendimento) {
        this.atendimentoPesquisa = atendimentoPesquisa;
        this.cadastroAtendimento = cadastroAtendimento;
        inicializarBotoes();
    }
    
    public void exibirTelaAtendimentoPesquisa(){
        atendimentoPesquisa.exibirTelaAtendimentoPesquisa();
    }
    
    public void inicializarBotoes(){
        atendimentoPesquisa.adicionarAcaoBuscar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        atendimentoPesquisa.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atendimentoPesquisa.fecharTela();
            }
        });
        atendimentoPesquisa.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    abrirAtendimentoPesquisa();
                    cadastroAtendimento.limparTela();
                    atendimentoPesquisa.fecharTela();
                } catch (CadastroAtendimentoException ex) {
                    atendimentoPesquisa.exibirMensagem(ex.getMessage());
                }
            }
        });
    }
    
    //RECUPERADOS VIEW
    
    public void identificaExcecao() throws CadastroAtendimentoException{
        if(atendimentoPesquisa.getVenda() == null){
            throw new CadastroAtendimentoException("É necessário selecionar uma venda.");
        } else if(atendimentoPesquisa.getSatisfAtendimento().isBlank() || atendimentoPesquisa.getSatisfProduto().isBlank() || (validaNiveisSatisfacao() == false)){
            throw new CadastroAtendimentoException("Verificar os níveis de satisfação.");
        } else if(atendimentoPesquisa.getTramite().isBlank()){
            throw new CadastroAtendimentoException("Campo 'Trâmite' não pode ficar vazio.");
        }
    }
    
    public boolean validaNiveisSatisfacao(){
        int satisfacaoProduto = Integer.parseInt(atendimentoPesquisa.getSatisfProduto());
        int satisfacaoAtendimento = Integer.parseInt(atendimentoPesquisa.getSatisfAtendimento());
        if((satisfacaoProduto >= 1 && satisfacaoProduto <= 3) && (satisfacaoAtendimento >= 1 && satisfacaoAtendimento <= 3)){
            return true;
        } else {
            return false;
        }
    }
    
    public void abrirAtendimentoPesquisa(){
        AtendimentoRepositorio atendimentoRepositorio = new AtendimentoListDAO();
        Atendimento atendimento = recuperarAtendimentoPesquisa();
        atendimentoRepositorio.salvarAtendimento(atendimento);
        atendimentoPesquisa.exibirMensagem("Atendimento aberto com sucesso !");
    }
    
    public Atendimento recuperarAtendimentoPesquisa(){
        //Recuperamos as informações da tela
        Venda venda = atendimentoPesquisa.getVenda();
        Empresa empresa = cadastroAtendimento.getEmpresa();
        Colaborador responsavel = cadastroAtendimento.getResponsavel();
        int satisfacaoProduto = Integer.parseInt(atendimentoPesquisa.getSatisfProduto());
        int satisfacaoAtendimento = Integer.parseInt(atendimentoPesquisa.getSatisfAtendimento());
        String tramite = atendimentoPesquisa.getTramite();
        //Criamos o atendimento e retornamos
        Atendimento atendimentoPesquisa = new Pesquisa(venda, satisfacaoProduto, satisfacaoAtendimento, responsavel, tramite, empresa);
        return atendimentoPesquisa;
    }

    @Override
    public void setVenda(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void carregaVenda() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
