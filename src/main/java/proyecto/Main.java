package proyecto;

import Ventanas.VentanaMain;
import java.io.IOException;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */
public class Main {

    /**
     * Metodo principal del programa 
     * @param args Argumento de entrada del main
     * @throws IOException
     */
    public static void main(String [] args) throws IOException {
        Gestion gestion = new Gestion();
        gestion.llenadoConductores();
        gestion.llenarPasajeros();
        gestion.llenadoBus();
        new VentanaMain(gestion);
        
    }
}
