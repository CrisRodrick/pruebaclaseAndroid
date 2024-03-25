
package com.mycompany.alfie_wallet;

/**
 * 
 * @author Pc Cristian
 */
public class Usuario {
/**
 * Clase usuario (cliente) 
 */    
    // atributos
    private int id;
    private String nombre;
    private Alfie_Wallet wallet; //composicion
    
    // constructor vacio, pero luego llenado por un @Test
    public Usuario(int par, String bruno) { 
    }

    //constructor del metodo (composición)
    public Usuario(int id, String nombre, Alfie_Wallet wallet) { 
        this.id = id;
        this.nombre = nombre;
        this.wallet = new Alfie_Wallet (); //intanciando la billetera Alfie_Wallet
    }
    
    //geter para obtener Id (rut) de cliente
    public int getId() {
        return id;
    }
    //seter para establecer id (rut) de cliente
    public void setId(int id) {
        this.id = id;
    }
    //geter para obtener nombre de cliente
    public String getNombre() {
        return nombre;
    }
    // Seter para establecer nombre de cliente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Geter para obtener la wallet asociada al cliente
    public Alfie_Wallet getWallet() {
        return wallet;
    }
    // Seter para establecer la billetera asociada al cliente
    public void setWallet(Alfie_Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", wallet=" + wallet + '}';
    }
    
    
    
}
