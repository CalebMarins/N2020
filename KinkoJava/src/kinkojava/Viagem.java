/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinkojava;

import java.util.Date;

/**
 *
 * @author FACTORIUM
 */
public class Viagem {
    //Validando se foi entregue
    boolean entregue = false;
    
    int totalEntregas;

    public void setTotalEntregas(int totalEntregas) {
        this.totalEntregas = totalEntregas;
    }

    public int getTotalEntregas() {
        return totalEntregas;
    }
    
}
