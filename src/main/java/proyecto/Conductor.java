
package Proyecto;

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

    Conductor() {
       
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

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public void setBuses(ArrayList<Bus> buses) {
        this.buses = buses;
    }
    
    //**************************************************
    
    public void agregarBus(Bus aa){
        buses.add(aa);
    }
    
    public void MostrarBuses(){
        int flag = 0;
        
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
        
        
        
    }
    
    
}
