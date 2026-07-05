package peligrosEspaciales;

import enums.Velocidad;
import utilidades.GenerarRandom;

public class TormentaCosmica extends PeligroEspacial{
	
	@Override
	public int calcularDanio(Velocidad velocidad) {
		return GenerarRandom.generarNumeroRandom(5, 20);
	}

}
