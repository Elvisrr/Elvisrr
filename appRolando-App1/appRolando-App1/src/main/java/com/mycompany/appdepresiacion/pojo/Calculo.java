/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appdepresiacion.pojo;

/**
 *
 * @author rolando
 */
public class Calculo {
    public double calcularDepreciacion(double valorActivo,double valorSAlvamento,double años){
        return ((double)((valorActivo-valorSAlvamento)/años));
    }
}
