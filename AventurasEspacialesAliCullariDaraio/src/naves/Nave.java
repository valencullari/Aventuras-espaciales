package naves;

import enums.Velocidad;

public class Nave {
    private String nombre;
    private Velocidad velocidad;
    private int capacidadMaxima;
    public int capacidadActual = 0;
    private int vida = 100;

    public Nave(String nombre, Velocidad velocidad, int capacidadMaxima) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.capacidadMaxima = capacidadMaxima;

    }

    public String getNombre() {
        return nombre;
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

}

        
            
                    
        

