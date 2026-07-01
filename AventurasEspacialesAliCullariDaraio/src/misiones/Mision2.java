package misiones;

import recursos.*;
import java.util.ArrayList;
import java.util.List;

public class Mision2 extends Mision{
    public Mision2 () {
        super  ("estabilización del reactor", 170,  new ArrayList<>(List.of(
                new Gas(), new Gas(), new Plasma()
        )));
    }
}
