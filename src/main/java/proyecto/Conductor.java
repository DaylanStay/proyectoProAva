package proyecto;
import java.util.*;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */

public class Conductor extends Persona implements Datos{
    private int numero;
    //Sobrecarga de metodos constructor
    

    /**
     * Constructor de la clase Conductor, usada para instanciar una variable usando variables
     * @param nombre Nombre del Conductor
     * @param rut RUT que le pertenece al Conductor ( de valor unico )
     * @param edad Edad que tiene el Conductor
     * @param numeroBus Numero del Bus
     */
    public Conductor(String nombre, String rut, String edad,int numeroBus) {
        super(nombre, rut, edad);
        this.numero = numeroBus;
    }
    
    /**
     * Constructor de la clase Conductor, usado para instanciar variable usando variables
     * @param nombre Nombre del Conductor
     * @param rut RUT que le pertenece a lDoncutor ( de valor unico )
     * @param edad Edad que tiene el Conductor
     * @param i Arraylist de buses que viene con informacion de Buses
     */
    public Conductor(String nombre, String rut, String edad,ArrayList i) {
        super(rut, nombre, edad);
    }

    /**
     * Constructor de la clase Conductor, usado para instancia una variable.
     */
    public Conductor() {
       super();
    }
    
    /**
     * Metodo getter que obtiene el numero de un bus
     * @return Numero del bus
    */
    
    public int getNumero() {
        return numero;
    }
    
    /**
     * Metodo setter que ingresa el numero de un bus
     * @param numero numero del Bus
    */

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    //**************************************************
    /**
     * Metodo que muestra por pantalla los datos de los conductores mediante el numero de RUT.
     */
    @Override
    public String mostrarPersonaPorRut() {
        String cadena = "";
        cadena += "RUT del Conductor: " + getRut() + "\n";
        cadena += "Nombre del Conductor: " + getNombre() + "\n";
        return cadena;
    }

    /**
     * Metodo que muestra por pantalla los datos de los conductores.
     */
    @Override
    public void mostrarDatos() {
        System.out.println("RUT del conductor: " + getRut() + "\n");
        System.out.println("Nombre del conductor: " +getNombre() + "\n");
        System.out.println("Edad del conductor: " +getEdad() + "\n");
    }

    /**
     * Metodo que retorna una cadena con la informacion de los conductores
     * @return cadena con la informacion de los conductores
     */
    @Override
    public String cadenaDatos() {
        return "RUT Conductor: " + getRut() + "\n" + "Nombre: "+ getNombre() + "\n" + "Edad: " +getEdad() + "\n";
    }
}
