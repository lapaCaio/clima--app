package com.pss.dadosclima.presenter;

import enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.Panels.*;
import com.pss.dadosclima.view.PrincipalView;
import java.util.ArrayList;

import com.pss.service.LogService;

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
    
    public void addMedicao(float temperatura, float pressao, float umidade) {
        DadoClima dado = new DadoClima(temperatura, pressao, umidade);
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
    
//    private void log(DadoClima dado, Operacao op) {
//    String formato = getSavedLogFormat(); // Obtém o formato salvo
//
//    if (formato.equals("json")) {
//        logToJSON(dado, op);
//    } else if (formato.equals("xml")) {
//        logToXML(dado, op);
//    } else {
//        System.out.println("Formato desconhecido: " + formato);
//    }
//}


//    private void logToJSON(DadoClima dado, Operacao op) {
//    String json = "{"
//            + "\"temperatura\": " + dado.getTemperatura() + ", "
//            + "\"pressao\": " + dado.getPressao() + ", "
//            + "\"umidade\": " + dado.getUmidade() + ", "
//            + "\"operacao\": \"" + (op == Operacao.INCLUIR ? "incluir" : "excluir") + "\""
//            + "}";
//
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.json", true))) {
//        writer.write(json);
//        writer.newLine();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//private void logToXML(DadoClima dado, Operacao op) {
//    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
//            + "<DadoClima>\n"
//            + "    <temperatura>" + dado.getTemperatura() + "</temperatura>\n"
//            + "    <pressao>" + dado.getPressao() + "</pressao>\n"
//            + "    <umidade>" + dado.getUmidade() + "</umidade>\n"
//            + "    <operacao>" + (op == Operacao.INCLUIR ? "incluir" : "excluir") + "</operacao>\n"
//            + "</DadoClima>";
//
//    try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.xml", true))) {
//        writer.write(xml);
//        writer.newLine();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
//
//
//   private String getSavedLogFormat() {
//    String format = "json"; // Default format
//    try (BufferedReader reader = new BufferedReader(new FileReader("configuracao_log.txt"))) {
//        format = reader.readLine().trim().toLowerCase();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    return format;
//}

}
