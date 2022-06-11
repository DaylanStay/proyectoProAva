package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Cesar Maureira
 * @author Felipe Gonzalez
 * @author Felipe Chavez
 * @author Dylan Estay
 */

public class Conductor extends Persona implements Datos{
    private ArrayList<Bus> buses;
    private int numero;
    //Sobrecarga de metodos constructor
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Constructor de la clase Conductor, usada para instanciar una variable usando variables
     * @param nombre Nombre del Conductor
     * @param rut RUT que le pertenece al Conductor ( de valor unico )
     * @param edad Edad que tiene el Conductor
     */
    public Conductor(String nombre, String rut, String edad,int numeroBus) {
        super(nombre, rut, edad);
        this.numero = numeroBus;
        buses = new ArrayList();
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
        buses = new ArrayList();
        buses.addAll(i);
    }

    /**
     * Constructor de la clase Conductor, usado para instancia una variable.
     */
    public Conductor() {
       super();
       buses = new ArrayList();
    }
    
    //*******************************************************************
    //Metodos Getter & Setter
    //*******************************************************************

    
    //**************************************************

    /**
     * Metodo que agrega un bus a la lista
     * @param aa
     */
    public void agregarBus(Bus aa){
        buses.add(aa);
    }
    
    /**
     * Metodo que sirve para mostrar por pantalla los datos de los buses
     * @return cadena que contiene la informacion de los buses del Arraylist
     */
    public String MostrarBuses(){
        String cadena = "";
        if(buses.isEmpty()){
            System.out.println("El conductor no tiene ningun bus asociado");
        }else{

            for(int i = 0; i < buses.size(); i++){
                cadena += buses.get(i).cadenaDatos();
                buses.get(i).mostrarDatos();
            }

        }
        return cadena;
    }
    
    /**
     * Metodo que te elimina un bus por el numero del bus
     * @param num Numero del Bus
     */
    public void eliminarBuses(int num){
        for(int i = 0 ; i < buses.size() ; i++){
            if(buses.get(i).getNumeroBus() == num) {
                buses.remove(i);
                break;
            } 
        }
    }

    /**
     * Metodo que te elimina un bus por la matricula del bus
     * @param matricula Matricula del Bus
     */
    public void eliminarBuses(String matricula){
        for(int i = 0 ; i < buses.size() ; i++){
            if(buses.get(i).getMatricula().equals(matricula)) {
                buses.remove(i);
                break;
            } 
        }
    }

    /**
     * Metodo que modifica a los buses mediante su numero de bus
     * @param nBus numero del bus
     * @throws IOException
     */
    public void editarBuses(int nBus) throws IOException{
        for(int i = 0 ; i < buses.size() ; i++){
            if(buses.get(i).getNumeroBus() == nBus) {
                BufferedReader leer = new BufferedReader(new InputStreamReader (System.in));
                String aux;
                int opc;

                System.out.println("Ingrese la opcion que desea cambiar:");
                System.out.println("Opcion 1: Ciudad inicial");
                System.out.println("Opcion 2: Ciudad final");
                System.out.println("Opcion 3: Matrícula");
                opc = Integer.parseInt(leer.readLine());

                switch(opc){
                    case 1:
                    {
                        System.out.println("Ingrese la ciudad inicial");
                        aux = leer.readLine();
                        buses.get(i).setCiudadInicio(aux);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Ingrese la ciudad final");
                        aux = leer.readLine();
                        buses.get(i).setCiudadFinal(aux);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Ingrese la nueva matrícula");
                        aux = leer.readLine();
                        buses.get(i).setMatricula(aux);
                        break;
                    }
                    default: 
                    {
                        System.out.println("Invalido");
                        break;
                    }
                }
                break;
            }
        }
    }
    
    /**
     * Metodo que muestra por pantalla el recorrido de los buses ya sea por la partida o por el final
     * @param ciudad ciudad donde empieza o termina el recorrido del bus
     * @param id numero que sirve como un auxiliar para saber si se muestra por la ciudad inicial o por la ciudad final
     */
    public void BusesPorViaje(String ciudad , int id) {
        for(int i = 0; i < buses.size() ; i++) {
            if(buses.get(i).getCiudadInicio().equals(ciudad) && id == 0) {
                System.out.println("---------------------------------------");
                System.out.println("Bus Número: "+buses.get(i).getNumeroBus());
                System.out.println("Matrícula: "+buses.get(i).getMatricula());
                System.out.println("Llegada: "+buses.get(i).getCiudadFinal());
            }
            
             if(buses.get(i).getCiudadFinal().equals(ciudad) && id == 1) {
                System.out.println("---------------------------------------");
                System.out.println("Bus Número: "+buses.get(i).getNumeroBus());
                System.out.println("Matrícula: "+buses.get(i).getMatricula());
                System.out.println("Partida: " +buses.get(i).getCiudadInicio());
            }
        }
    }
    

    /**
     * Metodo que muestra por pantalla los datos de los conductores mediante el numero de RUT.
     */
    public String mostrarPersonaPorRut() {
        String cadena = "";
        cadena += "RUT del Conductor: " + getRut() + "\n";
        cadena += "Nombre del Conductor: " + getNombre() + "\n\n";
        
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
