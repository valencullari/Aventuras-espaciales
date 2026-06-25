import entidades.Jugador;
import entrada.Entrada;
import enums.TipoPlaneta;
import naves.*;
import planetas.Planeta;

public class Main {
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        Planeta[] planetas = getPlanetas();
        boolean flag = true;
        System.out.println("Bienvenido a Aventuras Espaciales");
        Jugador jugador = crearJugador(entrada);
        jugador.setNave(seleccionarNaves(entrada));
        mostrarInformacionJugador(jugador);
        mosrarInformacionNave(jugador.getNave());
        do {
            if(jugador.getPlanetaActual().getTipo() == TipoPlaneta.BASE ) {
                mostrarMenuPrincipal(entrada);
                int opcion = entrada.ingresarEntero(1, 8);
                flag = ejecutarOpcionBase(opcion, jugador, entrada );
            } else {
                mostarMenuPlaneta(jugador, entrada);
                int opcion = entrada.ingresarEntero(1, 3);
                ejecutarOpcionPlaneta(opcion, jugador, entrada);
            }
        } while (flag);
        
        entrada.cerrarScanner();

    }

    private static void mostarMenuPlaneta(Jugador jugador, Entrada entrada) {
        System.out.println("\nTe encuentras en el planeta " + jugador.getPlanetaActual().getTipo().getNombre() + ", ingrese una opcion:");
        System.out.println("1. Minar recursos");
        System.out.println("2. Viajar a otro planeta");
        System.out.println("3. Regresar a la base");

    }

    private static Planeta[] getPlanetas() {
        return new Planeta[] {
                new Planeta(TipoPlaneta.BASE),
                new Planeta(TipoPlaneta.ROCOSO),
                new Planeta(TipoPlaneta.GASEOSO),
                new Planeta(TipoPlaneta.VOLCANICO)
        };
    }

    public static void mostrarPlanetas(Planeta[] planetas) {
        for (int i = 1; i < planetas.length; i++) {
            System.out.println((i) + ". " + planetas[i].getTipo().getNombre());
        }
    }

    public static boolean ejecutarOpcionBase(int opcion, Jugador jugador, Entrada entrada) {
        
        
        switch (opcion) {
            case 1:
                viajarPlaneta(jugador, entrada);
                break;
            case 2:
                System.out.println("Ver bodega de carga");
                break;
            case 3:
                System.out.println("Vender recursos");
                break;
            case 4:
                System.out.println("Ver misiones disponibles");
                break;
            case 5:
                System.out.println("Entregar recursos para una misión");
                break;
            case 6:
                if(jugador.getCreditosEspaciales() >= 25 && jugador.getNave().getVida() < 100) {
                    repararNave(jugador, entrada);
                }else if(jugador.getNave().getVida() >= 100) {
                    System.out.println("La nave ya tiene 100 de vida. No es necesario repararla.");
                }else{
                    System.out.println("No tienes suficientes créditos espaciales para reparar la nave. Necesitas al menos 25 créditos espaciales. Actualmente tienes: " + jugador.getCreditosEspaciales() + " créditos espaciales. ");
                }
                break;
            case 7:
                descansar(jugador);
                break;
            case 8:
                System.out.println("Saliendo del juego...");

                return false;
                
        }
        return true;
        
    }

    public static void ejecutarOpcionPlaneta(int opcion, Jugador jugador, Entrada entrada) {
        switch (opcion) {
            case 1:
                System.out.println("Minar recursos");
                //falta implementar la logica de minar recursos
                break;
            case 2:
                viajarPlaneta(jugador, entrada);
                break;
            case 3:
                System.out.println("Regresar a la base");
                jugador.setPlanetaActual(new Planeta(TipoPlaneta.BASE));
                break;
        }
    }


    public static void mostrarMenuPrincipal(Entrada entrada) {
        System.out.println("\nMenú principal:");
        System.out.println("1. Viajar a un planeta");
        System.out.println("2. Ver bodega de carga");
        System.out.println("3. Vender recursos");
        System.out.println("4. Ver misiones disponibles");
        System.out.println("5. Entregar recursos para una misión");
        System.out.println("6. Reparar nave");
        System.out.println("7. Descansar");
        System.out.println("8. Salir del juego");
    }

    public static void mostrarInformacionJugador(Jugador jugador) {
        System.out.println("Nombre: " + jugador.getNombre());
        System.out.println("Energía: " + jugador.getEnergia());
        System.out.println("Créditos espaciales: " + jugador.getCreditosEspaciales());
    }

    public static void mosrarInformacionNave(Nave nave) {
        System.out.println("Nave seleccionada: " + nave.getNombre());
        System.out.println("Velocidad: " + nave.getVelocidad().getNombre());
        System.out.println("Capacidad máxima: " + nave.getCapacidadMaxima() + " Toneladas");
        System.out.println("Capacidad actual: " + nave.getCapacidadActual());
    }

    public static Jugador crearJugador(Entrada entrada) {

        System.out.println("Ingrese el nombre del jugador:");
        String nombre = entrada.ingresarTexto();
        Jugador jugador = new Jugador(nombre);
        System.out.println("Jugador creado: " + jugador.getNombre());
        return jugador;

    }

    public static Nave seleccionarNaves(Entrada entrada) {
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

    private static void viajarPlaneta(Jugador jugador, Entrada entrada) {
        System.out.println("Seleccione un planeta para viajar:");
        mostrarPlanetas(getPlanetas());
        int opcionPlaneta = entrada.ingresarEntero(1, getPlanetas().length-1);
        if(jugador.getPlanetaActual().getTipo() == getPlanetas()[opcionPlaneta].getTipo()) {
            System.out.println("Ya te encuentras en el planeta " + jugador.getPlanetaActual().getTipo().getNombre() + ". No puedes viajar al mismo planeta.");
            return;
        }
        jugador.setPlanetaActual(opcionPlaneta == 1 ? new Planeta(TipoPlaneta.ROCOSO) : opcionPlaneta == 2 ? new Planeta(TipoPlaneta.GASEOSO) : new Planeta(TipoPlaneta.VOLCANICO));
        System.out.println("Viajaste al planeta " + jugador.getPlanetaActual().getTipo().getNombre());
    }

    public static void descansar(Jugador jugador) {
        jugador.setEnergia(100);
        System.out.println("El jugador " + jugador.getNombre() + " ha descansado y recuperado energía al 100%.");
    }

    public static void repararNave(Jugador jugador, Entrada entrada) {
        System.out.println("¿Cuántas veces deseas reparar la nave? (1-10):");
        int cantVecesReparar = entrada.ingresarEntero(1, 10);
        if(jugador.getNave().getVida()+10*cantVecesReparar >= 110) {
            System.out.println("No puedes reparar la nave más de 100 de vida. La nave tiene actualmente " + jugador.getNave().getVida() + " puntos de vida.");
            return;
        } else if(jugador.getCreditosEspaciales() < 25 * cantVecesReparar ) {
            System.out.println("No tienes suficientes créditos espaciales para reparar la nave " + cantVecesReparar + " veces. Precio de reparación: 25 créditos espaciales por reparación.");
            return;
        } else {
            for(int i = 0; i < cantVecesReparar; i ++) {
                jugador.getNave().reparar();
                jugador.setCreditosEspaciales(jugador.getCreditosEspaciales() - 25);
            }
            System.out.println("La nave ha sido reparada " + cantVecesReparar + " veces. Vida actual: " + jugador.getNave().getVida() + ". Créditos espaciales restantes: " + jugador.getCreditosEspaciales());
        }
    }


}
