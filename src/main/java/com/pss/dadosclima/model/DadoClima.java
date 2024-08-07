
package com.pss.dadosclima.model;

import java.time.LocalDate;

public class DadoClima {
    private float temperatura;
    private float pressao;
    private float umidade;
    private LocalDate data;

    public DadoClima(LocalDate data,float temperatura, float pressao, float umidade) {
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.umidade = umidade;
        this.data = data;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getPressao() {
        return pressao;
    }

    public float getUmidade() {
        return umidade;
    }

    public LocalDate getData() {
        return data;
    }
    
    
    
}
