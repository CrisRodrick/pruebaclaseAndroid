
package com.mycompany.alfie_wallet;

/**
 * @author Pc Cristian
 *
 */
public interface Wallet {

    /**
     * Interface Implementa metodos de clase Alfie_Wallet
     */

    //Obtener saldo
    double obtenerSaldo();

    //Obtener saldo
    void depositar(double cantidad);

    //retirar saldo
    void retirar(double cantidad);

    //conversión de monedas
    void convertirMoneda(int aMoneda, Double pesosChilenos);

    //mostrar transacciones
    void obtenerTransacciones();

}
