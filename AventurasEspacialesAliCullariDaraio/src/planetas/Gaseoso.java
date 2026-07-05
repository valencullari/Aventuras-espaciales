package planetas;

import recursos.*;
import utilidades.GenerarRandom;

public class Gaseoso extends Planeta {

	public Gaseoso() {
		super("Gaseoso");
	}
	
	@Override
	public Recurso generarRecurso() {
		int probabilidad = GenerarRandom.generarNumeroRandom(1, 100);
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
		return null;
	}

}
