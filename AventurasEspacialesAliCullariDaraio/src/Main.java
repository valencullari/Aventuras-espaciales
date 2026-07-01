import entidades.Jugador;
import entrada.Entrada;
import enums.TipoPlaneta;
import naves.*;
import planetas.Planeta;
import recursos.*;
import java.util.ArrayList;


public class Main {

    final static int PRECIO_REPARACION = 25, MIN_OPC_MENU = 1, MAX_OPC_MENU_VENTAS = 3;


    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        final int MAX_OPC_MENU_PRINCIPAL = 8, MAX_OPC_MENU_PLANETAS = 3;

        boolean flag = true;
        System.out.println("Bienvenido a Aventuras Espaciales");
        Jugador jugador = crearJugador(entrada);
        jugador.setNave(seleccionarNaves(entrada));
        jugador.mostrarInformacion();
        jugador.getNave().mosrarInformacion();
        do {
            if(jugador.getPlanetaActual().getTipo() == TipoPlaneta.BASE ) {
                mostrarMenuPrincipal(entrada);
                int opcion = entrada.ingresarEntero(MIN_OPC_MENU,  MAX_OPC_MENU_PRINCIPAL);
                flag = ejecutarOpcionBase(opcion, jugador, entrada );
            } else {
                mostarMenuPlaneta(jugador, entrada);
                int opcion = entrada.ingresarEntero(MIN_OPC_MENU, MAX_OPC_MENU_PLANETAS);
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
                
                jugador.getNave().getBodega().agregarRecurso(new Plasma(), jugador.getNave().getCapacidadMaxima());
                jugador.getNave().getBodega().agregarRecurso(new Plasma(), jugador.getNave().getCapacidadMaxima());
                jugador.getNave().getBodega().agregarRecurso(new Plasma(), jugador.getNave().getCapacidadMaxima());
                if(jugador.getNave().getBodega().getListaRecursos() == null) {
                    System.out.println("La bodega está vacía.");
                } else {
                    jugador.getNave().getBodega().mostrarBodega();
                }

                jugador.getNave().getBodega().eliminarRecurso(new Plasma());
                jugador.getNave().getBodega().mostrarBodega();
                break;
            case 3:
                boolean flag = true;
                jugador.getNave().getBodega().agregarRecurso(new Plasma(), jugador.getNave().getCapacidadMaxima());
                jugador.getNave().getBodega().agregarRecurso(new Plasma(), jugador.getNave().getCapacidadMaxima());
                jugador.getNave().getBodega().agregarRecurso(new Obsidiana(), jugador.getNave().getCapacidadMaxima());
                if (jugador.getNave().getBodega().getPesoUtilizado() == 0) {
                    System.out.println("No tenes recursos para vender");
                } else {
                    do {
                        menuVentas();
                        int opcionVenta = entrada.ingresarEntero(MIN_OPC_MENU, MAX_OPC_MENU_VENTAS);
                        flag = ejecutarOpcionVentas(opcionVenta, jugador, entrada);
                    } while (flag);
                }
                break;
            case 4:
                System.out.println("Ver misiones disponibles");
                break;
            case 5:
                System.out.println("Entregar recursos para una misión");
                break;
            case 6:
                if(jugador.getNave().getVida() >= 100) {
                    System.out.println("La nave ya tiene 100 de vida. No es necesario repararla.");
                } else if(jugador.getCreditosEspaciales() < PRECIO_REPARACION) {
                    System.out.println("No tienes suficientes créditos espaciales para reparar la nave. Necesitas al menos 25 créditos espaciales. Actualmente tienes: " + jugador.getCreditosEspaciales() + " créditos espaciales. ");
                } else if(jugador.getCreditosEspaciales() >= PRECIO_REPARACION && jugador.getNave().getVida() < 100) {
                    repararNave(jugador, entrada);
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

    public static void menuVentas() {
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Vender recursos");
        System.out.println("2. Vender todos los recursos");
        System.out.println("3. Salir del menú de ventas");
    }

    public static boolean ejecutarOpcionVentas(int opcion, Jugador jugador, Entrada entrada) {
        switch (opcion) {
            case 1:
                System.out.println("Vender recurso especifico");
                    venderRecursos(jugador, entrada);
                break;
            case 2:
                System.out.println("Vender todos los recursos");
                //falta implementar la logica de vender todos los recursos
                break;
            case 3:
                System.out.println("Saliendo del menú de ventas...");
                return false;
        }
        return true;
    }

    private static void venderRecursos(Jugador jugador, Entrada entrada) {
        jugador.getNave().getBodega().mostrarBodega();
        System.out.println("Ingrese el nombre del recurso que desea vender:");
        String nombreRecurso = entrada.ingresarTexto();
        ArrayList<Recurso> recursos= jugador.getNave().getBodega().getListaRecursos();
        for(int i = 0 ;i < jugador.getNave().getBodega().getListaRecursos().size(); i++) {
            if(recursos.get(i).getNombre().equalsIgnoreCase(nombreRecurso)){
                jugador.getNave().getBodega().eliminarRecurso(recursos.get(i));
                break;
            }
        }
        jugador.getNave().getBodega().mostrarBodega();
        
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
        int opcionPlaneta = entrada.ingresarEntero(MIN_OPC_MENU, getPlanetas().length-1);
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
        int vidaReparar = 10;

        System.out.println("¿Cuántas veces deseas reparar la nave? (1-10):");
        int cantVecesReparar = entrada.ingresarEntero(1, 10);
        if((jugador.getNave().getVida()+vidaReparar*cantVecesReparar) >= 110) {
            System.out.println("No puedes reparar la nave más de 100 de vida. La nave tiene actualmente " + jugador.getNave().getVida() + " puntos de vida.");
            return;
        } else if(jugador.getCreditosEspaciales() < PRECIO_REPARACION * cantVecesReparar ) {
            System.out.println("No tienes suficientes créditos espaciales para reparar la nave " + cantVecesReparar + " veces. Precio de reparación: 25 créditos espaciales por reparación.");
            return;
        } else {
            for(int i = 0; i < cantVecesReparar; i ++) {
                jugador.getNave().reparar(vidaReparar);
                jugador.restarCreditos(PRECIO_REPARACION);
            }
            System.out.println("La nave ha sido reparada " + cantVecesReparar + " veces. Vida actual: " + jugador.getNave().getVida() + ". Créditos espaciales restantes: " + jugador.getCreditosEspaciales());
        }
    }


}
