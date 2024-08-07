
package com.pss.dadosclima.presenter.Panels;

import com.pss.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.PrincipalPresenter;
import com.pss.dadosclima.view.RegistrosFrame;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UFES
 */
public class RegistrosPresenter implements Painel{
    private RegistrosFrame view;
    private ArrayList<DadoClima> dados =new ArrayList<>();

    public RegistrosPresenter(PrincipalPresenter presenter) {
        view=new RegistrosFrame();

        view.setPosition(800,350);
        
        view.setVisible(true);
        
        view.getRemoverButton().addActionListener((ActionEvent e)->{
            if(view.getjTable1().getSelectedRow() !=-1)
            presenter.remMedicao(dados.get(view.getjTable1().getSelectedRow()));
        });
    }
    public void atualizar(DadoClima dado, Operacao op){
        switch(op){
            case INCLUIR:
                dados.add(dado);
                break;
            case EXCLUIR:
                dados.remove(dado);
                break;
        }
        AlimentaTabela();
        
    }
    
    public void AlimentaTabela(){
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DefaultTableModel model = new DefaultTableModel((new String[]{"data","temperatura","umidade","pressão"}), 0);
        for(DadoClima x : dados ){
            model.addRow(new Object[]{(x.getData().format(formatter)),(x.getTemperatura()),(x.getUmidade()),(x.getPressao())});
        }
        
        
        view.getjTable1().setModel(model);
        view.getjTable1().setRowSelectionAllowed(true);
    
        view.repaint();
    }
    
     public JInternalFrame getFrame(){
        return view;
        
    }
    
}
