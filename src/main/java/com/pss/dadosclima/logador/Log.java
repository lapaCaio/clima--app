
package com.pss.dadosclima.logador;

import com.pss.enums.*;
import com.pss.dadosclima.model.DadoClima;



public interface Log {
    public void log(DadoClima dado, Operacao op);
    public TipoLog GetFormato();
   
}
