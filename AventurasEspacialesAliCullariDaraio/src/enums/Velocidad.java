package enums;

public enum Velocidad {
    BAJA("Baja", 60),
    MEDIA("Media", 40),
    ALTA("Alta", 20);

    private String nombre;
    private int probabilidadPeligro;

    Velocidad(String nombre, int probabilidadPeligro) {
        this.nombre = nombre;
        this.probabilidadPeligro = probabilidadPeligro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProbabilidadPeligro() {
        return probabilidadPeligro;
    }
}
