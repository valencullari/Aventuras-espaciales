package planetas;

import recursos.*;
import enums.TipoPlaneta;
import utilidades.GenerarRandom;

public class Planeta {
    private TipoPlaneta tipo;

    public Planeta(TipoPlaneta tipo) {
        this.tipo = tipo;
    }

    public Recurso generarRecurso() {
        int probabilidad = GenerarRandom.generarNumeroRandom(1, 100);
        switch (tipo) {
            case TipoPlaneta.ROCOSO:
                if (probabilidad < 60) {
                    return new MineralComun();
                } else if (probabilidad < 85) {
                    return new Cristal();
                } else if (probabilidad < 100) {
                    return new NucleoEnergetico();
                }
                break;

            case TipoPlaneta.GASEOSO:
                if (probabilidad < 60) {
                    return new Gas();
                } else if (probabilidad < 85) {
                    return new Plasma();
                } else if (probabilidad < 100) {
                    return new Cristal();
                }
                break;

            case TipoPlaneta.VOLCANICO:
                if (probabilidad < 50) {
                    return new Lava();
                } else if (probabilidad < 80) {
                    return new Obsidiana();
                } else if (probabilidad < 100) {
                    return new MineralComun();
                }
                break;
            default:
                return null;
        }
        return null;
    }
}