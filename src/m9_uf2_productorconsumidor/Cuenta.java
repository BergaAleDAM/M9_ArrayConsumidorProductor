package m9_uf2_productorconsumidor;


class Cuenta {

    /**
     * En esta practica vemos como pasamos de meter y sacar valores de un numero
     * de cuenta pasamos a tener un array de 10 numeros que serás llenados en un 
     * momento para sacarlo mas adelante, para eso nos sirven las variables que vemos
     * debajo. LA primera nos dice cuanto ocupa el array y las siguientes nos servirán
     * para tener un registro del punto exacto en el que se encuentra tanto
     * consumixtos como ingresitos
     */
    private int[] cuentaArray = new int[10];
    private int contadorMeter = 0, contadorSacar = 0;
    
    private boolean ingresoTraspaso = Boolean.TRUE;


    public synchronized void meter(int valor, int idconsumidor) throws InterruptedException {
        while (!ingresoTraspaso) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error al meter dinerito -> " + e.getMessage());
            }

        }
        ingresoTraspaso = !ingresoTraspaso;
/**
 * Aqui empiza lo relevante donde decimos que el puntero será siempre el módulo del tamaño máximo
 * del array para nunca apuntar a un valor superior del mismo
 */
        int puntero = contadorMeter%10;
        
        /**
         * en caso que se quiera meter en una casilla que haya un valor no te dejará 
         * porque ya está siendo ocupada y se muestra un mensaje en consecuencia
         */
        if(contadorMeter >= contadorSacar+cuentaArray.length){
            
                
            System.out.println("Buffer lleno...");
        }else{
            // Por otra parte si no ocurre lo anterior se le asigna un valor y se añade
            //al contador
            cuentaArray[puntero] = valor;
                contadorMeter ++;
        }
        System.out.print("Cuenta [");
        for (int i = 0; i < cuentaArray.length; i++) {
        System.out.print( cuentaArray[i] + "," );
        
        }
        int punteroMarca = puntero+1;
        System.out.print("]" + "Posicio de meter"+ punteroMarca+ "\n");
        
        //Estas ultimas lineas simplemente sirven para mostrar informacion
        
        
            
        ingresoTraspaso = !ingresoTraspaso;
        notifyAll();
    

    
}
    
    public synchronized void sacar(int valor, int idconsumidor) throws InterruptedException {
        
      
        while (!ingresoTraspaso) {
        
            
            try {
                
                wait();
                    
                
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error al saca dinerito -> " + e.getMessage());
            }

        }
        ingresoTraspaso = !ingresoTraspaso;

        int puntero = contadorSacar%10;
        
        
        if(contadorSacar >= contadorMeter){
            
            System.out.println("Buffer vacío...");
                
            
        }else{
            cuentaArray[puntero] = 0;
                
            if(contadorMeter >= contadorSacar+1){ 
            contadorSacar ++;
            }
        }
        
        System.out.print("Cuenta [");
        for (int i = 0; i < cuentaArray.length; i++) {
        System.out.print( cuentaArray[i] + "," );
        
        }
        
        int punteroMarca = puntero+1;
        System.out.print("]" + "Posicio de treure"+ punteroMarca + "\n");
        
        
            ingresoTraspaso = !ingresoTraspaso;
        notifyAll();
    }
    
}