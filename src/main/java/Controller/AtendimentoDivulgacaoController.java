/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AtendimentoListDAO;
import Exception.CadastroAtendimentoException;
import Model.Atendimento;
import Model.Colaborador;
import Model.Divulgacao;
import Model.Empresa;
import Model.IAtendimentoDivulgacao;
import Model.Venda;
import Repositorio.AtendimentoRepositorio;
import View.AtendimentoDivulgacaoView;
import View.CadastroAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felip
 */
public class AtendimentoDivulgacaoController implements IAtendimentoDivulgacao{
    
    //View
    private AtendimentoDivulgacaoView atendimentoDivulgacao;
    private CadastroAtendimentoView cadastroAtendimento;
    
    //Controller CadastroAtendimento
    //private CadastroAtendimentoController cadastroAtendimento;

    public AtendimentoDivulgacaoController(AtendimentoDivulgacaoView atedimentoDivulgacao, CadastroAtendimentoView cadastroAtendimento) {
        this.atendimentoDivulgacao = atedimentoDivulgacao;
        this.cadastroAtendimento = cadastroAtendimento;
        inicializarBotoes();
    }
    
    public void exibirTelaAtendimentoDivulgacao(){
        atendimentoDivulgacao.exibirTelaAtendimentoDivulgacao();
    }
    
    public void inicializarBotoes(){
        atendimentoDivulgacao.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atendimentoDivulgacao.fecharTela();
            }
        });
        atendimentoDivulgacao.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    processoAtendimento();
                } catch (CadastroAtendimentoException ex) {
                    atendimentoDivulgacao.exibirMensagem(ex.getMessage());
                }
            }
        });
        atendimentoDivulgacao.adicionarAcaoNovaVenda(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    //RECUPERADOS DA VIEW
    
    public void identificaExcecao() throws CadastroAtendimentoException{
        if(atendimentoDivulgacao.getTipoContato() == null){
            throw new CadastroAtendimentoException("Tipo de Contato não selecionado.");
        } else if (atendimentoDivulgacao.getContato().isBlank()){
            throw new CadastroAtendimentoException("Campo 'Contato' não informado.");
        } else if (atendimentoDivulgacao.getTramite().isBlank()){
            throw new CadastroAtendimentoException("Campo 'Trâmite' não pode ficar vazio.");
        }
    }
    
    @Override
    public void processoAtendimento(){
        abrirAtendimentoDivulgacao();
        cadastroAtendimento.limparTela();
        atendimentoDivulgacao.fecharTela();
    }
    
    public void abrirAtendimentoDivulgacao(){
        AtendimentoRepositorio atendimentoRepositorio = new AtendimentoListDAO();
        Atendimento atendimento = recuperarAtendimentoDivulgacao();
        atendimentoRepositorio.salvarAtendimento(atendimento);
        atendimentoDivulgacao.exibirMensagem("Atendimento aberto com sucesso !");
    }
    
    public Atendimento recuperarAtendimentoDivulgacao(){
        // Recuperamos as informações da tela
        Empresa empresa = cadastroAtendimento.getEmpresa();
        Colaborador responsavel = cadastroAtendimento.getResponsavel();
        String tipoContato = atendimentoDivulgacao.getTipoContato();
        String contato = atendimentoDivulgacao.getContato();
        String tramite = atendimentoDivulgacao.getTramite();
        
        // Criamos o atendimento e retornamos
        Atendimento atendimentoDivulgacao = new Divulgacao(tipoContato, contato, responsavel, tramite, empresa, false, null);
        return atendimentoDivulgacao;
    }

    @Override
    public void setConversaoDivulgacao(String situacaoVenda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setVenda(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
