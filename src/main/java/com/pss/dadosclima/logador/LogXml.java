
package com.pss.dadosclima.logador;

import com.pss.dadosclima.model.DadoClima;
import com.pss.enums.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class LogXml implements Log{
    public void log(DadoClima dado, Operacao op){   
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<DadoClima>\n"
            + "    <temperatura>" + dado.getTemperatura() + "</temperatura>\n"
            + "    <pressao>" + dado.getPressao() + "</pressao>\n"
            + "    <umidade>" + dado.getUmidade() + "</umidade>\n"
            + "    <operacao>" + (op == Operacao.INCLUIR ? "incluir" : "excluir") + "</operacao>\n"
            + "</DadoClima>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.xml", true))) {
            writer.write(xml);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
     } 
    public TipoLog GetFormato(){
        return TipoLog.XML;
    }
}
