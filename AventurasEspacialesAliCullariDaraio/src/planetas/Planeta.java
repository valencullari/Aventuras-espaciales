package planetas;

import recursos.*;
import enums.TipoPlaneta;
import utilidades.GenerarRandom;

public class Planeta {
    private TipoPlaneta tipo;

    public Planeta(TipoPlaneta tipo) {
        this.tipo = tipo;
    }

    public TipoPlaneta getTipo() {
        return tipo;
    }

    public Recurso generarRecurso() {
        int probabilidad = GenerarRandom.generarNumeroRandom(1, 100);
        switch (tipo) {
            case ROCOSO:
                if (probabilidad <= 60) {
                    System.out.println("Se a obtenido mineral comun");
                    return new MineralComun();
                } else if (probabilidad <= 85) {
                    System.out.println("Se a obtenido cristal");
                    return new Cristal();
                } else if (probabilidad <= 100) {
                    System.out.println("Se a obtenido nucleo energetico");
                    return new NucleoEnergetico();
                }
                break;

            case GASEOSO:
                if (probabilidad <= 60) {
                    System.out.println("Se a obtenido gas");
                    return new Gas();
                } else if (probabilidad <= 85) {
                    System.out.println("Se a obtenido plasma");
                    return new Plasma();
                } else if (probabilidad <= 100) {
                    System.out.println("Se a obtenido cristal");
                    return new Cristal();
                }
                break;

            case VOLCANICO:
                if (probabilidad <= 50) {
                    System.out.println("Se a obtenido lava");
                    return new Lava();
                } else if (probabilidad <= 80) {
                    System.out.println("Se a obtenido obsidiana");
                    return new Obsidiana();
                } else if (probabilidad <=  100) {
                    System.out.println("Se a obtenido mineral comun");
                    return new MineralComun();
                }
                break;
            default:
                return null;
        }
        return null;
    }
}