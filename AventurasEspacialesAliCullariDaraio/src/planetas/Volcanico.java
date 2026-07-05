package planetas;

import recursos.*;
import utilidades.GenerarRandom;

public class Volcanico extends Planeta{

	public Volcanico() {
		super("Volcanico");
	}
	
	@Override
	public Recurso generarRecurso() {
		int probabilidad = GenerarRandom.generarNumeroRandom(1, 100);
		if (probabilidad <= 50) {
            System.out.println("Se a obtenido lava");
            return new Lava();
        } else if (probabilidad <= 80) {
            System.out.println("Se a obtenido obsidiana");
            return new Obsidiana();
        } else if (probabilidad <= 100) {
            System.out.println("Se a obtenido nucleo energetico");
            return new NucleoEnergetico();
        }
		return null;
	}

}
