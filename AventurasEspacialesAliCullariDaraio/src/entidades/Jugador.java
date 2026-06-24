package entidades;

import naves.Nave;

public class Jugador {
    private String nombre;
    private int energia = 100;
    private int creditosEspaciales = 0;
    private Nave nave;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
