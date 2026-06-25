package naves;

import enums.Velocidad;

public class Nave {
    private String nombre;
    private Velocidad velocidad;
    private int capacidadMaxima;
    private int capacidadActual = 0;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida >= 0 && vida <= 100) {
            this.vida = vida;
        }
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }
    
    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

     public void reparar() {
        if (this.vida <= 90) {
            this.vida += 10;
        } else {
            this.vida = 100;
        }
        
    }



}

        
            
                    
        

