package m9_uf2_productorconsumidor;

/**
 * Partimos de la base de la practica anterior por lo que si te parece no voy a comentar
 * mas que lo que aparece en Cuenta.java
 * @author Alejandro
 */
public class ProductorConsumidor {

    private static Thread[] ingresitos;
    private static Thread[] consumixtos;
    private static final int LIANTES_CONSUMIXTOS = 2;
    private static final int LIANTES_INGRESITOS = 2;

    public static void main(String[] args) {

        Cuenta cuenta = new Cuenta();
        ingresitos = new Thread[LIANTES_INGRESITOS];
        consumixtos = new Thread[LIANTES_CONSUMIXTOS];

       
        for (int i = 0; i < LIANTES_INGRESITOS; i++) {

            ingresitos[i] = new Thread(new Ingresitos(cuenta, i));
            ingresitos[i].start();

        }

        for (int i = 0; i < LIANTES_CONSUMIXTOS; i++) {

            consumixtos[i] = new Thread(new Consumixtos(cuenta, i));
            consumixtos[i].start();

        }

    }

}