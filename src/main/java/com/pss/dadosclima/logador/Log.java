/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pss.dadosclima.logador;

import com.pss.enums.*;
import com.pss.dadosclima.model.DadoClima;


/**
 *
 * @author Sylvio
 */
public interface Log {
    public void log(DadoClima dado, Operacao op);
    public TipoLog GetFormato();
   
}
