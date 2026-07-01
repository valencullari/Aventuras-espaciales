package entidades;

import enums.TipoPlaneta;
import naves.Nave;
import planetas.Planeta;

public class Jugador {
    private String nombre;
    private int energia = 100;
    private int creditosEspaciales = 0;
    private Nave nave;
    private Planeta planetaActual = new Planeta(TipoPlaneta.BASE);

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEnergia(int energia) {
        if (energia >= 0 && energia <= 100) {
            this.energia = energia;
        }
    }

    public int getEnergia() {
        return energia;
    }

    public void setCreditosEspaciales(int creditosEspaciales) {
        if (creditosEspaciales < 0){
            this.creditosEspaciales = 0;
        } else {
            this.creditosEspaciales = creditosEspaciales;
        }
    }

    public void restarCreditos(int creditosRestar) {
        setCreditosEspaciales(this.creditosEspaciales-creditosRestar);
    }

    public void sumarCreditos (int creditos) {
        setCreditosEspaciales((this.creditosEspaciales+creditos));
    }

    public int getCreditosEspaciales() {
        return creditosEspaciales;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public Planeta getPlanetaActual() {
        return planetaActual;
    }

    public void setPlanetaActual(Planeta planetaActual) {
        this.planetaActual = planetaActual;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Energía: " + this.energia);
        System.out.println("Créditos espaciales: " + this.creditosEspaciales);
    }
}
