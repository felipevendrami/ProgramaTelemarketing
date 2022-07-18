/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import DAO.ColaboradorListDAO;
import DAO.EmpresaListDAO;
import Exception.CadastroAtendimentoException;
import Model.Colaborador;
import Model.Empresa;
import Repositorio.ColaboradorRepositorio;
import Repositorio.EmpresaRepositorio;
import View.AtendimentoDivulgacaoView;
import View.AtendimentoPesquisaView;
import View.AtendimentoSuporteView;
import View.CadastroAtendimentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

/**
 *
 * @author felip
 */
public class CadastroAtendimentoController {
    
    //View
    private CadastroAtendimentoView cadastroAtendimento;

    public CadastroAtendimentoController(CadastroAtendimentoView cadastroAtendimento) {
        this.cadastroAtendimento = cadastroAtendimento;
        inicializarBotoes();
        montaListaComboboxEmpresa();
        montaListaComboboxColaborador();
        cadastroAtendimento.limparTela();
    }
    
    public void exibirTelaCadastroAtendimento(){
        cadastroAtendimento.exibirTelaCadastroAtendimento();
    }
    
    public void inicializarBotoes(){
        cadastroAtendimento.adicionarAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    identificaTipoAtendimento();
                } catch (CadastroAtendimentoException ex) {
                    cadastroAtendimento.exibirMensagem(ex.getMessage());
                }
            }
        });
        cadastroAtendimento.adicionarAcaoCancelar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroAtendimento.fecharTela();
            }
        });
    }
    
    public void montaListaComboboxEmpresa(){
        EmpresaRepositorio empresaRepositorio = new EmpresaListDAO();
        Set<Empresa> empresas = empresaRepositorio.recuperarTodasEmpresas();
        for(Empresa empresa : empresas){
            cadastroAtendimento.carregaComboboxEmpresa(empresa);
        }
        //cadastroAtendimento.limparTela();
    }
    
    public void montaListaComboboxColaborador(){
        ColaboradorRepositorio colaboradorRepositorio = new ColaboradorListDAO();
        List<Colaborador> colaboradores = colaboradorRepositorio.recuperarTodosColaboradores();
        for(Colaborador colaborador : colaboradores){
            cadastroAtendimento.carregaComboboxColaborador(colaborador);
        }
    }
    
    /*public void limparTelaCadatroAtendimento(){
        cadastroAtendimento.limparTela();
    }*/
    
    //RECUPERADOS DA VIEW
    
    public void identificaTipoAtendimento() throws CadastroAtendimentoException{
        if(cadastroAtendimento.getEmpresa() == null){
            throw new CadastroAtendimentoException("Empresa não selecionada.");
        } else if(cadastroAtendimento.getResponsavel() == null){
            throw new CadastroAtendimentoException("Responsável não selecionado.");
        } else if(cadastroAtendimento.getTipoAtendimento() == null){
            throw new CadastroAtendimentoException("Tipo de atendimento não selecionado.");
        } else {
            String tipoAtendimento = cadastroAtendimento.getTipoAtendimento();
            abrirTelaTipoAtendimento(tipoAtendimento);
        }
    }
    
    public void abrirTelaTipoAtendimento(String tipoAtendimento){
        if(tipoAtendimento.equals("Divulgação")){
            AtendimentoDivulgacaoController atendimentoDivulgacaoController = new AtendimentoDivulgacaoController(new AtendimentoDivulgacaoView(), cadastroAtendimento);
            atendimentoDivulgacaoController.exibirTelaAtendimentoDivulgacao();
        } if(tipoAtendimento.equals("Suporte")){
            AtendimentoSuporteController atendimentoSuporteController = new AtendimentoSuporteController(new AtendimentoSuporteView(), cadastroAtendimento);
            atendimentoSuporteController.exibirTelaAtendimentoSuporte();
        } if(tipoAtendimento.equals("Pesquisa")){
            AtendimentoPesquisaController atendimentoPesquisaController = new AtendimentoPesquisaController(new AtendimentoPesquisaView(), cadastroAtendimento);
            atendimentoPesquisaController.exibirTelaAtendimentoPesquisa();
        }
    }    
}