package m9_uf2_productorconsumidor;



import java.util.logging.Level;
import java.util.logging.Logger;

public class Ingresitos implements Runnable {
    
    private Cuenta cuenta;    
    
    private final int idconsumidor;


    Ingresitos(Cuenta cuenta, int idconsumidor) {
        this.cuenta = cuenta;
        this.idconsumidor = idconsumidor;
        
    }
    
    @Override
    public void run() {
        
        while (true) {
            int random = (int) (Math.random() * 100);
            try {
                cuenta.meter(random, idconsumidor);
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ingresitos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}

