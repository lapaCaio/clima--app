/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.model;

import java.time.LocalDate;

/**
 *
 * @author UFES
 */
public class DadoClima {
    private float temperatura;
    private float pressao;
    private float umidade;
    private LocalDate data;

    public DadoClima(float temperatura, float pressao, float umidade) {
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.umidade = umidade;
        this.data = LocalDate.now();
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
