
package com.pss.dadosclima.presenter.Panels;

import com.pss.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import javax.swing.JInternalFrame;


public interface Painel {
    public void atualizar(DadoClima clima, Operacao op );
    public JInternalFrame getFrame();
}
