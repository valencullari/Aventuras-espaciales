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
        if((this.pesoUtilizado + recurso.getPeso()) <= capacidadMax) {
            listaRecursos.add(recurso);
            this.pesoUtilizado += recurso.getPeso();
        }
    }

    public void eliminarRecurso(Recurso recursoQuitar) {
       for(int i = 0; i < this.listaRecursos.size(); i++){
        if (listaRecursos.get(i).getNombre().equals(recursoQuitar.getNombre())) {
            listaRecursos.remove(i);
            this.pesoUtilizado -= recursoQuitar.getPeso();
            System.out.println("Se ha eliminado el recurso: " + recursoQuitar.getNombre());
            break;
        }
       }
    }

    public ArrayList<Recurso> getListaRecursos() {
        return listaRecursos;
    }

    public void mostrarBodega() {
        int cantCristal = 0, cantGas = 0, cantLava = 0, cantMineralComun = 0, cantNucleoEnergetico = 0, cantObsidiana = 0, cantPlasma = 0;
        Recurso[] recursosTotales = new Recurso[] {
            new Cristal(), new Gas(), new Lava(), new MineralComun(), new NucleoEnergetico(), new Obsidiana(), new Plasma()
        };
        
        System.out.println("Bodega de carga:");
        for (Recurso recurso : listaRecursos) {
            if (recurso instanceof Cristal) {
                cantCristal++;
            } else if (recurso instanceof Gas) {
                cantGas++;
            } else if (recurso instanceof Lava) {
                cantLava++;
            } else if (recurso instanceof MineralComun) {
                cantMineralComun++;
            }else if (recurso instanceof NucleoEnergetico) {
                cantNucleoEnergetico++;
            } else if (recurso instanceof Obsidiana) {
                cantObsidiana++;
            } else if (recurso instanceof Plasma) {
                cantPlasma++;
            }    
        }
       
        if(cantCristal>0) {
             System.out.println(recursosTotales[0].getNombre() + " (Peso: " + recursosTotales[0].getPeso() + ", Valor de venta: " + recursosTotales[0].getValorVenta() +", Cantidad: " + cantCristal + ")");
        }
        if(cantGas>0) {
            System.out.println(recursosTotales[1].getNombre() + " (Peso: " + recursosTotales[1].getPeso() + ", Valor de venta: " + recursosTotales[1].getValorVenta() +", Cantidad: " + cantGas + ")");
        }
        if(cantLava>0) {
            System.out.println(recursosTotales[2].getNombre() + " (Peso: " + recursosTotales[2].getPeso() + ", Valor de venta: " + recursosTotales[2].getValorVenta() + ", Cantidad: " + cantLava +")");
        }   
        if(cantMineralComun>0) {
            System.out.println(recursosTotales[3].getNombre() + " (Peso: " + recursosTotales[3].getPeso() + ", Valor de venta: " + recursosTotales[3].getValorVenta() + ", Cantidad: " + cantMineralComun + ")");
        }      
        if(cantNucleoEnergetico>0) {
            System.out.println(recursosTotales[4].getNombre() + " (Peso: " + recursosTotales[4].getPeso() + ", Valor de venta: " + recursosTotales[4].getValorVenta() + ", Cantidad: " + cantNucleoEnergetico + ")");
        }   
        if(cantObsidiana>0) {
            System.out.println(recursosTotales[5].getNombre() + " (Peso: " + recursosTotales[5].getPeso() + ", Valor de venta: " + recursosTotales[5].getValorVenta() + ", Cantidad: " + cantObsidiana + ")");
        }
        if(cantPlasma>0) {
            System.out.println(recursosTotales[6].getNombre() + " (Peso: " + recursosTotales[6].getPeso() + ", Valor de venta: " + recursosTotales[6].getValorVenta() + ", Cantidad: " + cantPlasma + ")");
        }
        System.out.println("Peso total utilizado: " + this.pesoUtilizado);
    }

}


