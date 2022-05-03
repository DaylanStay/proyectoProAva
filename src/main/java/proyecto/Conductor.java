package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Conductor {
    private String nombre;
    private String rut;
    private String edad;
    private ArrayList<Bus> buses;
    
    //Sobrecarga de metodos constructor
    public Conductor(String nombre, String rut, String edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        buses = new ArrayList();
    }
    
     public Conductor(String nombre, String rut, String edad,ArrayList i) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        buses = new ArrayList();
        buses.addAll(i);
    }

    public Conductor() {
       buses = new ArrayList();
    }
    
    //*******************************************************************
    //Metodos Getter & Setter
    //*******************************************************************

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }
    
    //**************************************************
    
    public void agregarBus(Bus aa){
        buses.add(aa);
    }
    
    public String MostrarBuses(){
        String cadena = "";
        if(buses.isEmpty()){
            System.out.println("El conductor no tiene ningun bus asociado");
        }else{

            for(int i = 0; i < buses.size(); i++){
                cadena += "Número Bus: " + buses.get(i).getNumeroBus() + "\n";
                cadena += "Matrícula: " + buses.get(i).getMatricula() + "\n";
                cadena += "Ciudad Inicial: " + buses.get(i).getCiudadInicio() + "\n";
                cadena += "Ciudad Final: " + buses.get(i).getCiudadFinal() + "\n";

            }

        }
        return cadena;
    }
    
    public void eliminarBuses(int num){
        for(int i = 0 ; i < buses.size() ; i++){
            if(buses.get(i).getNumeroBus() == num) {
                buses.remove(i);
                break;
            } 
        }
    }

    public void eliminarBuses(String matricula){
        for(int i = 0 ; i < buses.size() ; i++){
            if(buses.get(i).getMatricula().equals(matricula)) {
                buses.remove(i);
                break;
            } 
        }
    }

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
}
