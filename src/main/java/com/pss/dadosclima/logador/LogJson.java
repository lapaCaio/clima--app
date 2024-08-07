
package com.pss.dadosclima.logador;

import com.pss.enums.*;
import com.pss.dadosclima.model.DadoClima;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class LogJson implements Log{
    public void log(DadoClima dado, Operacao op){
         String json = "{"
            + "\"temperatura\": " + dado.getTemperatura() + ", "
            + "\"pressao\": " + dado.getPressao() + ", "
            + "\"umidade\": " + dado.getUmidade() + ", "
            + "\"operacao\": \"" + (op == Operacao.INCLUIR ? "incluir" : "excluir") + "\""
            + "}";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.json", true))) {
            writer.write(json);
            writer.newLine();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public TipoLog GetFormato(){
        return TipoLog.JSON;
    }
}
