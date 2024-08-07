package com.pss.dadosclima.presenter;

import com.pss.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.Panels.*;
import com.pss.dadosclima.view.PrincipalView;
import java.util.ArrayList;

import com.pss.service.LogService;
import java.time.LocalDate;

public class PrincipalPresenter {
    private PrincipalView view;
    private ArrayList<Painel> paineis = new ArrayList<>();
    private int numregistros = 0;
    private LogService log;
    

    public PrincipalPresenter() {
        log= new LogService();
        view = new PrincipalView(this.log);
        view.getDesktopPane().add(new IncluirPresenter(this).getFrame());
        RegistarPainel(new MediaPresenter());
        RegistarPainel(new UltimoPresenter());
        RegistarPainel(new RegistrosPresenter(this));
        RegistarPainel(new GraficoPresenter());
        paineis.forEach((n) -> view.getDesktopPane().add(n.getFrame()));
        view.repaint();
    }

 
    
    public void RegistarPainel(Painel painel) {
        paineis.add(painel);
    }
    
    public void addMedicao(LocalDate data,float temperatura, float pressao, float umidade) {
        DadoClima dado = new DadoClima(data,temperatura, pressao, umidade);
        notificarPaineis(dado, Operacao.INCLUIR);
        log.handle(dado, Operacao.INCLUIR);
    }
    
    public void remMedicao(DadoClima dado) {
        notificarPaineis(dado, Operacao.EXCLUIR);
        log.handle(dado, Operacao.EXCLUIR);
    }
    
    private void notificarPaineis(DadoClima dado, Operacao op) {
        paineis.forEach((n) -> n.atualizar(dado, op));
        switch(op) {
            case INCLUIR:
                numregistros++;
                break;
            case EXCLUIR:
                numregistros--;
                break;
        }    
        view.getQuantidadeLabel().setText(String.valueOf(numregistros));
    }
    

}
