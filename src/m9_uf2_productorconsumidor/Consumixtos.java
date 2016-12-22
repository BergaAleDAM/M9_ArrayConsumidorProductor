package m9_uf2_productorconsumidor;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cada consumixtos tendra un constructor por el que se le pasa la cuenta principal
 * y una id consumidor que será basicamente el numero de hilo, aunque no se reflejará
 * y no se porque lo estoy dejando. 
 * Implementa el metodo runnable que se explica mas abajito
 * 
 * @author ALUMNEDAM
 */
public class Consumixtos implements Runnable {

    private Cuenta cuenta;
    private final int idconsumidor;

    Consumixtos(Cuenta cuenta, int idconsumidor) {
        this.cuenta = cuenta;
        this.idconsumidor = idconsumidor;
    }

    /**
     * Aqui en el metodo runnable pues declaramos un numero al azar para pasarlo
     * a la cuenta con  un try catch que lo rodea
     */
    @Override
    public void run() {

        while (true) {

            int random = (int) (Math.random() * 100);
            try {
                cuenta.sacar(random, idconsumidor);
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumixtos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
