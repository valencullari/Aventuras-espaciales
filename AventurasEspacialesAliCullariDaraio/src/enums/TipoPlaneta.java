package enums;

public enum TipoPlaneta {   
    
    ROCOSO("Rocoso"), 
    GASEOSO("Gaseoso"), 
    VOLCANICO("Volcánico");

    private final String nombre;

    TipoPlaneta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
}
