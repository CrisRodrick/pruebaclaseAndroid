package com.mycompany.alfie_wallet;
/**
 * librerias import para el programa
 */
import java.util.Scanner;
import java.util.ArrayList;


/**
 * @author Pc Cristian
 * nota: el Main muestra todas las transacciones solicitadas. Se concibe la
 * conversion de moneda solo como una operacion, según lo entendido, 
 * no se suma al saldo
 */
public class Main {

    public static void main(String[] args) {
        // scanner ingreso por consola
        Scanner entrada = new Scanner(System.in);
        
        // Listado de usuarios
        ArrayList< Usuario> usuarios = new ArrayList<Usuario>();

        // instanciar en Alfie_Wallet
        Alfie_Wallet saldo = new Alfie_Wallet();
        Alfie_Wallet deposito = new Alfie_Wallet();
        Alfie_Wallet retiro = new Alfie_Wallet();

        // impresion e ingreso de nombre, rut
        System.out.println("*****************");
        System.out.println("BILLETERA VIRTUAL");
        System.out.println("*****************");

        // validacion de atributo "nombre"
        boolean nombreValido = false;
        String nombre = "";

        while (!nombreValido) {
            try {
                System.out.println("Ingrese nombre: ");
                nombre = entrada.nextLine();
                System.out.println(" ");

                if (nombre.isEmpty()) { // Verificar si la entrada está vacía después de eliminar espacios en blanco
                    throw new Exception("El nombre no puede estar vacio.");
                }
                // Verificar si el nombre contiene solo letras
                if (!nombre.matches("[a-zA-Z- \"]+")) {
                    throw new Exception("El nombre debe contener solo letras.");
                }
                // Verificar longitud mínima de nombre (3 caracteres)
                if (nombre.length() < 3) {
                    throw new Exception("El nombre debe tener al menos 3 caracteres.");
                }
                nombreValido = true; // Si no ocurre ninguna excepcion, marcamos como valido

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        System.out.println("Nombre validado: " + nombre);

        //validacion rut
        boolean idValido = false;
        int id = 0;
        while (!idValido) {
            try {
                System.out.println("Don(a) " + nombre + " Ingrese RUT (c/digito verificador): ");
                String entrada1 = entrada.nextLine(); // Leer la entrada del usuario como String

                if (entrada1.isEmpty()) { // Verificar si la entrada está vacía después de eliminar espacios en blanco
                    throw new Exception("El RUT no puede estar vacío.");
                }
                entrada1 = entrada1.replace(".", "").replace("-", "");//remplaza  puntos y signos menos

                if (entrada1.length() < 7 || entrada1.length() > 9) {//string del rut entre 7 y 9 caracteres
                    throw new Exception("El RUT debe tener de 7 o 9 digitos.");
                }

                if (!entrada1.matches("[0-9]+|K")) { // como es String acepta "K"
                    throw new Exception("El RUT debe tener un formato valido (digitos o K mayuscula).");
                }
                id = Integer.parseInt(entrada1); // Convertir string o entrada a un entero

                idValido = true; // Si no ocurre ninguna excepción, marcamos como válido
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar numeros validos para el RUT.");
                entrada.next(); // Limpiar el buffer del scanner (limpia de puntos y guiones)
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Rut validado: " + id);
        Usuario usuario1 = new Usuario(id, nombre, new Alfie_Wallet());
        usuarios.add(usuario1);
        usuario1.getWallet().obtenerSaldo();

        
        // Menu
        int opcion;
        do {
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println(" ¡BIENVENIDO(A)! DON(A) " + nombre);
            System.out.println(" INGRESE UNA OPCIÓN ");
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println(" 0: opción SALIR");
            System.out.println(" 1: opción CONSULTAR SALDO");
            System.out.println(" 2: opción DEPOSITAR");
            System.out.println(" 3: opción RETIRAR");
            System.out.println(" 4: opción CONVERTIR MONEDA (EUR/USD)");
            System.out.println(" 5: opción OBTENER TRANSACCIONES");
            System.out.println("************************************");
            System.out.println("************************************");

            opcion = entrada.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Cerrando Menu");
                    break;

                case 1:  //String.format + cod = cifras transformadas visualmente en String
                    System.out.println("Saldo actual: $" + String.format("%.0f", usuario1.getWallet().obtenerSaldo()));
                    
                    break;

                case 2:
                    System.out.println("Ingrese el monto a depositar");
                    double montoD = entrada.nextDouble();

                    System.out.println("Monto depositado: " + montoD);
                    usuario1.getWallet().depositar(montoD);
                    System.out.println("Su nuevo saldo es: " + usuario1.getWallet().obtenerSaldo());

                    break;

                case 3:
                    System.out.println("Ingrese el monto a retirar");
                    double cantidad = entrada.nextDouble();

                    if (cantidad > 0) {
                        if (usuario1.getWallet().obtenerSaldo() >= cantidad) {
                            usuario1.getWallet().retirar(cantidad);
                            System.out.println("Monto retirado: " + cantidad);
                            System.out.println("Su nuevo saldo es: " + usuario1.getWallet().obtenerSaldo());
                        } else {
                            System.out.println("No se pudo realizar el retiro. Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Se debe retirar un monto mayor a cero");
                    }

                    break;
                case 4:
                    System.out.println(" Ingrese pesos (clp) a convertir: ");
                    double pesosChilenos = entrada.nextDouble();
                    System.out.println(" 1= USD , 2=EUR ");
                    int aMoneda = entrada.nextInt();
                    usuario1.getWallet().convertirMoneda(aMoneda, pesosChilenos);

                    break;

                case 5:
                    System.out.println("IMPRIMIR CARTOLA");
                    usuario1.getWallet().obtenerTransacciones();
                    break;

                default:
                    System.out.println("Opcion no existe");

            }
        } while (opcion != 0);

        entrada.close();
    }
}
