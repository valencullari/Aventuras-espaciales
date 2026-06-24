package entrada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

    private Scanner s = new Scanner(System.in);

    public int ingresarEntero(int min, int max) {
        boolean error = false;
        int opc = 0;
        do {
            error = false;
            try {
                opc = s.nextInt();
                if (opc < min || opc > max) {
                    error = true;
                    System.out.println("Opcion no valida, ingrese un numero entre " + min + " y " + max);
                }
            } catch (InputMismatchException e) {
                error = true;
                System.out.println("Tipo de dato mal ingresado");
            } finally {
                s.nextLine();
                if (error) {
                    System.out.println("Ingrese nuevamente");
                }
            }
        } while (error);
        return opc;
    }

    public String ingresarTexto() {
        return s.nextLine();
    }

    public void cerrarScanner() {
        s.close();
    }

}
