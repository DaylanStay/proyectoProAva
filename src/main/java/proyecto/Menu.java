
package proyecto;

import Ventanas.VentanaMain;
import java.io.*;

/**
 *
 * @author cesar
 */
public class Menu{
    
    /**
     * Constructor de la clase Menu que sirve para instanciar una variable
     */
    public Menu(){
    }
    
    /**
     * Metodo que contiene al menu del programa con sus distintas opciones
     * @throws IOException
     */
    public void Menu() throws IOException{
        Gestion lec = new Gestion();
        lec.llenadoConductores();
        lec.llenarPasajeros();
        lec.llenadoBus();
        int opc;
        BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
        do{
            System.out.println("*******************************************");
            System.out.println("                 Menu                        ");
            System.out.println("********************************************");
            System.out.println("Opcion 1: Agregar Conductor");
            System.out.println("Opcion 2: Agregar Bus");
            System.out.println("Opcion 3: Buscar Conductores Por Rut");
            System.out.println("Opcion 4: Menu Mostrar [Interfaz]");
            System.out.println("Opcion 5: Eliminar Bus");
            System.out.println("Opcion 6: Eliminar Conductor");
            System.out.println("Opcion 7: Modificar Conductor");
            System.out.println("Opcion 8: Modificar Bus");
            System.out.println("Opcion 9: Exportar Excel");
            System.out.println("Opcion 10: Conductor Menor");
            System.out.println("Opcion 11: Salida De Buses (Conjunto de buses)");
            System.out.println("Opcion 12: Destino De Buses (Conjunto de buses)");
            System.out.println("Opcion 13: Mostrar personas por RUT");
            System.out.println("Opcion 14: Mostrar pasajeros de un bus");
            System.out.println("Opcion 0: Salir y Exportar");
            opc = Integer.parseInt(leer.readLine());
            
            switch(opc) {
                case 1: 
                {
                    lec.AgregarConductor();
                    break;
                } 
                case 2: 
                {
                    lec.AgregarBus();//lec.AgregarBus("");
                    break;
                } 
                case 3: 
                {
                    //lec.BuscarConductoresRut();
                    break;
                } 
                case 4: 
                {
                    new VentanaMain(lec);
                    break;
                } 
                case 5: 
                {
                    lec.eliminarBus();
                    break;
                } 
                case 6: {
                    lec.eliminarConductor();
                    break;
                } 
                case 7: {
                    lec.editarConductor();
                    break;
                } 
                case 8: 
                {
                    lec.editarBus();
                    break;
                } 
                case 9:
                {
                    lec.exportarExcel();
                    break;
                    
                }
                case 10:
                {
                    //lec.conductorMenor();
                    break;
                    
                }
                case 11:
                {
                    //lec.BusesPorViaje();
                    break;
                    
                }
                case 12:
                {
                    //lec.BusesPorViajeDestino();
                    break;
                    
                }
                
                case 13:
                {
                   lec.mostrarPersonas();
                    break;
                }
                case 14:
                {
                    lec.mostrarPasajeros();
                    break;
                }
                case 0: 
                {
                    lec.exportar();
                    break;
                } 
                default: 
                {
                    System.out.println("Invalido");
                    break;
                } 
            }
        }while(opc != 0);
        
    }

    

 
}
