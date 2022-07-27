/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AtendimentoDivulgacaoListDAO;
import DAO.AtendimentoListDAO;
import DAO.TramiteListDAO;
import Exception.CadastroAtendimentoException;
import Model.Atendimento;
import Model.Colaborador;
import Model.Divulgacao;
import Model.Empresa;
import Model.IAtendimentoDivulgacao;
import Model.Tramite;
import Model.Venda;
import Repositorio.AtendimentoRepositorio;
import View.AtendimentoDivulgacaoView;
import View.CadastroAtendimentoView;
import View.CadastroVendaView;
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
    
    //Venda
    private Venda venda;
    private boolean conversaoVenda;

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
                try {
                    identificaExcecao();
                    exibirTelaNovaVenda();
                } catch (CadastroAtendimentoException ex) {
                    atendimentoDivulgacao.exibirMensagem(ex.getMessage());
                }
            }
        });
    }
    
    public void exibirTelaNovaVenda(){
        CadastroVendaController cadastroVendaController = new CadastroVendaController(new CadastroVendaView());
        cadastroVendaController.exibirTelaCadastroVenda();
    }
    
    public void abrirAtendimentoDivulgacaoBD(){
        Divulgacao atDivulgacao = recuperarAtendimentoDivulgacaoBD();
        Atendimento atendimento = (Atendimento) atDivulgacao;
        if(AtendimentoListDAO.salvarAtendimentoBD(atendimento) && AtendimentoDivulgacaoListDAO.salvarAtendimentoDivulgacaoBD(atDivulgacao)){
            gravarTramiteBD(atendimento.getIdAtendimento());
            atendimentoDivulgacao.exibirMensagem("Atendimento e trâmite gravado no banco de dados !");
        } else {
            atendimentoDivulgacao.exibirMensagem("Não foi possível gravar o atendimento no banco de dados !");
        }
    }
    
    public Divulgacao recuperarAtendimentoDivulgacaoBD(){
        // Recuperamos as informações da tela
        Empresa empresa = cadastroAtendimento.getEmpresa();
        Colaborador responsavel = cadastroAtendimento.getResponsavel();
        String tipoContato = atendimentoDivulgacao.getTipoContato();
        String contato = atendimentoDivulgacao.getContato();
        String tramite = atendimentoDivulgacao.getTramite();
        
        // Criamos o atendimento e retornamos
        Divulgacao atendimentoDivulgacao = new Divulgacao(tipoContato, contato, responsavel, tramite, empresa, false, null);
        return atendimentoDivulgacao;
    }
    
    public void gravarTramiteBD(int idAtendimento){
        String textoTramite = atendimentoDivulgacao.getTramite();
        Tramite tramiteAbertura = new Tramite(textoTramite, "Abertura");
        TramiteListDAO.salvarTramite(tramiteAbertura, idAtendimento);
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
        abrirAtendimentoDivulgacaoBD();
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
        if(situacaoVenda.equals("Pendente")){
            this.conversaoVenda = false;
        } else {
            this.conversaoVenda = true;
        }
    }

    @Override
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
