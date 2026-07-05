package planetas;

import recursos.*;


public class Planeta {
    private String nombre;

    public Planeta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Recurso generarRecurso() {
        return null;
    }
}