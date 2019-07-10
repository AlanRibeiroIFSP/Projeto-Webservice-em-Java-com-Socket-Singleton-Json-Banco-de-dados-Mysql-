/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * @author Otavio & Alan
 */
public class Deposito {
    int id_deposito; 
    float valor; 
    int id_conta1; 

    public Deposito() {
    }

    public int getId_deposito() {
        return id_deposito;
    }

    public void setId_deposito(int id_deposito) {
        this.id_deposito = id_deposito;
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
