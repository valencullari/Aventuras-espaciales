package recursos;

public class Recurso {
    private String nombre;
    private int peso;
    private int valorVenta;

    public Recurso(String nombre, int peso, int valorVenta) {
        this.nombre = nombre;
        this.peso = peso;
        this.valorVenta = valorVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    public int getValorVenta() {
        return valorVenta;
    }

}
