import entidades.Jugador;
import entrada.Entrada;
import naves.*;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();

        System.out.println("Bienvenido a Aventuras Espaciales");
        crearJugador(entrada);
        Nave nave = mostrarNaves(entrada);

        mosrarInformacionNave(nave);
        mostrarMenuPrincipal(entrada);

        entrada.cerrarScanner();

    }

    public static void mostrarMenuPrincipal(Entrada entrada) {
        System.out.println("Menú principal:");
        System.out.println("1. Viajar a un planeta");
        System.out.println("2. Ver bodega de carga");
        System.out.println("3. Vender recursos");
        System.out.println("4. Ver misiones disponibles");
        System.out.println("5. Entregar recursos para una misión");
        System.out.println("6. Reparar nave");
        System.out.println("7. Descansar");
        System.out.println("8. Salir del juego");
    }

    public static void mosrarInformacionNave(Nave nave) {
        System.out.println("Nave seleccionada: " + nave.getNombre());
        System.out.println("Velocidad: " + nave.getVelocidad().getNombre());
        System.out.println("Capacidad máxima: " + nave.getCapacidadMaxima() + " Toneladas");
        System.out.println("Capacidad actual: " + nave.capacidadActual);
    }

    public static void crearJugador(Entrada entrada) {

        System.out.println("Ingrese el nombre del jugador:");
        String nombre = entrada.ingresarTexto();
        Jugador jugador = new Jugador(nombre);
        System.out.println("Jugador creado: " + jugador.getNombre());

    }

    public static Nave mostrarNaves(Entrada entrada) {
        Nave[] navesAux = new Nave[] {
                new Fenix(),
                new Eclipse(),
                new Galaxian()
        };

        System.out.println("Naves disponibles:");
        for (int i = 0; i < navesAux.length; i++) {
            System.out.println((i + 1) + ". " + navesAux[i].getNombre() + " - Velocidad: "
                    + navesAux[i].getVelocidad().getNombre() + " - Capacidad: " + navesAux[i].getCapacidadMaxima()
                    + "Toneladas");
        }

        System.out.println("Seleccione una nave (1-" + navesAux.length + "):");
        int opcion = entrada.ingresarEntero(1, navesAux.length);
        return crearNave(opcion);
    }

    private static Nave crearNave(int opcion) {
        switch (opcion) {
            case 1:
                return new Fenix();
            case 2:
                return new Eclipse();
            case 3:
                return new Galaxian();
        }
        return null;
    }

}
