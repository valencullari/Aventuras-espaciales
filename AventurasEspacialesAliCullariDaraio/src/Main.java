import entidades.Jugador;
import entrada.Entrada;
import enums.TipoPlaneta;
import misiones.Mision;
import misiones.Mision1;
import misiones.Mision2;
import misiones.Mision3;
import naves.*;
import planetas.Planeta;
import recursos.*;
import utilidades.GenerarRandom;

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

    // --- MENÚ PRINCIPAL Y FLUJO BASE ---

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

    public static boolean ejecutarOpcionBase(int opcion, Jugador jugador, Entrada entrada) {


        switch (opcion) {
            case 1:
                viajarPlaneta(jugador, entrada);
                break;
            case 2:
                if(jugador.getNave().getBodega().getListaRecursos() == null) {
                    System.out.println("La bodega está vacía.");
                } else {
                    jugador.getNave().getBodega().mostrarBodega();
                }
                break;
            case 3:
                boolean flag = true;
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
                mostrarMisiones(jugador);
                break;
            case 5:
                System.out.println("Ingrese la mision que desea completar");
                mostrarMisiones(jugador);
                int indice = entrada.ingresarEntero(1,3);
                completarMision(jugador,indice-1);
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

    // --- CASE 1: VIAJES Y PLANETAS ---

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

    // --- CASE 3: VENTAS Y MENÚ DE VENTAS ---

    public static void menuVentas() {
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Vender recurso especifico");
        System.out.println("2. Vender todos los recursos");
        System.out.println("3. Salir del menú de ventas");
    }

    public static boolean ejecutarOpcionVentas(int opcion, Jugador jugador, Entrada entrada) {
        switch (opcion) {
            case 1:
                venderRecurso(jugador, entrada);
                break;
            case 2:
                venderTodosRecursos(jugador);
                break;
            case 3:
                System.out.println("Saliendo del menú de ventas...");
                return false;
        }
        return true;
    }

    private static void venderRecurso(Jugador jugador, Entrada entrada) {
        boolean flag = false;
        jugador.getNave().getBodega().mostrarBodega();
        System.out.println("Ingrese el nombre del recurso que desea vender:");
        String nombreRecurso = entrada.ingresarTexto();
        ArrayList<Recurso> recursos = new ArrayList<>(jugador.getNave().getBodega().getListaRecursos());
        for(Recurso recurso : recursos) {
            if(recurso.getNombre().equalsIgnoreCase(nombreRecurso)){
                jugador.getNave().getBodega().eliminarRecurso(recurso);
                jugador.sumarCreditos(recurso.getValorVenta());
                flag = true;
                break;
            }
        }
        if(flag) {
            System.out.println("El recurso se vendio correctamente. Ahora tiene " + jugador.getCreditosEspaciales() + " creditos espaciales.");
        } else {
            System.out.println("No se pudo vender el articulo correctamente");
        }

    }

    public static void venderTodosRecursos(Jugador jugador) {
        ArrayList<Recurso> recursos = new ArrayList<>(jugador.getNave().getBodega().getListaRecursos());
        for(Recurso recurso : recursos) {
            jugador.getNave().getBodega().eliminarRecurso(recurso);
            jugador.sumarCreditos(recurso.getValorVenta());
        }
        jugador.getNave().getBodega().mostrarBodega();
        System.out.println("Los recursos se vendieron correctamente. Ahora tiene " + jugador.getCreditosEspaciales() + " creditos espaciales.");
    }

    // --- CASE 4: MISIONES ---

    public static void mostrarMisiones(Jugador jugador){
        Mision[] mision = jugador.getMisiones();
        for(int i = 0; i<jugador.getMisiones().length;i++){

            System.out.println("");
            System.out.println("Mision " + (i+1));
            mision[i].mostrarMision();
        }
    }

    // --- CASE 5 : Entrega de recursos de mision
/*
    public static void completarMision(Jugador jugador, int indice){


        ArrayList<Recurso> recursosMision = jugador.getMision(indice).getRecursosRequeridos();
        ArrayList<Recurso> recursosBodega = jugador.getNave().getBodega().getListaRecursos();

        if (recursosBodega == null ) {
            System.out.println("No tienes recursos en la bodega.");
            return;
        }

        for(int i = 0; i<jugador.getNave().getBodega().getListaRecursos().size();i++){
            Recurso recursoBodega = recursosBodega.get(i);
            for(int j =0; j < recursosMision.size(); j++) {
                Recurso recursoMision = recursosMision.get(j);
                if (recursoBodega.getNombre().equalsIgnoreCase(recursoMision.getNombre())) {

                }

            }
        }



    }*/
   public static void completarMision(Jugador jugador, int indice){

    Mision mision = jugador.getMision(indice);

    ArrayList<Recurso> requeridos = new ArrayList<>(mision.getRecursosRequeridos());
    ArrayList<Recurso> bodega = jugador.getNave().getBodega().getListaRecursos();

    

    // Verificar que cada recurso requerido exista en la bodega (teniendo en cuenta repeticiones)
    ArrayList<Recurso> copiaBodega = new ArrayList<>(bodega);
    for (Recurso req : requeridos) {
        boolean encontrado = false;
        for (int i = 0; i < copiaBodega.size(); i++) {
            if (copiaBodega.get(i).getNombre().equalsIgnoreCase(req.getNombre())) {
                copiaBodega.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No tienes todos los recursos necesarios. Falta: " + req.getNombre());
            return;
        }
    }

    // Si llegamos acá, se tienen todos los recursos: eliminarlos de la bodega real
    for (Recurso req : requeridos) {
        jugador.getNave().getBodega().eliminarRecurso(req);
    }

    // Entregar recompensa y marcar misión completada (requiere getters/setters en Mision)
    jugador.sumarCreditos(mision.getRecompensa());
    mision.setCompletado(true);

    System.out.println("Misión completada. Has recibido " + mision.getRecompensa() + " créditos espaciales.");
}

    // --- CASE 6 Y 7: REPARACIÓN Y DESCANSO ---

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

    public static void descansar(Jugador jugador) {
        jugador.setEnergia(100);
        System.out.println("El jugador " + jugador.getNombre() + " ha descansado y recuperado energía al 100%.");
    }

    // --- MENÚ SECUNDARIO: LÓGICA DE JUEGO EN PLANETAS ---

    private static void mostarMenuPlaneta(Jugador jugador, Entrada entrada) {
        System.out.println("\nTe encuentras en el planeta " + jugador.getPlanetaActual().getTipo().getNombre() + ", ingrese una opcion:");
        System.out.println("1. Minar recursos");
        System.out.println("2. Viajar a otro planeta");
        System.out.println("3. Regresar a la base");

    }

    public static void ejecutarOpcionPlaneta(int opcion, Jugador jugador, Entrada entrada) {
        switch (opcion) {
            case 1:
                int energiaGastar = GenerarRandom.generarNumeroRandom(10,25);
                if(jugador.getEnergia() >= energiaGastar) {
                    System.out.println("Se gasto " + energiaGastar + " puntos de energia. Energia restante: " + (jugador.getEnergia() - energiaGastar));
                    minarRecursos(jugador, energiaGastar);
                } else {
                    System.out.println("No podes minar, no tenes la energia suficiente. Energia restante: " + jugador.getEnergia());
                }
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

    private static void minarRecursos(Jugador jugador, int energiaGastar) {
        jugador.getNave().getBodega().agregarRecurso(jugador.getPlanetaActual().generarRecurso(), jugador.getNave().getCapacidadMaxima());
        jugador.restarEnergia(energiaGastar);
    }

    // --- INICIALIZACIÓN: CREACIÓN DE JUGADOR Y NAVES ---

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

}