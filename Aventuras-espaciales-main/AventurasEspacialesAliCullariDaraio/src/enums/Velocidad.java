package enums;

public enum Velocidad {
    BAJA("Baja", 20),
    MEDIA("Media", 40),
    ALTA("Alta", 60);

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
