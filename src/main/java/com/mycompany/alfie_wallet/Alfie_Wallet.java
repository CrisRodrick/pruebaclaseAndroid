
package com.mycompany.alfie_wallet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc Cristian
 */
public class Alfie_Wallet implements Wallet{
   
    /**
     * Clase Alfie_Wallet (Billetera) implementada por Wallet (Interface).
     * 
     * Atributos
     */
   
    private double saldo;
    private List<String> transacciones; //historial de transacciones
   

    public Alfie_Wallet() {
        this.saldo = 0.0;
        this.transacciones = new ArrayList <>();
    }
    //Métodos (@override desde interface Wallet.java)
    
    @Override //método Obtener Saldo
    public double obtenerSaldo() {
        transacciones.add("Deposito: " + saldo);
    return saldo;
    }

    @Override //método Depositar
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
            transacciones.add("Deposito: " + cantidad);
            String saldoR = String.format("%.0f", this.saldo);
            System.out.println("Deposito correcto su nuevo saldo es :  $" + saldoR);
        }
        else {
            System.out.println("Error la cantidad debe ser mayor a 0");
    }
    }

    @Override //método Retirar
    public void retirar(double cantidad) {

        if (cantidad > 0 && this.saldo >= cantidad) {
            saldo -= cantidad;
            transacciones.add("Retiro: " + cantidad);
            String saldoR = String.format("%.0f", this.saldo);
            System.out.println("Retiro exitoso su nuevo saldo es: $" + saldoR);
            
        }
        else {
            System.out.println(" Error: saldo insuficiente o cantidad inválida ");
        }
    }

    @Override //método de Conversión de Moneda
    public void convertirMoneda(int aMoneda, Double pesosChilenos) {
        // Define la tasa de cambio de USD o Euro  a CLP (pesos chilenos)
        double tasaCambioUsd = 968;  // // Tasa de cambio: 1 Dólar = 968 pesos chilenos
        double tasaCambioEu = 1051.89; // // Tasa de cambio: 1 Euro = 1052 pesos chilenos
        // Verifica si la conversión es de USD o  EU  a CLP
        if (aMoneda ==1) {
            // Realiza la conversión a USD
            double dolares  = pesosChilenos / tasaCambioUsd;
            transacciones.add("Conversión a dolar: $ " + dolares);
            System.out.println("La cantidad convertida a dolares es: $" + dolares);
        } else if (aMoneda ==2) {
            // Realiza la conversión a EU
            double euros = pesosChilenos/ tasaCambioEu;
            transacciones.add("Conversión a euro: € " + euros);
            System.out.println("La cantidad convertida a euros es €" + euros  );
        } else {
            // Conversión no soportada
            System.out.println("Conversion no soportada.");
        }
    }
    @Override //método Obtener Transacciones
     public void obtenerTransacciones(){
        transacciones.forEach(transaccion->System.out.println(transaccion));
    }

    

}
        
        
    
    
   
    

    

   
    
    

