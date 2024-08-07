
package com.pss.dadosclima.presenter;

import com.pss.dadosclima.view.IncluirFrame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class IncluirPresenter {
    private IncluirFrame view;
    
    
    public IncluirPresenter(PrincipalPresenter presenter) {
        
        view=new IncluirFrame();
        view.setVisible(true);
        
        view.getIncluirButton().addActionListener(new ActionListener() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component x: view.getContentPane().getComponents()) {
                        if (x instanceof JTextField jTextField) {
                           if(jTextField.getText().isEmpty() || jTextField.getText().isBlank() ){
                               jTextField.setText("1");
                           } 
                        }
                }
                try{
                System.out.println(Float.parseFloat(view.getTemperaturaField().getText()));
                System.out.println(LocalDate.parse(view.getDataField().getText(),formatter));
                System.out.println(Float.parseFloat(view.getUmidadeField().getText()));
                System.out.println(Float.parseFloat(view.getPressaoField().getText()));
                presenter.addMedicao(LocalDate.parse(view.getDataField().getText(),formatter),Float.parseFloat(view.getTemperaturaField().getText()), Float.parseFloat(view.getPressaoField().getText()), Float.parseFloat(view.getUmidadeField().getText()));
                }
               catch (DateTimeParseException ex) {
                    // Trata o erro de conversão da data
                    JOptionPane.showMessageDialog(view, "Data inválida.", "Erro de Data", JOptionPane.ERROR_MESSAGE);
                    view.getDataField().setText(LocalDate.now().format(formatter));
                    System.err.println("Erro de formatação da data: " + ex.getMessage());
                } catch (Exception ex) {
                    // Trata quaisquer outros erros
                    JOptionPane.showMessageDialog(view, "Ocorreu um erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Erro inesperado: " + ex.getMessage());
                }
                }
        });
    }
    
    
     public JInternalFrame getFrame(){
        return view;
    }
}
