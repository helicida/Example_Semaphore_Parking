package Semaforo;

import java.util.concurrent.Semaphore;

/**
 * Created by sergi on 15/12/15.
 */
public class Parking {

    public static int cochesParking = 0;    // Numero de coches dentro del parking
    private static int numeroPlazas = 0;    // Numero de plazas del parking
    private static int numeroCoches = 0;    // Numero de coches circulando
    public static Semaphore semaforo;       // Objero semaforo

    public Parking(){
    }

    public void on(){

        for(int iterador = 0; iterador < numeroCoches; iterador++){
            if(iterador < numeroCoches){
                Coche cotxe = new Coche(iterador);  // Creamos el objeto coche con la matricula correspondiente
                cotxe.start();  // Comenzamos tantos hilos de coches como los que introduce el usuario
            }
        }
    }

    // Getters

    public static int getNumeroPlazas() {
        return numeroPlazas;
    }

    public static int getCochesParking(){
        return cochesParking;
    }

    // Setters

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public void setNumeroCoches(int numeroCoches){
        this.numeroCoches = numeroCoches;
    }

    public void crearSemaforo() {
        this.semaforo = new Semaphore(this.getNumeroPlazas());
    }

}
