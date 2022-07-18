/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exception.AtendimentoTramiteException;
import Model.Atendimento;
import Model.Divulgacao;
import Model.IAtendimentoDivulgacao;
import Model.Venda;
import View.CadastroTramiteView;
import View.CadastroVendaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felip
 */
public class CadastroTramiteController implements IAtendimentoDivulgacao{
    
    //View
    private CadastroTramiteView cadastroTramite;
    
    //Atendimento
    private Atendimento atendimento;

    public CadastroTramiteController(CadastroTramiteView cadastroTramite, Atendimento atendimento) {
        this.cadastroTramite = cadastroTramite;
        this.atendimento = atendimento;
        inicializarBotoes();
    }
    
    public void exibirTelaCadastroTramite(){
        cadastroTramite.exibirTelaCadastroTramite();
    }
    
    public void inicializarBotoes(){
        cadastroTramite.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroTramite.fecharTela();
            }
        });
        cadastroTramite.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    processoAtendimento();
                } catch (AtendimentoTramiteException ex) {
                    cadastroTramite.exibirMensagem(ex.getMessage());
                }
            }
        });
        cadastroTramite.adicionarAcaoNovaVenda(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaExcecao();
                    existeVenda();
                    exibirTelaCadastroVenda();
                } catch (AtendimentoTramiteException ex) {
                    cadastroTramite.exibirMensagem(ex.getMessage());
                }
            }
        });
    }
    
    //RECUPERADOS VIEW
    
    public void identificaExcecao() throws AtendimentoTramiteException{
        if(cadastroTramite.getTipoTramite() == null){
            throw new AtendimentoTramiteException("Tipo do Trâmite não selecionado.");
        } else if(cadastroTramite.getTramite().isBlank()){
            throw new AtendimentoTramiteException("Campo 'Trâmite' não pode ficar vazio.");
        }
    }

    public void incluirTramite(){
        // Recuperamos as informações da tela
        String tipoTramite = cadastroTramite.getTipoTramite();
        String descicaoTramite = cadastroTramite.getTramite();
        
        // Criamos o trâmite
        atendimento.criarTramite(descicaoTramite, tipoTramite);
        cadastroTramite.exibirMensagem("Trâmite realizado com sucesso !");
    }
    
    public void existeVenda()throws AtendimentoTramiteException{
        Divulgacao divulgacao = (Divulgacao) atendimento;
        if(divulgacao.existeVenda()){
            throw new AtendimentoTramiteException("O atendimento já possui uma venda.");
        }
    }
    
    public void exibirTelaCadastroVenda(){
        CadastroVendaController cadastroVendaController = new CadastroVendaController(new CadastroVendaView());
        cadastroVendaController.exibirTelaCadastroVenda();
    }
    
    @Override
    public void setConversaoDivulgacao(String situacaoVenda) {
        Divulgacao divulgacao = (Divulgacao) this.atendimento;
        if(situacaoVenda.equals("Pendente")){
            divulgacao.setConversao(false);
        } else {
            divulgacao.setConversao(true);
        }
    }

    @Override
    public void processoAtendimento() {
        incluirTramite();
        cadastroTramite.limparTela();
        cadastroTramite.fecharTela();
    }

    @Override
    public void setVenda(Venda venda) {
        Divulgacao divulgacao = (Divulgacao) this.atendimento;
        divulgacao.setVenda(venda);
    }
    
    
}
