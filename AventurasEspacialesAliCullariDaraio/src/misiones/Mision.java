package misiones;

import recursos.*;
import java.util.ArrayList;

public class Mision {

        private String nombre;
        private ArrayList<Recurso> recursosRequeridos = new ArrayList<>();
        private int recompensa;
        private boolean completado = false;

        public Mision(String nombre, int recompensa, ArrayList<Recurso> recursosRequeridos) {
            this.nombre=nombre;
            this.recompensa=recompensa;
            this.recursosRequeridos = recursosRequeridos;

        }

        public void mostrarMision() {
            int cantCristal = 0, cantGas = 0, cantLava = 0, cantMineralComun = 0, cantNucleoEnergetico = 0, cantObsidiana = 0, cantPlasma = 0;
            Recurso[] recursosTotales = new Recurso[] {
                    new Cristal(), new Gas(), new Lava(), new MineralComun(), new NucleoEnergetico(), new Obsidiana(), new Plasma()
            };

            for (Recurso recurso : recursosRequeridos) {
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
            System.out.println("Nombre: " + this.nombre);
            System.out.println("Recompensa: " + this.recompensa);
            if(this.completado) {
                System.out.println("La mision esta completada");
            } else {
                System.out.println("La mision esta pendiente");
            }
            System.out.println("Recursos requeridos:");
            if(cantCristal>0) {
                System.out.println(recursosTotales[0].getNombre() + ", Cantidad: " + cantCristal);
            }
            if(cantGas>0) {
                System.out.println(recursosTotales[1].getNombre() + ", Cantidad: " + cantGas);
            }
            if(cantLava>0) {
                System.out.println(recursosTotales[2].getNombre() + ", Cantidad: " + cantLava);
            }
            if(cantMineralComun>0) {
                System.out.println(recursosTotales[3].getNombre() + ", Cantidad: " + cantMineralComun);
            }
            if(cantNucleoEnergetico>0) {
                System.out.println(recursosTotales[4].getNombre() + ", Cantidad: " + cantNucleoEnergetico);
            }
            if(cantObsidiana>0) {
                System.out.println(recursosTotales[5].getNombre() + ", Cantidad: " + cantObsidiana);
            }
            if(cantPlasma>0) {
                System.out.println(recursosTotales[6].getNombre() + ", Cantidad: " + cantPlasma);
            }

        }


}
