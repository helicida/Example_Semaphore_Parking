package Semaforo;

import java.util.Random;

/**
 * Created by sergi on 15/12/15.
 */
public class Coche extends Thread{

    private int matricula;  // Matricula del coche, numero identificador unico de cada coche

    public Coche(int matricula){
        this.matricula = matricula; // En el constructor es necesario dar la matricula como parámetro
    }

    @Override
    public void run(){

        Random random = new Random();   // Hacemos un random para calcular los tiempos de espera

        while(true){
            try {
                Thread.sleep(random.nextInt(1000));     // Generamos de manera aleatoria el tiempo que estará el coche dando vueltas antes de entrar al parking
                Parking.semaforo.acquire();                  // Lo ingresamos con el semaforo
                Parking.cochesParking = Parking.getCochesParking() + 1;     // Llevamos la cuenta de coches que tenemos dentro
                System.out.println(" + | El coche numero " + matricula + " ha entrado al parking       ->      " + Parking.getCochesParking() + "/" + Parking.getNumeroPlazas());
                Thread.sleep(random.nextInt(100));      // Generamos aleatoriamente el tiempo que el coche esta aparcado
                Parking.semaforo.release();                  // El coche sale del parking
                Parking.cochesParking = Parking.getCochesParking() - 1; // Llevamos la cuenta de coches que tenemos dentro
                System.out.println(" - | El coche " + matricula + " ha salido del parking              ->      " + Parking.getCochesParking() + "/" + Parking.getNumeroPlazas());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
