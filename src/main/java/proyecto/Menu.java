
package Proyecto;

import java.io.*;

public class Menu {
    public static void main(String [] args) throws IOException{
        
        Gestion lec = new Gestion();
        lec.llenadoBus();
        lec.llenadoConductores();
        int opc;
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        do{
            System.out.println("*******************************************");
            System.out.println("                 Menu                        ");
            System.out.println("********************************************");
            System.out.println("Opcion 1: Agregar Conductor");
            System.out.println("Opcion 2: Agregar Bus");
            System.out.println("Opcion 3: Mostrar Buses");
            System.out.println("Opcion 4: Mostrar Conductores");
            System.out.println("Opcion 5: Buscar Conductores Por Rut");
            System.out.println("Opcion 6: Mostrar Buses Y sus conductores");
            System.out.println("Opcion 0: Salir");
            opc = Integer.parseInt(leer.readLine());
            
            switch(opc) {
                case 1: lec.AgregarConductor(); break;
                case 2: lec.AgregarBus("main");break;
                case 3: lec.MostrarBuses(); break;
                case 4: lec.MostrarConductores(); break;
                case 5: lec.BuscarConductoresRut(); break;
                case 6: lec.MostrarBusesyConductores(); break;
                case 0: lec.exportar(); break;
                default: System.out.println("Invalido"); break;
            }
        }while(opc != 0);
        
    }
}
