/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.service;

import com.pss.dadosclima.logador.Log;
import com.pss.dadosclima.logador.LogJson;
import com.pss.dadosclima.logador.LogXml;
import com.pss.dadosclima.model.DadoClima;
import com.pss.enums.*;


/**
 *
 * @author Sylvio
 */
public class LogService {
    private Log logador;

    public LogService() {
        this.setFormatoLog(TipoLog.JSON);
    }

    public void setFormatoLog(TipoLog tipo) {
        switch(tipo) {
                case JSON :
                    logador= new LogJson();
                    break;
                case XML :
                    logador = new LogXml();
                    break;
    }
    }
    public TipoLog getFormatoLog(){
        if (logador!=null)
            return logador.GetFormato();
        else return null;
    }
    public void handle(DadoClima dado , Operacao op){
        logador.log(dado, op);
    }
}
