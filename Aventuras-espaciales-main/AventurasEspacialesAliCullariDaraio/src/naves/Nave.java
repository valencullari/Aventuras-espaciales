package naves;

import enums.Velocidad;

public class Nave {

    private final int VIDA_MAXIMA = 100;
    private final int VIDA_MINIMA = 0;
    private String nombre;
    private Velocidad velocidad;
    private int capacidadMaxima;
    private int capacidadActual = 0;
    private int vida = VIDA_MAXIMA;

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
        if (vida >= VIDA_MINIMA && vida <= VIDA_MAXIMA) {
            this.vida = vida;
        } else if (vida > VIDA_MAXIMA) {
            this.vida = VIDA_MAXIMA;
        } else if (vida < VIDA_MINIMA) {
            this.vida = VIDA_MINIMA;
        }
    }

    public void sumarVida (int vida) {
        setVida((this.vida+vida));
    }


    public int getCapacidadActual() {
        return capacidadActual;
    }
    
    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

     public void reparar(int cantVidaReparar) {
        sumarVida(cantVidaReparar);
        
    }



}

        
            
                    
        

