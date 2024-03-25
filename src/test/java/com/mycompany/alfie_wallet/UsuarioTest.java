
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
public class UsuarioTest {

    /**
     * se crea los atributos a utilizar en el test y se instancia Alfie_Wallet
     * (billetera virtual) y Usuario (dentro de Usuario se incluye "wallet" dado
     * que asi fue creado en su Clase
     */
    int id = 11547284;
    String nombre = "Theodoro";
    Alfie_Wallet wallet = new Alfie_Wallet();
    Usuario usuario = new Usuario(id, nombre, wallet);

    public UsuarioTest() {
    }

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
    public void tearDown() {
    }

    /**
     * Test de método constructor, clase Usuario. comparacion entre Id, nombre y
     * Wallet (no null)
     */
    @Test
    public void testConstructor() {

        assertEquals(11547284, usuario.getId());
        assertEquals("Theodoro", usuario.getNombre());
        assertNotNull(usuario.getWallet());

    }

}
