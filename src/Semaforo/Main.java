package Semaforo;

import java.util.Scanner;

/**
 * Created by sergi on 15/12/15.
 */
public class Main {


    public static void main(String[] args) {

        Scanner teclat = new Scanner(System.in);    // teclado

        System.out.println("Introduce el numero de plazas:");
            int plazas = teclat.nextInt();  // Pedimos el numero de plazas del parking
        System.out.println("Introduce el numero de coches:");
            int coches = teclat.nextInt();  // y el numero de coches que hay circulando

        teclat.close();     // Cerramos el teclado

        Parking parking = new Parking();    // Creamos nuestro objeto parking
        parking.setNumeroPlazas(plazas);    // Introducimos el numero de plazas al parking
        parking.setNumeroCoches(coches);    // Tambien el numero de coches
        parking.crearSemaforo();            // Creamos el semaforo con el numero de plazas correspondiente
        parking.on();                       // Arrancamos el parking

    }
}
