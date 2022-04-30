
package Proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    
    //**************************************************
    
    public void agregarBus(Bus aa){
        buses.add(aa);
    }
    
    public void MostrarBuses(){
        //int flag = 0;
        if(buses.isEmpty()){
            System.out.println("El conductor no tiene ningun bus asociado");
        }else{
                
            for(int i = 0; i < buses.size(); i++){
                System.out.println("Numero de Bus: "+buses.get(i).getNumeroBus());
                System.out.println("Matricula: "+buses.get(i).getMatricula());
                System.out.println("Ciudad Salida: "+buses.get(i).getCiudadInicio());
                System.out.println("Ciudad Destino: "+buses.get(i).getCiudadFinal());
            }
        
        }
        //System.out.println("No hay bus asignado")
    }
    
    public boolean eliminarBuses(int num){
            /*
            //opcion 1
            for(int j = i ; j < buses.size() - 1 ; j++){
                // vaciar
                buses.get(j).setCiudadFinal(null);
                buses.get(j).setCiudadInicio(null);
                buses.get(j).setMatricula(null);
                buses.get(j).setNumeroBus(0);

                // cambiar posicion

                buses.get(j).setCiudadFinal(buses.get(j+1).getCiudadFinal());
                buses.get(j).setCiudadInicio(buses.get(j+1).getCiudadInicio());
                buses.get(j).setMatricula(buses.get(j+1).getMatricula());
                buses.get(j).setNumeroBus(buses.get(j+1).getNumeroBus());

            }
            // vaciar
            buses.get(buses.size() - 1).setCiudadFinal(null);
            buses.get(buses.size() - 1).setCiudadInicio(null);
            buses.get(buses.size() - 1).setMatricula(null);
            buses.get(buses.size() - 1).setNumeroBus(0);
            */
            // opcion 2
        boolean existe = false;
        for(int i = 0 ; i < buses.size() ; i++){
            if(buses.get(i).getNumeroBus() == num) {
                buses.remove(i);
                existe = true;
                break;
            } 
        }
        return existe;
    }
    
}
