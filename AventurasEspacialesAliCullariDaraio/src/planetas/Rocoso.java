package planetas;

import recursos.*;
import utilidades.GenerarRandom;

public class Rocoso extends Planeta{

	public Rocoso() {
		super("Rocoso");
	}
	
	@Override
	public Recurso generarRecurso() {
		int probabilidad = GenerarRandom.generarNumeroRandom(1, 100);
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
		return null;
	}
}
