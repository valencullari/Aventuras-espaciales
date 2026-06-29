package naves;

import java.util.ArrayList;
import recursos.*;

public class Bodega {
    private ArrayList<Recurso> listaRecursos = new ArrayList<>(); 
    private int pesoUtilizado = 0;
    

    public int getPesoUtilizado() {
        return pesoUtilizado;
    }


    public void agregarRecurso(Recurso recurso, int capacidadMax) {
        if((this.pesoUtilizado + recurso.getPeso()) < capacidadMax) {
            listaRecursos.add(recurso);
            this.pesoUtilizado += recurso.getPeso();
        }
    }

    public void eliminarRecurso(Recurso recursoQuitar) {
        //EXPLICACION DE ESTE IF
        // .remove(objeto) busca el objeto(en este caso recurso), lo borra si existe y devuelve true, si no devuelve false y nunca entra a sacar el peso.
        if(listaRecursos.remove(recursoQuitar)) { 
            this.pesoUtilizado -= recursoQuitar.getPeso();
        }
    }

    public void mostrarBodega() {
        System.out.println("Bodega de carga:");
        for (Recurso recurso : listaRecursos) {
            System.out.println("- " + recurso.getNombre() + " (Peso: " + recurso.getPeso() + ", Valor de venta: " + recurso.getValorVenta() + ")");
        }
        System.out.println("Peso total utilizado: " + this.pesoUtilizado);
    }
    



}


