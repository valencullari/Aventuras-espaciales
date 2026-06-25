package utilidades;

public class GenerarRandom {

   
    public static int generarNumeroRandom(int limite) {
        return (int) (Math.random() * limite);
    }

    public static int generarNumeroRandom(int minimo, int maximo) {
        return minimo + (int) (Math.random() * (maximo - minimo + 1));
    }
}
