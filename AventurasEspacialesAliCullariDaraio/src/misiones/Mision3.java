package misiones;

import recursos.*;
import java.util.ArrayList;
import java.util.List;

public class Mision3 extends Mision{
    public Mision3 () {
        super  ("núcleo de energía principal", 250,  new ArrayList<Recurso>(List.of(
                new NucleoEnergetico(), new Obsidiana(), new Obsidiana()
        )));
    }
}
