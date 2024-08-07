package com.pss.dadosclima.presenter;

import com.pss.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.Panels.*;
import com.pss.dadosclima.view.PrincipalView;
import java.util.ArrayList;

import com.pss.service.LogService;
import java.time.LocalDate;

public final class PrincipalPresenter {
    private final PrincipalView view;
    private ArrayList<Painel> paineis = new ArrayList<>();
    private int numregistros = 0;
    private final LogService log;
    static int x = 1;
    

    public PrincipalPresenter() {
        log= new LogService();
        view = new PrincipalView(this.log);
        view.getDesktopPane().add(new IncluirPresenter(this).getFrame());
        (view.getDesktopPane().getAllFrames())[0].setLocation(0, 150);
        RegistarPainel(new MediaPresenter());
        RegistarPainel(new UltimoPresenter());
        RegistarPainel(new RegistrosPresenter(this));
        RegistarPainel(new GraficoPresenter());
        
        view.repaint();
        System.out.println((view.getDesktopPane().getAllFrames())[2].getLocation());
        (view.getDesktopPane().getAllFrames())[4].setLocation(281, 380);
    }
        
 
    
    public void RegistarPainel(Painel painel) {  
        paineis.add(painel);
        painel.getFrame().setLocation(x,1);
        view.getDesktopPane().add(painel.getFrame());
        x+=painel.getFrame().getWidth();
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
