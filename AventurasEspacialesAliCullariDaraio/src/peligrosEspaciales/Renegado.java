package peligrosEspaciales;

import enums.Velocidad;
import utilidades.GenerarRandom;

public class Renegado extends PeligroEspacial{
	
	@Override
	public int calcularDanio(Velocidad velocidad) {
		int dañoRealizar;
		if(velocidad.equals(Velocidad.BAJA)) {
			dañoRealizar = GenerarRandom.generarNumeroRandom(3, 15)*2;
		} else {
			dañoRealizar = GenerarRandom.generarNumeroRandom(3, 15);
		}
		
		return dañoRealizar;
	}

}
