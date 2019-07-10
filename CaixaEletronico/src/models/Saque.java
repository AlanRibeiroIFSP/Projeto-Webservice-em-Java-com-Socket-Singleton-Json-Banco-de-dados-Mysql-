/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * @author Otavio & Alan
 */
public class Saque {
    int id_saque; 
    float valor; 
    int id_conta1; 

    public Saque() {
    }

    public int getId_saque() {
        return id_saque;
    }

    public void setId_saque(int id_saque) {
        this.id_saque = id_saque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId_conta1() {
        return id_conta1;
    }

    public void setId_conta1(int id_conta1) {
        this.id_conta1 = id_conta1;
    }
    
    
}
