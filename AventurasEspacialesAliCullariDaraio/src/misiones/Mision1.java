package misiones;

import java.util.ArrayList;
import java.util.List;
import recursos.*;

public class Mision1 extends Mision{
    public Mision1 () {
        super  ("reparación del casco exterior", 120,  new ArrayList<>(List.of(
                new MineralComun(), new MineralComun(), new MineralComun(), new Cristal()
        )));
    }
}
