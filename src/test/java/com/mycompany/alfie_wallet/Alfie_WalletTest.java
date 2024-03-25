package com.mycompany.alfie_wallet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pc Cristian
 */
public class Alfie_WalletTest {
/**
 * Se crean valores fijos para los atributos id y nombre.
 * Se instancia Alfie_Wallet
 */
  
    int id = 1;
    String nombre = "Bruno" ;       
    Alfie_Wallet wallet = new Alfie_Wallet ();
    
    

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        
    }

    @AfterEach
    public void teaDown() {
    }

    /**
     * Test para el metodo Depositar de clase Alfie_Wallet.
     * El test compara valores de deposito normal y limite (negativo y cero con
     * el valor del saldo
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar");
        Usuario usuario = new Usuario (id,nombre,wallet);
        // realizar un depósito válido
        usuario.getWallet().depositar(250.0);
        assertEquals(250.0, usuario.getWallet().obtenerSaldo(), 0);

        // deposito negativo
        usuario.getWallet().depositar(-250.0);
        assertEquals(250.0, usuario.getWallet().obtenerSaldo(), 0);

        // deposito cero
        usuario.getWallet().depositar(0.0);
        assertEquals(250.0, usuario.getWallet().obtenerSaldo(), 0);
    }

    /**
     * Test del método Retirar de la clase Alfie_Wallet.
     * El test compara, luego de depositar una cantidad, entre valores de 
     * retiro de divisas y el saldo.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        Usuario usuario2 = new Usuario(1, "Juan",wallet);
        usuario2.getWallet().depositar(1000.0);

        // realizar un retiro 
        usuario2.getWallet().retirar(500.0);
        assertEquals(500.0, usuario2.getWallet().obtenerSaldo(), 0);

        // intentar un retiro negativo
        usuario2.getWallet().retirar(-100.0);
        assertEquals(500.0, usuario2.getWallet().obtenerSaldo(), 0);

        // retiro cero
        usuario2.getWallet().retirar(0.0);
        assertEquals(500.0, usuario2.getWallet().obtenerSaldo(), 0);
    }

}
